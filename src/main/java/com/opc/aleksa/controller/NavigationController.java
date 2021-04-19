package com.opc.aleksa.controller;

import com.opc.aleksa.dto.KupacDto;
import com.opc.aleksa.model.Kupac;
import com.opc.aleksa.service.KupacService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;

@Controller
public class NavigationController {

    private KupacService kupacService;

    public NavigationController(KupacService kupacService) {
        this.kupacService = kupacService;
    }

    @GetMapping("/home")
    public String home(Model model){

//        model.addAttribute("kupci",new ArrayList<KupacDto>());
        model.addAttribute("kupci",kupacService.getKupci());

        return "home";
    }

}
