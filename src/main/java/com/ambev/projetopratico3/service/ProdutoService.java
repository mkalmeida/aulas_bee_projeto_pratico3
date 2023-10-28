package com.ambev.projetopratico3.service;

import com.ambev.projetopratico3.model.Agua;
import com.ambev.projetopratico3.model.Produto;
import com.ambev.projetopratico3.model.Refrigerante;
import com.ambev.projetopratico3.repository.AguaRepository;
import com.ambev.projetopratico3.repository.ProdutoRepository;
import com.ambev.projetopratico3.repository.RefrigeranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
public class ProdutoService {
    private final AguaRepository aguaRepository;
    private final RefrigeranteRepository refrigeranteRepository;

    @Autowired
    public ProdutoService(AguaRepository aguaRepository, RefrigeranteRepository refrigeranteRepository) {
        this.aguaRepository = aguaRepository;
        this.refrigeranteRepository = refrigeranteRepository;
    }

    public void salvarProduto(Produto produto) {
        if (produto instanceof Agua) {
            aguaRepository.save((Agua) produto);
        } else if (produto instanceof Refrigerante) {
            refrigeranteRepository.save((Refrigerante) produto);
        }
    }

    public Produto criarProduto(Map<String, Object> dados) {
        String tipo = (String) dados.get("tipo");
        String id = (String) dados.get("id");
        String descricao = (String) dados.get("descricao");
        double preco = (double) dados.get("preco");

        if ("Agua".equalsIgnoreCase(tipo)) {
            boolean comGas = (boolean) dados.get("comGas");
            return new Agua(id, descricao, preco, comGas);
        } else if ("Refrigerante".equalsIgnoreCase(tipo)) {
            boolean comAcucar = (boolean) dados.get("comAcucar");
            return new Refrigerante(id, descricao, preco, comAcucar);
        } else {
            System.out.println("Esse produto não pode ser criado");
        }
        return new Produto("N/A", "Produto Desconhecido", 0.0);
    }

}
