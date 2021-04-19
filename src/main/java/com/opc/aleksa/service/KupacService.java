package com.opc.aleksa.service;

import com.opc.aleksa.dto.KupacDto;
import com.opc.aleksa.model.Kupac;

import java.util.List;

public interface KupacService {
    List<KupacDto> getKupci();

    List<KupacDto> getUpdatedKupci();
}
