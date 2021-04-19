package com.opc.aleksa.service;

import com.opc.aleksa.dto.KupacDto;
import com.opc.aleksa.mapper.KupacMapper;
import com.opc.aleksa.model.Kupac;
import com.opc.aleksa.repository.KupacRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class KupacServiceImpl implements KupacService {

    private final KupacRepository kupacRepository;
    private final KupacMapper kupacMapper;

    public KupacServiceImpl(KupacRepository kupacRepository,
                            KupacMapper kupacMapper) {
        this.kupacRepository = kupacRepository;
        this.kupacMapper = kupacMapper;
    }

    @Override
    public List<KupacDto> getKupci() {
        return kupacMapper.toDtoList(kupacRepository.findAll());
    }

    @Override
    public List<KupacDto> getUpdatedKupci() {
        List<Kupac> kupci = kupacRepository.findAll();
        kupci.forEach(kupac -> kupac.getKartice()
                .forEach(kartica -> {
                    if (!kartica.getDozvoljeniGradovi().contains(kupac.getGrad()))
                        kartica.getDozvoljeniGradovi().add(kupac.getGrad());
        }));
        return kupacMapper.toDtoList(kupacRepository.saveAll(kupci));
    }
}
