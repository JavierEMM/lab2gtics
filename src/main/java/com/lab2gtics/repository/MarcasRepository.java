package com.lab2gtics.repository;

import com.lab2gtics.entity.Marca;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository

public interface MarcasRepository extends JpaRepository<Marca, Integer> {

}
