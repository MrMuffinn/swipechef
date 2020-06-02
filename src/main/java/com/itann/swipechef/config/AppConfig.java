package com.itann.swipechef.config;

import com.itann.swipechef.domain.Gebruiker;
import com.itann.swipechef.persistence.GebruikerRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Optional;

@Configuration

public class AppConfig {

    @Bean
    public static GebruikerRepository gebruikerRepository() {
        return new GebruikerRepository() {
            @Override
            public Gebruiker findByEmail(String email) {
                return null;
            }



            @Override
            public <S extends Gebruiker> S save(S s) {
                return null;
            }

            @Override
            public <S extends Gebruiker> Iterable<S> saveAll(Iterable<S> iterable) {
                return null;
            }

            @Override
            public Optional<Gebruiker> findById(Integer integer) {
                return Optional.empty();
            }

            @Override
            public boolean existsById(Integer integer) {
                return false;
            }

            @Override
            public Iterable<Gebruiker> findAll() {
                return null;
            }

            @Override
            public Iterable<Gebruiker> findAllById(Iterable<Integer> iterable) {
                return null;
            }

            @Override
            public long count() {
                return 0;
            }

            @Override
            public void deleteById(Integer integer) {

            }

            @Override
            public void delete(Gebruiker gebruiker) {

            }

            @Override
            public void deleteAll(Iterable<? extends Gebruiker> iterable) {

            }

            @Override
            public void deleteAll() {

            }
        };
    }

}
