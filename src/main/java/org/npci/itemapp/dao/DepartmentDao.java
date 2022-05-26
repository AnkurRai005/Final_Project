package org.npci.itemapp.dao;

import org.npci.itemapp.model.DepartmentEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentDao extends JpaRepository<DepartmentEntity, Integer>{

}
