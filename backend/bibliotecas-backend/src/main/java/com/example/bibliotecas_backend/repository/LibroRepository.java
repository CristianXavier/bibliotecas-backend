package com.example.bibliotecas_backend.repository;

import com.example.bibliotecas_backend.entity.Libro;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LibroRepository extends JpaRepository<Libro, Long> {}