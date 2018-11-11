package com.allInOne.allInOneV1.repository;

import com.allInOne.allInOneV1.model.Actor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ActorRespository extends JpaRepository<Actor, Integer>, ActorRepositoryCustom{

}
