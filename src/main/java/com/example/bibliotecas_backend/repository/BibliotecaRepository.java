package com.example.bibliotecas_backend.repository;

import com.example.bibliotecas_backend.entity.Biblioteca;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BibliotecaRepository extends JpaRepository<Biblioteca, Long> {}