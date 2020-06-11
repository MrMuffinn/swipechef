package com.itann.swipechef.services;


import com.itann.swipechef.domain.Voorkeursgerecht;
import com.itann.swipechef.persistence.VoorkeursgerechtRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VoorkeursgerechtService {

    @Autowired
    VoorkeursgerechtRepository voorkeursgerechtRepository;

    public Voorkeursgerecht postNieuwVoorkeursgereceht(int gerecht) {
        Voorkeursgerecht voorkeursgerecht = new Voorkeursgerecht();
        voorkeursgerecht.setGebruiker(1);
        voorkeursgerecht.setGerecht(gerecht);
        return voorkeursgerechtRepository.save(voorkeursgerecht);
    }

    public Iterable<Voorkeursgerecht> findAll(){
        return voorkeursgerechtRepository.findAll();
    }

//    public Iterable<Voorkeursgerecht> findAllGerechten(){
//        return voorkeursgerechtRepository.findAllVoorkeurgerechten();
//    }

}
