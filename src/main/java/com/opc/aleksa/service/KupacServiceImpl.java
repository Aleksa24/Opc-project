package com.opc.aleksa.service;

import com.opc.aleksa.model.Kupac;
import com.opc.aleksa.repository.KupacRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KupacServiceImpl implements KupacService {

    private KupacRepository kupacRepository;

    public KupacServiceImpl(KupacRepository kupacRepository) {
        this.kupacRepository = kupacRepository;
    }

    @Override
    public List<Kupac> getKupci() {
        return kupacRepository.findAll();
    }

    @Override
    public List<Kupac> getUpdatedKupci() {
        List<Kupac> kupci = kupacRepository.findAll();
        kupci.forEach(kupac -> kupac.getKartice()
                .forEach(kartica -> {
                    if (!kartica.getDozvoljeniGradovi().contains(kupac.getGrad()))
                        kartica.getDozvoljeniGradovi().add(kupac.getGrad());
        }));
        return kupacRepository.saveAll(kupci);
    }
}
