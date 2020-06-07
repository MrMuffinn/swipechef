package com.itann.swipechef.services;


import com.itann.swipechef.domain.Gerecht;
import com.itann.swipechef.domain.Ingredient;
import com.itann.swipechef.persistence.GerechtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class GerechtService{

    @Autowired
    public GerechtRepository gerechtRepository;

    public Optional<Gerecht> getGerechtById(int id) {

        return gerechtRepository.findById(id);
    }

//    public List<Ingredient> getIngredientByGerechtId(int id){
//
//    }

//    public List<Ingredient> getIngredientByGerechten(){
//        return gerechtRepository.getIngredientenByGerecht();
//    }

//    public List<Ingredient> getIngredientenByGerechtId(int id) {
//        List<Ingredient> ingredienten = new ArrayList<Ingredient>();
//        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/swipechef?serverTimezone=EST",
//                "root", "Hanze@25")) {
//            String query = "SELECT I.*  FROM gerecht G, ingredient I  where G.id = ?";
//            PreparedStatement preparedStatement = conn.prepareStatement(query, id);
//            ResultSet resultSet = preparedStatement.executeQuery();
//            while(resultSet.next()){
//                ingredienten.add(new Ingredient(resultSet.getInt("id"),
//                        resultSet.getObject("gerecht"),
//                        resultSet.getInt("hoeveelheidPP"),
//                        resultSet.getObject("product")));
//
//            }
//            return ingredienten;
//        } catch (SQLException e) {
//            System.out.println("could not create a connection");
//            e.printStackTrace();
//        }
//        return null;
//    }

}
