package com.lab2gtics.repository;

import com.lab2gtics.entity.Trabajadores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrabajadoresRepository extends JpaRepository<Trabajadores,String>{
}
