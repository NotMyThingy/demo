package com.sumppi.demo.controllers;

import java.util.Map;

import com.sumppi.demo.repositories.KahviRepository;
import com.sumppi.demo.services.KahviService;
import com.sumppi.demo.entities.Kahvi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class KahviController {

    @Autowired
    private KahviRepository kahviRepository;

    @Autowired
    private KahviService kahviService;

    @GetMapping("/kofi")
    public String list(Model model) {
        model.addAttribute("kaffet", this.kahviRepository.findAll());
        return "index";
    }

    @PostMapping("/kofi")
    public String add(@RequestParam Map<String, String> kofi) {
        this.kahviService.saveKofi(new Kahvi(
                kofi.get("nimi").trim(),
                kofi.get("paino").trim(),
                kofi.get("hinta").trim().replace(",", "."),
                kofi.get("paahto").trim()));
        return "redirect:/kofi";
    }

    @GetMapping("/kofi/delete/{id}")
    public String delete(@PathVariable("id") Long id) {
        Kahvi kahvi = kahviRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Moista sumppia ei löydy!"));
        this.kahviService.deleteKofi(kahvi);
        return "redirect:/kofi";
    }

}
