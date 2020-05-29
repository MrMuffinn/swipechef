package com.itann.swipechef.services;

import com.itann.swipechef.domain.Ingredient;
import com.itann.swipechef.domain.Product;
import com.itann.swipechef.persistence.ProductDao;

import java.util.List;

public class ProductService {



    private ProductDao dao;

    public ProductService(ProductDao dao) {this.dao =dao ;}

    public Product getById(int id){ return dao.findById(id);}

    public List<Product> getAll(){ return dao.findAll();}

    public boolean save (Product product){ return dao.save(product);}

    public boolean udpate (Product product){ return dao.update(product);}

    public boolean delete (Product product){ return dao.delete(product); }

    public List<Product> getByIngredient(Ingredient ingredient) {return dao.findByIngredient(ingredient);}


}
