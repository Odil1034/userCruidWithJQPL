package uz.pdp.maven.usercruidwithjpql.service;

import uz.pdp.maven.usercruidwithjpql.entity.BaseEntity;

import java.util.List;

public interface BaseService<M extends BaseEntity> {

    M get(String id);
    void save(M m);
    void delete(String id);
    void update(M m);
    List<M> getAll();

}
