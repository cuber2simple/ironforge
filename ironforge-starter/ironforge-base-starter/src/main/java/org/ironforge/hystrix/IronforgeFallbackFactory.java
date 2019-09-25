package org.ironforge.hystrix;

import feign.hystrix.FallbackFactory;
import org.ironforge.err.IronforgeException;
import org.ironforge.utils.IronforgeBizUtils;

import java.util.concurrent.ConcurrentHashMap;

public abstract class IronforgeFallbackFactory<T> implements FallbackFactory<T> {

    private ConcurrentHashMap<String, T> insideFallback = new ConcurrentHashMap<>(16);

    @Override
    public T create(Throwable throwable) {
        //不需要
        IronforgeException ironforgeException = IronforgeBizUtils.transfer(throwable);
        String code = ironforgeException.getCode();
        if (!insideFallback.contains(code)) {
            T fallback = createFallback(ironforgeException);
            insideFallback.putIfAbsent(code, fallback);
        }
        return insideFallback.get(code);
    }

    public abstract T createFallback(IronforgeException ironforgeException);


}
