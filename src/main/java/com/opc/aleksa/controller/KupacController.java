package com.opc.aleksa.controller;

import com.opc.aleksa.dto.KupacDto;
import com.opc.aleksa.service.KupacService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("kupac")
public class KupacController {

    private final KupacService kupacService;

    public KupacController(KupacService kupacService) {
        this.kupacService = kupacService;
    }

    @GetMapping("all")
    public List<KupacDto> getAll(){
        return this.kupacService.getKupci();
    }

    @GetMapping("updateKartice")
    public List<KupacDto> getUpdatedKupci(){
        return kupacService.getUpdatedKupci();
    }
}
