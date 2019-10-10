package org.ironforge.biz;

import org.ironforge.bo.PageReq;
import org.ironforge.bo.PageResp;
import org.ironforge.service.IronforgeService;
import org.ironforge.transfer.AbstractTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public abstract class AbstractBizService<Service extends IronforgeService<JpaRepository<T,ID>,T,ID>, T,ID, BO, BOQuery> extends AbstractTransfer<T, BO> implements IronforgeBizService<BO, BOQuery>{

    @Autowired
    private Service service;

    public AbstractBizService(Class<T> tClass, Class<BO> boClass) {
        super(tClass, boClass);
    }

    @Override
    public BO add(BO role) {
        return null;
    }

    @Override
    public BO edit(BO role) {
        return null;
    }

    @Override
    public PageResp<BO> pageQuery(PageReq<BOQuery> pageReq) {
        return null;
    }

    @Override
    public BO findById(Integer id) {
        return null;
    }
}
