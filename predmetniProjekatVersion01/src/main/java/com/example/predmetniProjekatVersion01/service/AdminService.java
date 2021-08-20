package com.example.predmetniProjekatVersion01.service;

import com.example.predmetniProjekatVersion01.entity.Admin;

import java.util.List;

public interface AdminService {
    Admin findOne(Long id);
    List<Admin> findAll();
    Admin kreiraj(Admin admin) throws Exception;
    void delete(Long id);
}
