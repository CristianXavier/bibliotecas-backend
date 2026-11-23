package com.example.bibliotecas_backend.config;

import com.example.bibliotecas_backend.entity.Biblioteca;
import com.example.bibliotecas_backend.entity.Libro;
import com.example.bibliotecas_backend.repository.BibliotecaRepository;
import com.example.bibliotecas_backend.repository.LibroRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer implements CommandLineRunner {

    private final BibliotecaRepository bibliotecas;
    private final LibroRepository libros;

    public DataInitializer(BibliotecaRepository bibliotecas, LibroRepository libros) {
        this.bibliotecas = bibliotecas;
        this.libros = libros;
    }

    @Override
    public void run(String... args) {
        Biblioteca central = bibliotecas.save(nuevaBiblioteca("Biblioteca Central", "Calle 10 #5-20", "Bogotá"));
        Biblioteca norte = bibliotecas.save(nuevaBiblioteca("Biblioteca Norte", "Carrera 15 #120-8", "Bogotá"));

        libros.save(nuevoLibro("Cien años de soledad", "Gabriel García Márquez", 1967, central));
        libros.save(nuevoLibro("El coronel no tiene quien le escriba", "Gabriel García Márquez", 1961, norte));
    }

    private Biblioteca nuevaBiblioteca(String nombre, String direccion, String ciudad) {
        Biblioteca b = new Biblioteca();
        b.setNombre(nombre);
        b.setDireccion(direccion);
        b.setCiudad(ciudad);
        return b;
    }

    private Libro nuevoLibro(String titulo, String autor, Integer anio, Biblioteca biblioteca) {
        Libro l = new Libro();
        l.setTitulo(titulo);
        l.setAutor(autor);
        l.setAnioPublicacion(anio);
        l.setBiblioteca(biblioteca);
        return l;
    }
}