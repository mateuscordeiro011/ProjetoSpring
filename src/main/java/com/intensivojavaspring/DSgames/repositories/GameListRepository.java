package com.intensivojavaspring.DSgames.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.intensivojavaspring.DSgames.entities.GameList;

public interface GameListRepository extends JpaRepository<GameList, Long> {

}
