package com.fila.banco.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fila.banco.model.Clientes;

@Repository
public interface ClientesRepository extends JpaRepository<Clientes, Long>{

}