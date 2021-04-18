package com.opc.aleksa.repository;

import com.opc.aleksa.model.Kupac;
import org.springframework.data.jpa.repository.JpaRepository;

public interface KupacRepository extends JpaRepository<Kupac,Integer> {
}
