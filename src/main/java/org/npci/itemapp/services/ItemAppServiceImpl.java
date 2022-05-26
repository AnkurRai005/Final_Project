package org.npci.itemapp.services;

import java.util.List;
import java.util.Optional;

import org.npci.itemapp.dao.CategoryDao;
import org.npci.itemapp.dao.DepartmentDao;
import org.npci.itemapp.dao.ItemDao;
import org.npci.itemapp.dao.UserDao;
import org.npci.itemapp.exception.InvalidEmailIdException;
import org.npci.itemapp.exception.InvalidPhoneNoException;
import org.npci.itemapp.exception.IntegrityViolationException;
import org.npci.itemapp.model.CategoryEntity;
import org.npci.itemapp.model.DepartmentEntity;
import org.npci.itemapp.model.ItemEntity;
import org.npci.itemapp.model.UserEntity;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemAppServiceImpl implements ItemAppService{

	@Autowired
	private ItemDao itemRepo;
	
	@Autowired
	private UserDao userRepo;
	
	@Autowired
	private CategoryDao catRepo;
	
	@Autowired
	private DepartmentDao deptRepo;
	
	Logger log = LoggerFactory.getLogger("ItemAppService.class");
	
	@Override
	public UserEntity saveUserDetails(UserEntity user) {
		log.info("Saving User details for User Id: {}.",user.getUserId());
		if(!Long.toString(user.getPhoneNo()).matches("^\\d{10}$")) {
			throw new InvalidPhoneNoException("Please Enter Valid Phone Number.");
		}
		else if(!user.getEmailId().matches("^(.+)@(.+)$")) {
			throw new InvalidEmailIdException("Please Enter Valid Email Id");
		}
		UserEntity u = userRepo.save(user);
		log.info("User details for User Id: {} saved.",u.getUserId());
		return u;
	}

	@Override
	public ItemEntity saveItemDetails(ItemEntity item) {
		log.info("Saving User details for User Id: {}.",item.getItemId());
		Optional<UserEntity> u = userRepo.findById(item.getCreatedBy());
		Optional<UserEntity> u1 = userRepo.findById(item.getUpdatedBy());
		Optional<CategoryEntity> c = catRepo.findById(item.getCategoryId());
		Optional<DepartmentEntity> d = deptRepo.findById(item.getDeptId());
		if(!u.isPresent()) {
			throw new IntegrityViolationException("User Not Present for User Id: "+item.getCreatedBy());
		}
		else if(!u1.isPresent()) {
			throw new IntegrityViolationException("User Not Present for User Id: "+item.getUpdatedBy());
		}
		else if(!c.isPresent()) {
			throw new IntegrityViolationException("Category Not Present for Category Id: "+item.getCategoryId());
		}
		else if(!d.isPresent()) {
			throw new IntegrityViolationException("Department Not Present for Department Id: "+item.getDeptId());
		}
		ItemEntity i = itemRepo.save(item);
		log.info("User details for User Id: {} saved.",i.getItemId());
		return i;
	}

	@Override
	public List<ItemEntity> getItemData(Integer catId, Integer depId) {
		log.info("Fetching User details for Category Id: {} and Department Id: {}.",catId,depId);
		List<ItemEntity> itemselect = itemRepo.itemselect(catId, depId);
		log.info("User details for Category Id: {} and Department Id: {} Returned.",catId,depId);
		return itemselect;
	}

	@Override
	public ItemEntity updateItemDetails(ItemEntity item) {
		log.info("Updating Item details for Item Id: {}.",item.getItemId());
		Optional<UserEntity> user = userRepo.findById(item.getCreatedBy());
		Optional<UserEntity> user1 = userRepo.findById(item.getUpdatedBy());
		Optional<CategoryEntity> cat = catRepo.findById(item.getCategoryId());
		Optional<DepartmentEntity> dept = deptRepo.findById(item.getDeptId());
		if(!user.isPresent()) {
			throw new IntegrityViolationException("User Not Present for User Id: "+item.getCreatedBy());
		}
		else if(!user1.isPresent()) {
			throw new IntegrityViolationException("User Not Present for User Id: "+item.getUpdatedBy());
		}
		else if(!cat.isPresent()) {
			throw new IntegrityViolationException("Category Not Present for Category Id: "+item.getCategoryId());
		}
		else if(!dept.isPresent()) {
			throw new IntegrityViolationException("Department Not Present for Department Id: "+item.getDeptId());
		}
		ItemEntity i = itemRepo.save(item);
		log.info("Item details for Item Id: {} updated.",i.getItemId());
		return i;
	}

	@Override
	public CategoryEntity saveCategoryDetails(CategoryEntity category) {
		return catRepo.save(category);
	}

	@Override
	public DepartmentEntity saveDepartmentDetails(DepartmentEntity department) {
		return deptRepo.save(department);
	}
}
