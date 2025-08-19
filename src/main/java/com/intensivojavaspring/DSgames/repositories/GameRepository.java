package com.intensivojavaspring.DSgames.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intensivojavaspring.DSgames.entities.Game;

public interface GameRepository extends JpaRepository<Game, Long> {

}
