package com.ambev.projetopratico3.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "Agua")
public class Agua extends Produto{

    private boolean comGas;

    public Agua(String id, String descricao, double preco, boolean comGas) {
        super(id, descricao, preco);
        this.comGas = comGas;
    }

    public boolean isComGas() {
        return comGas;
    }

    public void setComGas(boolean comGas) {
        this.comGas = comGas;
    }

    @Override
    public String toString() {
        return "{" +
                "id='" + getId() + '\'' +
                ", descricao='" + getDescricao() + '\'' +
                ", preco=" + getPreco() +
                ", comGas=" + comGas +
                '}';
    }

}
