package org.npci.itemapp.controller;


import java.util.List;

import org.npci.itemapp.model.CategoryEntity;
import org.npci.itemapp.model.DepartmentEntity;
import org.npci.itemapp.model.ItemEntity;
import org.npci.itemapp.model.UserEntity;
import org.npci.itemapp.services.ItemAppService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/welcome")
public class ItemController {
	
	@Autowired
	private ItemAppService service;

	@PostMapping("/sitemd")
	public ResponseEntity<String> saveItemDetails(@RequestBody ItemEntity item) {
		ItemEntity i = service.saveItemDetails(item);
		return new ResponseEntity<>("Item Created for Item Id: "+i.getItemId(),HttpStatus.CREATED);
	}
	
	@PostMapping("/suserd")
	public ResponseEntity<String> saveUserDetails(@RequestBody UserEntity user) {
		UserEntity u = service.saveUserDetails(user);
		return new ResponseEntity<>("User Created for User Id: "+u.getUserId(),HttpStatus.CREATED);
	}
	
	@PostMapping("/scatd")
	public ResponseEntity<String> saveCategoryDetails(@RequestBody CategoryEntity category) {
		CategoryEntity c = service.saveCategoryDetails(category);
		return new ResponseEntity<>("Category Created for Category Id: "+c.getCategoryId(),HttpStatus.CREATED);
	}
	
	@PostMapping("/sdeptd")
	public ResponseEntity<String> saveDepartmentDetails(@RequestBody DepartmentEntity department) {
		DepartmentEntity d = service.saveDepartmentDetails(department);
		return new ResponseEntity<>("Department Created for Department Id: "+d.getDeptId(),HttpStatus.CREATED);
	}
	
	@GetMapping("/gitem/{catId}/{depId}")
	public ResponseEntity<List<ItemEntity>> getItemData(@PathVariable Integer catId, @PathVariable Integer depId) {
		List<ItemEntity> itemselect = service.getItemData(catId, depId);
		return new ResponseEntity<>(itemselect, HttpStatus.OK);
	}
	
	@PutMapping("/uitemd")
	public ResponseEntity<String> updateUserDetails(@RequestBody ItemEntity item) {
		ItemEntity i = service.updateItemDetails(item);
		return new ResponseEntity<>("Item Updated for Item Id: "+i.getItemId(),HttpStatus.ACCEPTED);
	}
}
