package starter.utils;

import brave.Span;
import brave.Tracer;
import brave.propagation.ExtraFieldPropagation;
import org.ironforge.starter.model.AccessDetails;

import java.util.Objects;

public class SpringUtils {
    private static Tracer sleuthTracer;
    private static volatile boolean init;
    public static void init(Tracer tracer){
        if(!init){
            sleuthTracer = tracer;
            init = true;
        }
    }

    public static AccessDetails getCurrent(){
        if(Objects.nonNull(sleuthTracer)){
            Span span = sleuthTracer.currentSpan();
            String userId = ExtraFieldPropagation.get(span.context(), "user-id");
            String userName = ExtraFieldPropagation.get(span.context(), "user-name");
            String merchantId = ExtraFieldPropagation.get(span.context(), "merchant-id");
            String merchantName = ExtraFieldPropagation.get(span.context(), "merchant-name");
            String reqId = ExtraFieldPropagation.get(span.context(), "reqId");
            String token = ExtraFieldPropagation.get(span.context(), "token");
            AccessDetails accessDetails = new AccessDetails();
            accessDetails.setMerchantId(Long.parseLong(merchantId));
            accessDetails.setUserId(Long.parseLong(userId));
            accessDetails.setMerchantName(merchantName);
            accessDetails.setUserName(userName);
            accessDetails.setReqId(reqId);
            accessDetails.setToken(token);
            return accessDetails;
        }
        return null;
    }
}
