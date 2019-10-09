package org.ironforge.bo;

import lombok.Data;

@Data
public class PageReq<T> {

    private Integer pageSize;

    private Integer previousLastId;

    private T pageQuery;

}
