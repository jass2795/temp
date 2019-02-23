package com.example.stackroute.gamemanager.service;

import com.example.stackroute.gamemanager.domain.Game;
import com.example.stackroute.gamemanager.domain.Topic;
import com.example.stackroute.gamemanager.exception.GameAlreadyExists;
import com.example.stackroute.gamemanager.exception.GameNotFound;
import com.example.stackroute.gamemanager.repository.GameRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;


@Service
public class GameServiceimpl implements GameService {

    private static Logger log = LoggerFactory.getLogger(GameServiceimpl.class);

    private GameRepository gameRepository;


    @Autowired
    public GameServiceimpl(GameRepository gameRepository){

    this.gameRepository=gameRepository;
     }

     @Override
     public Game saveGame(Game game) throws GameAlreadyExists{
         if(this.gameRepository.existsById(game.getId()))
             throw new GameAlreadyExists("Event already exists");
         else
             return this.gameRepository.save(game);

     }

    @Override
    public Game deleteGame(Game game) throws GameNotFound {
        if(this.gameRepository.existsById(game.getId())) {
             this.gameRepository.delete(game);
             return game;
        }
        else
            throw  new GameNotFound("Game Not exist");
    }



    @Override
    public Game updateGame(Game updatedGame) throws GameNotFound{

    if(this.gameRepository.existsById(updatedGame.getId()))
        return this.gameRepository.save(updatedGame);
    else
        throw new GameNotFound("Game not found");

    }

//    @Override
//    public List<Game> getAllGames(String genre, String topicName) throws GameNotFound{
//
//        List<Game> gameList = this.gameRepository.getAllGames(genre, topicName);
//        if(gameList.isEmpty())
//            throw  new GameNotFound("no game found");
//        else {
//             return gameList;
//        }
//
//    }



}
