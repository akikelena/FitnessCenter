package com.example.predmetniProjekatVersion01.service.impl;

import com.example.predmetniProjekatVersion01.entity.Admin;
import com.example.predmetniProjekatVersion01.repository.AdminRepository;
import com.example.predmetniProjekatVersion01.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdminServiceImpl implements AdminService {
    private final AdminRepository adminRepository;

    @Autowired
    public AdminServiceImpl(AdminRepository adminRepository){
        this.adminRepository = adminRepository;
    }

    @Override
    public Admin findOne(Long id){
        Admin admin = this.adminRepository.getOne(id);
        return  admin;
    }

    @Override
    public List<Admin> findAll(){
        List<Admin> adminList = this.adminRepository.findAll();
        return adminList;
    }

    @Override
    public Admin kreiraj(Admin admin) throws Exception{
        if(admin.getId() != null){
            throw  new Exception("Id mora biti null!");
        }
        Admin noviAdmin = this.adminRepository.save(admin);
        return noviAdmin;
    }

    @Override
    public void delete(Long id){
        this.adminRepository.deleteById(id);
    }
}
