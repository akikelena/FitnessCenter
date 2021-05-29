package com.example.predmetniProjekatVersion01.controller;

import com.example.predmetniProjekatVersion01.entity.FitnessCentar;
import com.example.predmetniProjekatVersion01.service.FitnessCentarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class FitnessCentarController {

    @Autowired
    private FitnessCentarService fitnessCentarService;

    @RequestMapping(value = "/add_fcentar.html", method = RequestMethod.GET)
    public String dodajFC(Model model){
        FitnessCentar fitnessCentar = new FitnessCentar();
        model.addAttribute("fitnessCentar", fitnessCentar);
        return "add_fcentar.html";
    }
}
