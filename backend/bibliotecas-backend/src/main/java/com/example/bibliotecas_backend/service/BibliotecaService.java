package com.example.bibliotecas_backend.service;

import com.example.bibliotecas_backend.dto.*;
import com.example.bibliotecas_backend.entity.Biblioteca;
import com.example.bibliotecas_backend.repository.BibliotecaRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class BibliotecaService {

    private final BibliotecaRepository repo;

    public BibliotecaService(BibliotecaRepository repo) {
        this.repo = repo;
    }

    public BibliotecaResponse registrar(BibliotecaRequest req) {
        Biblioteca b = new Biblioteca();
        b.setNombre(req.nombre());
        b.setDireccion(req.direccion());
        b.setCiudad(req.ciudad());
        return toResponse(repo.save(b));
    }

    @Transactional(readOnly = true)
    public List<BibliotecaResponse> listar() {
        return repo.findAll().stream().map(this::toResponse).toList();
    }

    private BibliotecaResponse toResponse(Biblioteca b) {
        List<LibroResponse> libros = b.getLibros().stream()
                .map(l -> new LibroResponse(l.getId(), l.getTitulo(), l.getAutor(), l.getAnioPublicacion()))
                .toList();
        return new BibliotecaResponse(b.getId(), b.getNombre(), b.getDireccion(), b.getCiudad(), libros);
    }
}