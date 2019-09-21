package org.ironforge.starter.base.conf;

import brave.Tracer;
import feign.Feign;
import lombok.extern.slf4j.Slf4j;
import org.ironforge.starter.base.utils.SpringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.cloud.openfeign.FeignAutoConfiguration;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.event.EventListener;

@Configuration
@Slf4j
public class IronforgeStart {

    @Autowired(required = false)
    private Tracer tracer;

    @EventListener
    public void start(ApplicationStartedEvent applicationStartedEvent){
        log.info("ironforge 初始化开始");
        SpringUtils.init(tracer);
        log.info("ironforge 初始化结束");
    }
}
