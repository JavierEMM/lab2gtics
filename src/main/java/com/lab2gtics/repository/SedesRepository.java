package com.lab2gtics.repository;

import com.lab2gtics.entity.Sede;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface SedesRepository extends JpaRepository<Sede,Integer> {
}
