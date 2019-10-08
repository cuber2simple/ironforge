package org.ironforge.oauth2.utils;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.MapUtils;
import org.ironforge.bo.Token;
import org.ironforge.constants.IronforgeCode;
import org.ironforge.err.IronforgeException;
import org.ironforge.oauth2.dto.TokenDTO;
import org.ironforge.oauth2.enums.TokenType;
import org.ironforge.oauth2.persist.entity.TClientToken;
import org.ironforge.oauth2.persist.entity.TUser;
import org.ironforge.oauth2.persist.entity.TUserClient;

import java.security.Key;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

@Slf4j
public class JWTUtils {

    public static final DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");

    public static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    public static final String TOKEN_ID = "tokenId";

    public static final String USER_ID = "userId";

    public static final String TOKEN_TYPE = "tokenType";

    public static final String EXPIRE_DATETIME = "expireDatetime";

    public static final String CREATE_DATETIME = "createDateTime";


    public static TClientToken genToken(TUser user, TUserClient tUserClient) {
        Map<String, Object> claimMaps = new HashMap<>(32);
        LocalDateTime now = LocalDateTime.now();
        TClientToken token = null;
        if (Objects.nonNull(user)) {
            token = new TClientToken();
            String id = getTokenId(user.getUserId(), now);
            claimMaps.put(TOKEN_ID, id);
            claimMaps.put(USER_ID, user.getUserId());
            claimMaps.put(TOKEN_TYPE, TokenType.access.getCode());
            LocalDateTime expire = now.plus(tUserClient.getAccessTokenValidity(), ChronoUnit.SECONDS);
            String create = formatter.format(now);
            String expireFormat = formatter.format(expire);
            claimMaps.put(EXPIRE_DATETIME, expireFormat);
            claimMaps.put(CREATE_DATETIME, create);
            String access = Jwts.builder().setClaims(claimMaps).signWith(key).compact();
            token.setAccessToken(access);
            LocalDateTime refreshExpire = expire.plus(tUserClient.getRefreshTokenValidity(), ChronoUnit.SECONDS);
            claimMaps.put(EXPIRE_DATETIME, formatter.format(refreshExpire));
            claimMaps.put(TOKEN_TYPE, TokenType.refresh.getCode());
            String refresh = Jwts.builder().setClaims(claimMaps).signWith(key).compact();
            token.setRefreshToken(refresh);
            token.setCreateDatetime(now);
            token.setUpdateDatetime(now);
            token.setAccessToken(access);
            token.setAppId(tUserClient.getAppId());
            token.setAccessTokenValidity(tUserClient.getAccessTokenValidity());
            token.setRefreshTokenValidity(tUserClient.getRefreshTokenValidity());
            token.setExpireDatetime(refreshExpire);
            token.setId(id);
        }
        return token;
    }

    public static Token genByTokenClient(TClientToken tClientToken) {
        Token token = null;
        if (Objects.nonNull(tClientToken)) {
            token = new Token();
            token.setAccessToken(tClientToken.getAccessToken());
            token.setRefreshToken(tClientToken.getRefreshToken());
            token.setCreateDatetime(formatter.format(tClientToken.getCreateDatetime()));
            token.setExpireDatetime(formatter.format(tClientToken.getExpireDatetime()));
        }
        return token;
    }

    public static TokenDTO detectiveToken(String token) {
        TokenDTO tokenDTO = null;
        try {
            Map<String, Object> claimMaps = Jwts.parser().setSigningKey(key).parseClaimsJws(token).getBody();
            if (MapUtils.isNotEmpty(claimMaps) && claimMaps.containsKey(TOKEN_ID)) {
                tokenDTO = new TokenDTO();
                tokenDTO.setCreateDateTime(MapUtils.getString(claimMaps, CREATE_DATETIME));
                tokenDTO.setExpireDatetime(MapUtils.getString(claimMaps, EXPIRE_DATETIME));
                tokenDTO.setTokenId(MapUtils.getString(claimMaps, TOKEN_ID));
                tokenDTO.setTokenType(MapUtils.getString(claimMaps, TOKEN_TYPE));
                tokenDTO.setUserId(MapUtils.getString(claimMaps, USER_ID));
            }
        } catch (Exception e) {
            throw new IronforgeException(IronforgeCode.INVALID_TOKEN, e);
        }
        return tokenDTO;
    }

    public static String getTokenId(String userId, LocalDateTime dateTime) {
        return formatter.format(dateTime) + userId;
    }


}
