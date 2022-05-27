package org.npci.itemapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.Table;

import lombok.Data;

@Data
@Entity
@Table(name="item")
public class ItemEntity {

	@Id
	@Column(name="item_id")
	private int itemId;
	
	@Column(name="item_name")
	private String itemName;
	
	@Column(name="item_type")
	private String itemType;
	
	@Column(name="item_desc")
	private String itemDescription;
	
	@Lob
	@Column(name="image")
	private byte[] image;
	
	@Column(name="created_by")
	private int createdBy;
	
	@Column(name="created_date")
	private String createdDate;
	
	@Column(name="updated_by")
	private int updatedBy;
	
	@Column(name="updated_date")
	private String updatedDate;
	
	@Column(name="category_id")
	private int categoryId;
	
	@Column(name="dept_id")
	private int deptId;
}
