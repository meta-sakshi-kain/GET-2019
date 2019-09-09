package com.metacube.factory;

import java.sql.SQLException;

import com.metacube.dao.ProductDao;
import com.metacube.enums.DbType;
import com.metacube.facade.ProductFacade;
import com.metacube.model.Product;

public class Factory {

	public static ProductFacade createProductFacade() {
		return new ProductFacade();
	}

	public static ProductDao createProductDao(DbType dbType) {
		try {
			return new ProductDao(dbType);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
	}
	public Product createProduct(int productCode, String productName,
			String productType, double price) {
		Product product = new Product(productCode, productName, productType,
				price);
		return product;
	}

}
