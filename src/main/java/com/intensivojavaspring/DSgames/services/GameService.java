package com.intensivojavaspring.DSgames.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.intensivojavaspring.DSgames.dto.GameDTO;
import com.intensivojavaspring.DSgames.dto.GameMinDTO;
import com.intensivojavaspring.DSgames.entities.Game;
import com.intensivojavaspring.DSgames.projections.GameMinProjection;
import com.intensivojavaspring.DSgames.repositories.GameRepository;


@Service
public class GameService {

    @Autowired
    private GameRepository repository;


    //Transactional - Garante que a operação com o banco de dados aconteça obedecendo aos principios das transações 
    //(importante que o import seja do springframework e não jakarta)
    @Transactional(readOnly = true)
    public GameDTO findById(Long id){
        Game result = repository.findById(id).get();
        GameDTO dto = new GameDTO(result);
        return dto;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findAll(){
    List<Game> result = repository.findAll();
    List<GameMinDTO> dto = result.stream().map(x -> new GameMinDTO(x)).toList();
    return dto;
    }

    @Transactional(readOnly = true)
    public List<GameMinDTO> findByList(long listId){
        List<GameMinProjection> result = repository.searchByList(listId);
        return result.stream().map(x -> new GameMinDTO(x)).toList();
    }
}
