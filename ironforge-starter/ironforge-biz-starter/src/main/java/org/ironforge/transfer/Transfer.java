package org.ironforge.transfer;

import java.util.List;

public interface Transfer<Entity, BO> {

    BO entityTransferBO(Entity entity);

    Entity boTransferEntity(BO bo);

    List<BO> batchTransferBO(List<Entity> entityList);

    List<Entity> batchTransferEntity(List<BO> boList);
}
