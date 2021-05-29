package com.example.predmetniProjekatVersion01.controller;

import com.example.predmetniProjekatVersion01.entity.Korisnik;
import com.example.predmetniProjekatVersion01.repository.KorisnikRepository;
import com.example.predmetniProjekatVersion01.service.KorisnikService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Collection;
import java.util.Map;

@Controller
public class KorisnikController {

    @Autowired
    private KorisnikService korisnikService;

    // HOME
    @RequestMapping(value = {"/", "index.html"}, method = RequestMethod.GET)
    public String home(){
        return "index.heml";
    }

    // LOGIN
    @RequestMapping(value =  "/login_page", method = RequestMethod.GET)
    public String login(Model model){
        Korisnik korisnik = new Korisnik();
        model.addAttribute("korisnik", korisnik);
        return "login_page.html";
    }

    // REGISTER
    @RequestMapping(value = "register_page.html", method = RequestMethod.GET)
    public String register(Model model){
        Korisnik korisnik = new Korisnik();
        model.addAttribute("korisnik", korisnik);
        return "register_page.html";
    }

}
