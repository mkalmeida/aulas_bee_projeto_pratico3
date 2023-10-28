package com.ambev.projetopratico3.repository;


import com.ambev.projetopratico3.model.Produto;
import jakarta.persistence.MappedSuperclass;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface ProdutoRepository extends MongoRepository<Produto, String> {
}
