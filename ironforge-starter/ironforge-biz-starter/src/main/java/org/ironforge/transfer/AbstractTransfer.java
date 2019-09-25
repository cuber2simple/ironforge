package org.ironforge.transfer;

import org.apache.commons.collections4.CollectionUtils;

import java.util.List;
import java.util.stream.Collectors;

public abstract class AbstractTransfer<Entity, BO> implements Transfer<Entity, BO> {
    protected Class<Entity> entityClass;

    protected Class<BO> boClass;

    public AbstractTransfer(Class<Entity> entityClass, Class<BO> boClass) {
        this.entityClass = entityClass;
        this.boClass = boClass;
    }

    @Override
    public List<BO> batchTransferBO(List<Entity> entityList) {
        List<BO> boList = null;
        if (CollectionUtils.isNotEmpty(entityList)) {
            boList = entityList.stream().map(this::entityTransferBO).collect(Collectors.toList());
        }
        return boList;
    }

    @Override
    public List<Entity> batchTransferEntity(List<BO> boList) {
        List<Entity> entityList = null;
        if (CollectionUtils.isNotEmpty(boList)) {
            entityList = boList.stream().map(this::boTransferEntity).collect(Collectors.toList());
        }
        return entityList;
    }
}
