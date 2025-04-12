package com.example.PapeleriaQuizzArqui.Repository;

import com.example.PapeleriaQuizzArqui.Model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository<Cliente, Integer> {
}