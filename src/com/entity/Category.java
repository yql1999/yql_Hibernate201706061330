package com.entity;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

//���ﳵ��
public class Category implements Serializable {

	private static final long serialVersionUID = 1L;

	private Integer category_id;
	private String category_name;
	// �ڹ��ﳵʵ���������ʾ�����Ʒ��һ�����ﳵ�ж����Ʒ
	// hibernateҪ��ʹ�ü��ϱ�ʾ������ݣ�ʹ��set����
	private Set<Items> items = new HashSet<>();

	public Category() {
		super();
	}

	public Category(Integer category_id, String category_name, Set<Items> items) {
		super();
		this.category_id = category_id;
		this.category_name = category_name;
		this.items = items;
	}

	public Integer getCategory_id() {
		return category_id;
	}

	public void setCategory_id(Integer category_id) {
		this.category_id = category_id;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}

	public Set<Items> getItems() {
		return items;
	}

	public void setItems(Set<Items> items) {
		this.items = items;
	}


}
