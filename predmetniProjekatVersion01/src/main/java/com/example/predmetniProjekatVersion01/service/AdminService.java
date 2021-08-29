package com.example.predmetniProjekatVersion01.service;

import com.example.predmetniProjekatVersion01.entity.Admin;
import com.example.predmetniProjekatVersion01.entity.dto.IzmenaProfila;

import java.util.List;

public interface AdminService {
    Admin findOne(Long id);
    List<Admin> findAll();
    Admin kreiraj(Admin admin) throws Exception;
    void delete(Long id);
    Admin izmeni(Long idFC, IzmenaProfila izmenaProfila) throws Exception;
}
