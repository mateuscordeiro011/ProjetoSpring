package com.intensivojavaspring.DSgames.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.intensivojavaspring.DSgames.dto.GameMinDTO;
import com.intensivojavaspring.DSgames.entities.Game;
import com.intensivojavaspring.DSgames.repositories.GameRepository;

@Service
public class GameService {

    @Autowired
    private GameRepository repository;

    public List<GameMinDTO> findAll(){
    List<Game> result = repository.findAll();
    List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
    return dto;
    }
}
