package org.npci.itemapp.dao;

import java.util.List;

import org.npci.itemapp.model.ItemEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDao extends JpaRepository<ItemEntity, Integer>{

	@Query(value = "select * from item where category_id=:category_id and dept_id=:dept_id", nativeQuery = true)
	public List<ItemEntity> itemselect(@Param("category_id") Integer categoryId, @Param("dept_id") Integer deptId);
}
