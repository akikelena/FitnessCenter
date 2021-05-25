package main.java.com.example.predmetniProjekatVersion01.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.predmetniProjekatVersion01.entity.Administrator;

public interface AdministratorRepository extends JpaRepository<Administrator, Long>{
}
