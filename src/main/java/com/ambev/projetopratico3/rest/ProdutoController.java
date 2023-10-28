package com.ambev.projetopratico3.rest;

import com.ambev.projetopratico3.message.MessageProducer;
import com.ambev.projetopratico3.model.Agua;
import com.ambev.projetopratico3.model.Produto;
import com.ambev.projetopratico3.model.Refrigerante;
import com.ambev.projetopratico3.repository.ProdutoRepository;
import com.ambev.projetopratico3.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/produtos")
public class ProdutoController {

    private final ProdutoRepository produtoRepository;

    private final MessageProducer messageProducer;
    private final ProdutoService produtoService;


    /*curl -X POST -H "Content-Type: application/json" -d '{
        "tipo": "Agua",
        "id": "45",
        "descricao": "Água sem Gás",
        "preco": 1.99,
        "comGas": true
        }' http://localhost:8080/api/produtos*/

    /*curl -X POST -H "Content-Type: application/json" -d '{
        "tipo": "Refrigerante",
        "id": "234",
        "descricao": "Refrigerante com Açúcar",
        "preco": 2.49,
        "comAcucar": false
        }' http://localhost:8080/api/produtos*/

    @Autowired
    public ProdutoController(ProdutoRepository produtoRepository, MessageProducer messageProducer, ProdutoService produtoService) {
        this.produtoRepository = produtoRepository;
        this.messageProducer = messageProducer;
        this.produtoService = produtoService;
    }

    @PostMapping
    public ResponseEntity<String> salvarProduto(@RequestBody Map<String, Object> dados) {
        Produto produto = produtoService.criarProduto(dados);
        produtoService.salvarProduto(produto);
        messageProducer.sendMessage(String.format("Produto %s cadastrado !", produto.toString()));
        return ResponseEntity.ok("Produto salvo com sucesso");
    }

    @GetMapping("/error")
    public ResponseEntity errorProduct() {
        return new ResponseEntity<>( HttpStatus.NOT_FOUND);
    }
}