package com.controller.demo.dao;

import java.util.List;


import com.controller.demo.domain.ProductLine;

public interface ProductLineDao {
	void create(ProductLine productline);
	void modify(ProductLine productline);
	void remove(ProductLine productline);
	ProductLine findByPk(int pk);

	List<ProductLine> findAll();
}
