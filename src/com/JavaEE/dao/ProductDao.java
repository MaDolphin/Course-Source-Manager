package com.JavaEE.dao;

import com.JavaEE.entity.Product;

import java.util.List;

/**
 * Created by xfcq on 2016/5/11.
 */
public interface ProductDao {
    public boolean addProduct(Product product);
    public boolean deleteProduct(Product product);
    public boolean updateProduct(Product product);
    public Product queryProductByID(String proid);
    public List<Product> allProductsByCourse(String couid);
    public List<Product> allProductByItem(String couid);
}
