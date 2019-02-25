package com.stackroute.quizify.quizify.searchservice.exception;

public class TopicAlreadyExistsException extends Exception {
    private String message;

    public TopicAlreadyExistsException(){
        super();
    }

    public TopicAlreadyExistsException(String message){
        super(message);
        this.message=message;
    }
}
