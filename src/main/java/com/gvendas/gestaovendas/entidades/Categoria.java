package com.gvendas.gestaovendas.entidades;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "codigo")
    private long codigo;

    @Column(name = "nome")
    private String nome;

    public long getCodigo() {
        return codigo;
    }

    public void setCodigo(long codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categoria categoria = (Categoria) o;
        return getCodigo() == categoria.getCodigo() && Objects.equals(getNome(), categoria.getNome());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getCodigo(), getNome());
    }
}
