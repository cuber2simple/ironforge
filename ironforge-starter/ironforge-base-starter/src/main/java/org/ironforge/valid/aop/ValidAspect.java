package org.ironforge.valid.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.ironforge.valid.ValidExec;
import org.ironforge.valid.anno.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.Objects;

@Aspect
@Component
public class ValidAspect {

    @Autowired
    private ApplicationContext applicationContext;

    @Pointcut("@annotation(org.ironforge.valid.anno.ValidCheck)")
    public void validCheck() {
    }

    @Before("validCheck()")
    public void before(JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        if (Objects.nonNull(args) && args.length > 0) {
            Arrays.stream(args).forEach(this::check);
        }
    }

    private void check(Object obj) {
        Class<?> aClass = obj.getClass();
        Valid valid = aClass.getAnnotation(Valid.class);
        if (Objects.nonNull(valid)) {
            Class<? extends ValidExec> exec = valid.exec();
            ValidExec bean = applicationContext.getBean(exec);
            bean.valid(obj);
        }
    }
}
