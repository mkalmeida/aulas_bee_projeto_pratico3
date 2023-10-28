package com.ambev.projetopratico3.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Refrigerante")
public class Refrigerante extends Produto {
    private boolean temAcucar;

    public Refrigerante(String id, String descricao, double preco, boolean temAcucar) {
        super(id, descricao, preco);
        this.temAcucar = temAcucar;
    }

    public boolean isTemAcucar() {
        return temAcucar;
    }

    public void setTemAcucar(boolean temAcucar) {
        this.temAcucar = temAcucar;
    }


    @Override
    public String toString() {
        return "{" +
                "id='" + getId() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", preco=" + getPreco() +
                ", temAcucar=" + temAcucar +
                '}';
    }
}
