package com.example.bibliotecas_backend.dto;

import java.util.List;

public record BibliotecaResponse(Long id, String nombre, String direccion,
                                 String ciudad, List<LibroResponse> libros) {}