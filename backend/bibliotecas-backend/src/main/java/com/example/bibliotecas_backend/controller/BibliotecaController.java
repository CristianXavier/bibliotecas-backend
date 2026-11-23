package com.example.bibliotecas_backend.controller;

import com.example.bibliotecas_backend.dto.*;
import com.example.bibliotecas_backend.service.BibliotecaService;
import jakarta.validation.Valid;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/bibliotecas")
public class BibliotecaController {

    private final BibliotecaService service;

    public BibliotecaController(BibliotecaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<BibliotecaResponse> registrar(@Valid @RequestBody BibliotecaRequest req) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.registrar(req));
    }

    @GetMapping
    public List<BibliotecaResponse> listar() {
        return service.listar();
    }
}