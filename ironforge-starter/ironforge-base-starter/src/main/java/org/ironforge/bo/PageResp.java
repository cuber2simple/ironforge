package org.ironforge.bo;

import lombok.Data;
import org.ironforge.err.IronforgeException;

import java.util.List;

@Data
public class PageResp<T> extends IronforgeResp<T> {

    public PageResp(IronforgeException ironforgeException) {
        super(ironforgeException);
    }

    public PageResp() {
    }

    private List<T> rows;

    private Long totals;
}
