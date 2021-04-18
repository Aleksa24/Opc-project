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
}
