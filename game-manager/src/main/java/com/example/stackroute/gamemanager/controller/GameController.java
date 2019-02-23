package com.example.stackroute.gamemanager.controller;


import com.example.stackroute.gamemanager.domain.Game;
import com.example.stackroute.gamemanager.domain.Question;
import com.example.stackroute.gamemanager.exception.GameAlreadyExists;
import com.example.stackroute.gamemanager.exception.GameNotFound;
import com.example.stackroute.gamemanager.service.GameService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

import static org.springframework.boot.web.servlet.server.Session.SessionTrackingMode.URL;

@CrossOrigin
@RestController
@RequestMapping("api/v1")
@Api(description = "Game Manager Services")
public class GameController {

    private GameService gameService;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private GameController(GameService gameService)
    {
        this.gameService=gameService;
    }

    @ApiOperation(value = "Add Games")
    @PostMapping("/games/game")
    public ResponseEntity<?> saveGame(@RequestBody Game game) throws GameAlreadyExists {
        try {
            return new ResponseEntity<Game>(this.gameService.saveGame(game), HttpStatus.OK);
        } catch (GameAlreadyExists e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }
    @ApiOperation(value = "Delete Game")
    @DeleteMapping("/games/game")
    public ResponseEntity<?> deleteGame(@RequestBody Game game) throws GameNotFound
    {
        try {
            return new ResponseEntity<Game>(this.gameService.deleteGame(game), HttpStatus.OK);
        } catch (GameNotFound e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }
    @ApiOperation(value = "Updating Game")
    @PutMapping("/games/game")
    public ResponseEntity<?> updateGame(@RequestBody Game updatedGame) throws GameNotFound{

        try {
            return new ResponseEntity<Game>(this.gameService.updateGame(updatedGame), HttpStatus.OK);
        } catch (GameNotFound e) {
            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
        }

    }


    @ApiOperation(value = "Generate Live Game")
    @GetMapping(value = "/games/game")
    public ResponseEntity<?> generateLiveGameByTopic(@RequestBody Game liveGame)
    {
        String topicName = liveGame.getTopic().getName();
        String level = liveGame.getLevel();
        int numberOfQuestions = liveGame.getNumOfQuestion();

        final String url = "http://127.0.0.1:8001/api/v1/questions/topic/"+topicName+"/"+level+"/"+numberOfQuestions;
        List<Question> questionsList = new ArrayList<>();
        questionsList = restTemplate.getForObject(url, questionsList.getClass());
        liveGame.setQuestions(questionsList);
        return new ResponseEntity<Game>(liveGame, HttpStatus.OK);
    }

//    @ApiOperation(value = "Get All Questions")
//    @GetMapping("/games/{genre}/{topic}")
//    public ResponseEntity<?> getAllGames(@PathVariable String genre, @PathVariable String topic) throws GameNotFound {
//        try {
//            return new ResponseEntity<List<Game>>(this.gameService.getAllGames(genre, topic), HttpStatus.OK);
//        } catch (GameNotFound e) {
//            return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
//        }
//    }
}
