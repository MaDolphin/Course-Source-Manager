package com.JavaEE.daoimpl;

import com.JavaEE.dao.ProductDao;
import com.JavaEE.entity.Product;
import org.springframework.orm.hibernate4.support.HibernateDaoSupport;

import java.sql.Timestamp;
import java.util.List;

/**
 * Created by xfcq on 2016/5/11.
 */
public class ProductDaoImpl extends HibernateDaoSupport implements ProductDao {
    @Override
    public boolean addProduct(Product product) {
        Timestamp date = new Timestamp(System.currentTimeMillis());
        product.setCreateTime(date);
        try{
            this.getHibernateTemplate().save(product);
            return true;
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public boolean deleteProduct(Product product) {
        try{
            this.getHibernateTemplate().delete(product);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean updateProduct(Product product) {
        try{
            this.getHibernateTemplate().saveOrUpdate(product);
            return true;
        }catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public Product queryProductByID(String proid) {
        Product product = (Product) (getHibernateTemplate().get(Product.class,proid));
        return product;
    }

    @Override
    public List<Product> allProductsByCourse(String couid) {
        List a=(List<Product>)this.getHibernateTemplate().find("from Product a where a.couId=? order by a.proName,a.proType,a.proNo asc ",new Object[]{Integer.valueOf(couid)});
        return a;
    }

    @Override
    public List<Product> allProductByItem(String couid) {
        List a=(List<Product>)this.getHibernateTemplate().find("from Product a where a.couId=? group by a.proName",new Object[]{Integer.valueOf(couid)});
        return a;
    }
}
