package com.intensivojavaspring.DSgames.repositories;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.intensivojavaspring.DSgames.entities.Game;
import com.intensivojavaspring.DSgames.projections.GameMinProjection;

public interface GameRepository extends JpaRepository<Game, Long> {
    

    //Para funcionar uma consulta SQL em vez da JPQL(Linguagem especifica do ORM do JPA) é necessario usar a anottation Query(@Query)
    //e permitir a native query (nativeQuery = true) - Condição para funcionar a consulta SQL
    @Query(nativeQuery = true, value = """
		SELECT tb_game.id, tb_game.title, tb_game.game_year AS `year`, tb_game.img_url AS imgUrl,
		tb_game.short_description AS shortDescription, tb_belonging.position
		FROM tb_game
		INNER JOIN tb_belonging ON tb_game.id = tb_belonging.game_id
		WHERE tb_belonging.list_id = :listId
		ORDER BY tb_belonging.position
			""")

    //Para devolver a consulta SQL, deve ser feito uma interface contendo o GET dos conteudos que você puxou no SQL
    //GameMinProjection é uma interface que PROJETA os dados puxado(get) da consulta SQL
    List<GameMinProjection> searchByList(Long listId);
}
