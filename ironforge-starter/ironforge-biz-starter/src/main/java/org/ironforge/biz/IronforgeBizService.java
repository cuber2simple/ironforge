package org.ironforge.biz;


import org.ironforge.bo.PageReq;
import org.ironforge.bo.PageResp;

public interface IronforgeBizService<BO, BOQuery> {

    BO add(BO role);

    BO edit(BO role);

    PageResp<BO> pageQuery(PageReq<BOQuery> pageReq);

    BO findById(Integer id);

}
