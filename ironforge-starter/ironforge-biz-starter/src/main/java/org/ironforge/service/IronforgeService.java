package org.ironforge.service;

import org.apache.commons.collections4.CollectionUtils;
import org.ironforge.utils.ReflectUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public class IronforgeService<Repository extends JpaRepository<T, ID>, T, ID> {

    @Autowired
    private Repository repository;

    T save(T entity) {
        ReflectUtils.fillCreateInfo(entity);
        return repository.save(entity);
    }

    void saveAll(List<T> entities) {
        if (CollectionUtils.isNotEmpty(entities)) {
            entities.forEach(ReflectUtils::fillCreateInfo);
            repository.saveAll(entities);
        }
    }

    T update(T entity) {
        ReflectUtils.fillUpdateInfo(entity);
        return repository.save(entity);
    }

    void updateAll(List<T> entities) {
        if (CollectionUtils.isNotEmpty(entities)) {
            entities.forEach(ReflectUtils::fillUpdateInfo);
            repository.saveAll(entities);
        }
    }

    T getOne(ID id) {
        return repository.getOne(id);
    }

    Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    boolean existsById(ID id) {
        return repository.existsById(id);
    }

    Iterable<T> findAll() {
        return repository.findAll();
    }

    List<T> findAllById(List<ID> ids) {
        if (CollectionUtils.isNotEmpty(ids)) {
            return repository.findAllById(ids);
        }
        return null;
    }

    long count() {
        return repository.count();
    }

    void deleteById(ID id) {
        deleteById(id);
    }

}
