package org.ironforge.biz;

import org.ironforge.service.IronforgeService;
import org.ironforge.transfer.BeanCopyTransfer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

public class BeanCopyBizService<Service extends IronforgeService<? extends JpaRepository<T, ID>, T, ID>, T, ID, BO> extends BeanCopyTransfer<T, BO> implements IronforgeBizService<BO, ID> {

    @Autowired(required = false)
    protected Service service;

    public BeanCopyBizService(Class<T> tClass, Class<BO> boClass) {
        super(tClass, boClass);
    }

    @Override
    public BO add(BO bo) {
        T entity = boTransferEntity(bo);
        return entityTransferBO(service.save(entity));
    }

    @Override
    public BO edit(BO bo) {
        T entity = boTransferEntity(bo);
        return entityTransferBO(service.update(entity));
    }

    @Override
    public BO findById(ID id) {
        T entity = service.findById(id).orElse(null);
        return entityTransferBO(entity);
    }
}
