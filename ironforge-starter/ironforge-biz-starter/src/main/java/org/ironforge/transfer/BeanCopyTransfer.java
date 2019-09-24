package org.ironforge.transfer;

import cn.hutool.core.bean.BeanUtil;

public class BeanCopyTransfer<Entity, BO> extends AbstractTransfer<Entity, BO> {

  public BeanCopyTransfer(Class<Entity> entityClass, Class<BO> boClass) {
    super(entityClass, boClass);
  }

  @Override
  public BO entityTransferBO(Entity entity) {
    return BeanUtil.toBean(entity, boClass);
  }

  @Override
  public Entity boTransferEntity(BO bo) {
    return BeanUtil.toBean(bo, entityClass);
  }
}
