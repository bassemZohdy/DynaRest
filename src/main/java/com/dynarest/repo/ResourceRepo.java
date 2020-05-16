package com.dynarest.repo;

import javax.persistence.LockModeType;

import com.dynarest.entities.Resource;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;

public interface ResourceRepo extends JpaRepository<Resource,Long> {

    @Lock(LockModeType.OPTIMISTIC_FORCE_INCREMENT)
    <S extends Resource> S save(S entity);
}