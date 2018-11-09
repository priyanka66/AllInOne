package com.allInOne.allInOneV1.repository;

import com.allInOne.allInOneV1.model.Actor;
import org.springframework.data.repository.CrudRepository;

public interface ActorRespository extends CrudRepository<Actor, Integer> {
    @Override
    Iterable<Actor> findAll();
}
