package org.ironforge.hystrix;

import org.ironforge.err.IronforgeException;

public class BaseFeignClientFallback {

    protected IronforgeException ironforgeException;

    public BaseFeignClientFallback(IronforgeException ironforgeException) {
        this.ironforgeException = ironforgeException;
    }
}
