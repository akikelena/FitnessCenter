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
    public ResponseEntity<IzmenaProfila> izmeniadmin(@PathVariable Long idFC, @RequestBody IzmenaProfila izmenaProfila) throws Exception{

        if(izmenaProfila.getRola() == 1){
            List<Admin> adminList = adminService.findAll();
            for(Admin admin: adminList){
                if(admin.getKorisnickoIme().equals(izmenaProfila.getKorisnickoIme())){
                    IzmenaProfila retval = new IzmenaProfila(
                            Long.valueOf(0),
                            "bez promene",
                            "bez promene",
                            "bez promene",
                            "bez promene",
                            "bez promene",
                            "bez promene",
                            false,
                            2);
                    return new ResponseEntity<>(retval, HttpStatus.OK);
                }
                if(admin.getEmail().equals(izmenaProfila.getEmail())){
                    IzmenaProfila retval = new IzmenaProfila(
                            Long.valueOf(0),
                            "bez promene",
                            "bez promene",
                            "bez promene",
                            "bez promene",
                            "bez promene",
                            "bez promene",
                            false,
                            3);
                    return new ResponseEntity<>(retval, HttpStatus.OK);
                }
            }
            Admin izmenjen = this.adminService.izmeni(idFC, izmenaProfila);
            IzmenaProfila povratni = new IzmenaProfila(
                    izmenjen.getId(),
                    izmenjen.getKorisnickoIme(),
                    "********",
                    izmenjen.getIme(),
                    izmenjen.getPrezime(),
                    izmenjen.getEmail(),
                    izmenjen.getKontaktTelefon(),
                    izmenjen.getAktivan(),
                    0);
            return new ResponseEntity<>(povratni, HttpStatus.OK);
        } else {
             IzmenaProfila adminDTO1 = new IzmenaProfila(
                    Long.valueOf(0),
                    "bez promene",
                    "bez promene",
                    "bez promene",
                    "bez promene",
                     "bez promene",
                     "bez promene",
                    false,
                    1);
            return new ResponseEntity<>(adminDTO1, HttpStatus.OK);
        }
    }

}
