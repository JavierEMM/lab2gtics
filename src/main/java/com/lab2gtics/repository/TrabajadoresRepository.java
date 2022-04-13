package com.lab2gtics.repository;

import com.lab2gtics.entity.Trabajadores;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TrabajadoresRepository extends JpaRepository<Trabajadores,String>{
    @Query(nativeQuery = true, value = "SELECT * FROM trabajadores WHERE idsede = ?1")
    List<Trabajadores> getTrabajadoresBySede(Integer idsede);
}
