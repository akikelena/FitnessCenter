package com.example.predmetniProjekatVersion01.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class IndexController {

    @GetMapping
    public String index(){
        return "index.html";
    }

    @GetMapping(value = "/login_page")
    public String log_page(){
        return "login_page.html";
    }

    @GetMapping(value = "register_page")
    public String reg_page(){
        return "register_page.html";
    }

    @GetMapping(value = "/addfitcentar")
    public String add_fc(){
        return "add_fitcentar.html";
    }

    @GetMapping(value = "/approve_request")
    public String approve_req(){
        return "approve_request.html";
    }

    @GetMapping(value = "/error_page")
    public String error_pg(){
        return "error_page.html";
    }

    @GetMapping(value = "/FCList")
    public String fcsList(){
        return "FCList.html";
    }

    @GetMapping(value = "/forb403")
    public String forb403(){
        return "forb403.html";
    }

    @GetMapping(value = "/TerminList")
    public String terminList(){
        return "TerminList.html";
    }

    @GetMapping(value = "/TreningList")
    public String treningList(){
        return "TreningList.html";
    }

    @GetMapping(value = "/user_page")
    public String user_page(){
        return "user_page.html";
    }
}
