package com.itann.swipechef.persistence;

import com.itann.swipechef.domain.Gerecht;
import com.itann.swipechef.domain.Ingredient;
import com.itann.swipechef.domain.Product;

import java.util.List;

public interface ProductDao {

    public boolean save(Product product);
    // Zoek alle Producten
    public List<Product> findAll();
    // Zoek een Product op ID
    public Product findById(int id);
    // Edit een Product
    public boolean update(Product product);
    // Verwijder een Product
    public boolean delete(Product product);
    // Zoek alle producten die bij een ingredient horen
    public List<Product> findByIngredient(Ingredient ingredient);
}
