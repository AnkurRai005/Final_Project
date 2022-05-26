package org.npci.itemapp.services;

import java.util.List;

import org.npci.itemapp.model.CategoryEntity;
import org.npci.itemapp.model.DepartmentEntity;
import org.npci.itemapp.model.ItemEntity;
import org.npci.itemapp.model.UserEntity;

public interface ItemAppService {

	UserEntity saveUserDetails(UserEntity user);
	
	ItemEntity saveItemDetails(ItemEntity item);
	
	List<ItemEntity> getItemData(Integer catId, Integer depId);
	
	ItemEntity updateItemDetails(ItemEntity item);
	
	CategoryEntity saveCategoryDetails(CategoryEntity category);
	
	DepartmentEntity saveDepartmentDetails(DepartmentEntity department);
}
