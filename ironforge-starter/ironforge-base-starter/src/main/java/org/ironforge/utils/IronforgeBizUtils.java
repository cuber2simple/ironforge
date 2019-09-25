package org.ironforge.utils;

import org.ironforge.err.IronforgeException;

public class IronforgeBizUtils {
    public static IronforgeException transfer(Throwable throwable) {
        IronforgeException ironforgeException = null;
        if (throwable instanceof IronforgeException) {
            ironforgeException = (IronforgeException) throwable;
        } else {
            ironforgeException = new IronforgeException(throwable);
        }
        return ironforgeException;
    }
}
