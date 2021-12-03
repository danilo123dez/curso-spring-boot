package com.gvendas.gestaovendas.service;

import com.gvendas.gestaovendas.entidades.Categoria;
import com.gvendas.gestaovendas.repository.CategoriaRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> listarTodas(){
        return categoriaRepository.findAll();
    }

    public Optional<Categoria> buscarPorId(Long id){
        return categoriaRepository.findById(id);
    }

    public Categoria salvar(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public Categoria atualizar(Long codigo, Categoria categoria){
        Categoria categoriaSalvar = validarCategoriaExiste(codigo);
        BeanUtils.copyProperties(categoria, categoriaSalvar, "codigo");
        return categoriaRepository.save(categoriaSalvar);
    }

    private Categoria validarCategoriaExiste(Long codigo){
        Optional<Categoria> categoriaExiste = buscarPorId(codigo);
        if(categoriaExiste.isEmpty()){
            throw new EmptyResultDataAccessException(1);
        }

        return categoriaExiste.get();
    }
}
