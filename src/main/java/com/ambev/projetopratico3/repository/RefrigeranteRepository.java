package com.ambev.projetopratico3.repository;

import com.ambev.projetopratico3.model.Refrigerante;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface RefrigeranteRepository extends MongoRepository<Refrigerante, String> {

}
