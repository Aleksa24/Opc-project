package com.opc.aleksa.service;

import com.opc.aleksa.model.Kupac;

import java.util.List;

public interface KupacService {
    List<Kupac> getKupci();

    List<Kupac> getUpdatedKupci();
}
