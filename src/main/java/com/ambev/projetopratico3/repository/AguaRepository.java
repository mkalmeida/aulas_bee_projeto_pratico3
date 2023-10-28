package com.ambev.projetopratico3.repository;

import com.ambev.projetopratico3.model.Agua;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface AguaRepository extends MongoRepository<Agua, String> {

}
