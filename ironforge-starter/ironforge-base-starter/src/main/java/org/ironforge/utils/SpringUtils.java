package org.ironforge.utils;

import brave.Span;
import brave.Tracer;
import brave.propagation.ExtraFieldPropagation;
import org.ironforge.bo.AccessDetails;

import java.util.Objects;

public class SpringUtils {
    private static Tracer sleuthTracer;
    private static volatile boolean init;

    public static void init(Tracer tracer) {
        if (!init) {
            sleuthTracer = tracer;
            init = true;
        }
    }

    public static AccessDetails getCurrent() {
        if (Objects.nonNull(sleuthTracer)) {
            Span span = sleuthTracer.currentSpan();
            String userId = ExtraFieldPropagation.get(span.context(), "user-id");
            String userName = ExtraFieldPropagation.get(span.context(), "user-name");
            String merchantId = ExtraFieldPropagation.get(span.context(), "merchant-id");
            String merchantName = ExtraFieldPropagation.get(span.context(), "merchant-name");
            String reqId = ExtraFieldPropagation.get(span.context(), "reqId");
            String token = ExtraFieldPropagation.get(span.context(), "token");
            String customerId = ExtraFieldPropagation.get(span.context(), "customer-id");
            String reqIp = ExtraFieldPropagation.get(span.context(), "req-ip");
            String platform = ExtraFieldPropagation.get(span.context(), "platform");
            AccessDetails accessDetails = new AccessDetails();
            accessDetails.setMerchantId(merchantId);
            accessDetails.setUserId(userId);
            accessDetails.setMerchantName(merchantName);
            accessDetails.setUserName(userName);
            accessDetails.setReqId(reqId);
            accessDetails.setToken(token);
            accessDetails.setCustomerId(customerId);
            accessDetails.setReqIp(reqIp);
            accessDetails.setPlatform(platform);
            accessDetails.setTraceId(span.context().traceIdString());
            return accessDetails;
        }
        return null;
    }
}
