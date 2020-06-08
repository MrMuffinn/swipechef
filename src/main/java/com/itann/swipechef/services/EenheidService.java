package com.itann.swipechef.services;

import com.itann.swipechef.domain.Eenheid;
import com.itann.swipechef.persistence.EenheidRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EenheidService {

    @Autowired
    private EenheidRepository eenheidsRepository;

    public Eenheid getEenheidOpNaam(String naam) {
        return eenheidsRepository.findByNaam(naam);
    }

       public Eenheid postNieuweEenheid(String naam) {
        Eenheid eenheid = new Eenheid();
        eenheid.setNaam(naam);

        return eenheidsRepository.save(eenheid);
    }

}
