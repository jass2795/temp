package com.example.stackroute.gamemanager.repository;

import com.example.stackroute.gamemanager.domain.Game;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GameRepository extends MongoRepository<Game,String > {

//    @Query("{ 'genre': '?0' , 'topic.name': '?1'}")
//    List<Game> getAllGames(String genre, String topicName);

    Optional<Game> findTopByOrderByIdDesc();

    Optional<Game> findById(long id);

    boolean existsById(long id);
}
