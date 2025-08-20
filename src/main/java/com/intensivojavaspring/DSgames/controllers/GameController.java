package com.intensivojavaspring.DSgames.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.intensivojavaspring.DSgames.dto.GameDTO;
import com.intensivojavaspring.DSgames.dto.GameMinDTO;
import com.intensivojavaspring.DSgames.services.GameService;

@RestController
@RequestMapping("/games")
public class GameController {

    @Autowired
    private GameService service;

    @GetMapping
    public List<GameMinDTO> findAll(){
        List<GameMinDTO> result = service.findAll();
        return result;
    }

    @GetMapping("/{id}")
    public GameDTO findById(@PathVariable Long id){
        GameDTO result = service.findById(id);
        return result;
    } 
}
