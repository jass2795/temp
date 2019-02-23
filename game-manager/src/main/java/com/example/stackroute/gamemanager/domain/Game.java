package com.example.stackroute.gamemanager.domain;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;


@Data
@Document(collection="games")
public class Game {

    @Id
    private long id;
    private String name;
    private Category category;
    private String tag;
    private Topic topic;
    private String genre;
    private String level;
    private int numOfQuestion;
    private List<Question> questions;
    private int liked;
    private int playCount;
    private String rules;
    private String timestamp;
    private Admin admin;

}
