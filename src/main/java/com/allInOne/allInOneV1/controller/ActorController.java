package com.allInOne.allInOneV1.controller;

import com.allInOne.allInOneV1.model.Actor;
import com.allInOne.allInOneV1.repository.ActorRespository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collection;

@Controller
@RequestMapping(path="/actor")
public class ActorController {
    @Autowired
    private ActorRespository actorRespository;

    @RequestMapping(path="/add", method = RequestMethod.POST, produces = "application/json")
    ResponseEntity createActor(@RequestBody Actor newActor) {

        HttpHeaders headers = new HttpHeaders();
        headers.add(HttpHeaders.CONTENT_TYPE, "application/json");
        actorRespository.save(newActor);

        return ResponseEntity.status(HttpStatus.CREATED)
                .headers(headers)
                .body(newActor);
    }

    @RequestMapping(path="/all", method = RequestMethod.GET)
    public ResponseEntity <Iterable<Actor>> getAllUsers() {
        return new ResponseEntity<>(actorRespository.findAll(), HttpStatus.OK);
    }
}
