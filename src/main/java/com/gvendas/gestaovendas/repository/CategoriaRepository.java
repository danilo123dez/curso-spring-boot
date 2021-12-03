package com.gvendas.gestaovendas.repository;

import com.gvendas.gestaovendas.entidades.Categoria;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategoriaRepository extends JpaRepository<Categoria, Long> {
}
