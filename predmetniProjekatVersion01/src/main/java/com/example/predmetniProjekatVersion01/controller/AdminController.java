package com.example.predmetniProjekatVersion01.controller;

import com.example.predmetniProjekatVersion01.entity.Admin;
import com.example.predmetniProjekatVersion01.entity.dto.AdminDTO;
import com.example.predmetniProjekatVersion01.entity.dto.IzmenaProfila;
import com.example.predmetniProjekatVersion01.service.AdminService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "admin")
public class AdminController {

    private final AdminService adminService;

    public AdminController(AdminService adminService){
        this.adminService = adminService;
    }

    @GetMapping(value = "/profil/{id}",
            produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AdminDTO> getAktivne(@PathVariable Long id) {


        Admin admin = this.adminService.findOne(id);
        AdminDTO adminDTO = new AdminDTO(
                admin.getId(),
                admin.getKorisnickoIme(),
                "***********************",
                admin.getIme(),
                admin.getPrezime(),
                admin.getEmail(),
                admin.getDatumRodjenja(),
                admin.getKontaktTelefon(),
                admin.getAktivan());

        return new ResponseEntity<>(adminDTO, HttpStatus.OK);

    }

    @PostMapping(value = "/azurirajProfil/{idFC}",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<IzmenaProfila> izmeniadmin(@PathVariable Long idFC, @RequestBody IzmenaProfila fitnessCentarDTO) throws Exception{

        if(fitnessCentarDTO.getRola() == 1){
            List<Admin> fitnessCentarList = adminService.findAll();
            for(Admin fitnessCentar: fitnessCentarList){
                if(fitnessCentar.getKorisnickoIme().equals(fitnessCentarDTO.getKorisnickoIme())){
                    IzmenaProfila retval = new IzmenaProfila(
                            Long.valueOf(0),
                            "bez promene",
                            "bez promene",
                            "bez promene",
                            "bez promene",
                            2);
                    return new ResponseEntity<>(retval, HttpStatus.OK);
                }
                if(fitnessCentar.getEmail().equals(fitnessCentarDTO.getEmail())){
                    IzmenaProfila retval = new IzmenaProfila(
                            Long.valueOf(0),
                            "bez promene",
                            "bez promene",
                            "bez promene",
                            "bez promene",
                            3);
                    return new ResponseEntity<>(retval, HttpStatus.OK);
                }
            }
            Admin izmenjen = this.adminService.izmeni(idFC, fitnessCentarDTO);
            IzmenaProfila povratni = new IzmenaProfila(
                    izmenjen.getId(),
                    izmenjen.getKorisnickoIme(),
                    izmenjen.getLozinka(),
                    izmenjen.getEmail(),
                    izmenjen.getKontaktTelefon(),
                    0);
            return new ResponseEntity<>(povratni, HttpStatus.OK);
        } else {
            IzmenaProfila fitnessCentarDTO1 = new IzmenaProfila(
                    Long.valueOf(0),
                    "bez promene",
                    "bez promene",
                    "bez promene",
                    "bez promene",
                    1);
            return new ResponseEntity<>(fitnessCentarDTO1, HttpStatus.OK);
        }
    }

}
