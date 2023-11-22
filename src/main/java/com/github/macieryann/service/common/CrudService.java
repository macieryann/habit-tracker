package com.github.macieryann.service.common;

import com.github.macieryann.common.StatusCode;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public abstract class CrudService<T, ID> {
    private final CrudRepository<T, ID> repository;

    public CrudService(CrudRepository<T, ID> repository) {
        this.repository = repository;
    }

    public T save(T entity) {
        return repository.save(entity);
    }

    public Optional<T> findById(ID id) {
        return repository.findById(id);
    }

    public List<T> findAll() {
        return (List<T>) repository.findAll();
    }

    public void deleteById(ID id) {
        repository.deleteById(id);
    }

    public StatusCode deleteByIdWithStatus(ID id) {
        StatusCode statusCode;
        if (repository.existsById(id)) {
            repository.deleteById(id);
            statusCode = StatusCode.SUCCESS;
        } else {
            // id does not exist
            System.out.println("can't find the entity with ID " + id);
            statusCode = StatusCode.DELETE_ERROR;
        }
        return statusCode;
    }

    public abstract void updateFields(T requestEntity, T fetchedEntity);

    public StatusCode editEntity(ID id, T updatedEntity) {
        StatusCode status;
        if (repository.existsById(id)) {
            // Update the entity by saving the updatedEntity
            repository.save(updatedEntity);
            status = StatusCode.SUCCESS;
        } else {
            // Handle the case where the entity with the given ID does not exist
            System.out.println("can't find the entity");
            status = StatusCode.INSERT_ERROR;
        }
        return status;
    }
}
