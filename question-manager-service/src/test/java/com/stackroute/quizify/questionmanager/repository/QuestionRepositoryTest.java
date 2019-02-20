//package com.stackroute.quizify.questionmanager.repository;
//
//import com.stackroute.quizify.questionmanager.domain.Admin;
//import com.stackroute.quizify.questionmanager.domain.Category;
//import com.stackroute.quizify.questionmanager.domain.Question;
//import com.stackroute.quizify.questionmanager.domain.Topic;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.junit.runner.RunWith;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
//import org.springframework.test.context.junit4.SpringRunner;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.*;
//
///*
//*This Test Class is used to test the Question Repository CRUD Operations and also Custom Queries.
//*
//*/
//
//@RunWith(SpringRunner.class)
//@DataMongoTest
//public class QuestionRepositoryTest {
//
//    @Autowired
//    private QuestionRepository questionRepository;
//
//    private Admin admin;
//    private Category category;
////    private Topic topic;
//    private Topic topicMovies;
//    private Topic topicTvShows;
//    private Question question;
//    private List<Question> questions;
//
//    /*
//    * Setting Up Values for all required objects and lists
//    * Objects will be Initialized before each Test
//    */
//    @Before
//    public void setUp() throws Exception {
//        /**
//         * Dummy Data For Admin Class
//         */
//        this.admin = new Admin();
//        this.admin.setId("101");
//        this.admin.setName("Kaustav");
//
//        /**
//         * Dummy Data For Category Class
//         */
//        this.category = new Category();
//        this.category.setName("Entertainment");
//        this.category.setImageUrl("https://www.gudstory.com/wp-content/uploads/2018/10/Entertainment-1.jpg");
//        this.category.setTimeStamp(System.currentTimeMillis());
//        this.category.setAdmin(this.admin);
//        /**
//         * Dummy Data For Topic Class
//         */
//        this.topicMovies = new Topic();
//        this.topicMovies.setName("Movies");
//        this.topicMovies.setImageUrl("https://boygeniusreport.files.wordpress.com/2016/03/movies-tiles.jpg?quality=98&strip=all");
//        this.topicMovies.setTimeStamp(System.currentTimeMillis());
//        this.topicMovies.setAdmin(this.admin);
//        /**
//         * Dummy Data For Topic Class
//         */
//        this.topicTvShows = new Topic();
//        this.topicTvShows.setName("TV-Shows");
//        this.topicTvShows.setImageUrl("http://i-vrox.com/wp-content/uploads/2018/06/series-2.jpg");
//        this.topicTvShows.setTimeStamp(System.currentTimeMillis());
//        this.topicTvShows.setAdmin(this.admin);
//        /**
//         * Dummy Data For Question Class
//         */
//        this.question = new Question();
//        this.question.setId("1234567890");
//        this.question.setCategory(this.category);
//        this.question.setTopic(this.topicMovies);
//        this.question.setLevel("easy");
//        this.question.setType("mcq");
//        this.question.setStatement("How many oscars did the Titanic movie got?");
//        List<String> options = new ArrayList<>();
//        options.add("10");
//        options.add("11");
//        options.add("9");
//        options.add("8");
//        this.question.setOptions(options);
//        this.question.setAnswer("11");
//        this.question.setTimeStamp(System.currentTimeMillis());
//        this.question.setAdmin(this.admin);
//        /**
//         * Empty List of Question
//         */
//        this.questions = new ArrayList<>();
//    }
//
//    /*
//     * Removing Values from all used objects and lists
//     * Objects will be nullified after each Test
//     */
//    @After
//    public void tearDown() throws Exception {
//        this.questions = null;
//        this.question = null;
//        this.topicTvShows = null;
//        this.topicMovies = null;
//        this.category = null;
//        this.admin = null;
//
//        this.questionRepository.deleteAll();
//    }
//
//    /*
//     * This Test is to test if A Question is successfully Saved or Not
//     */
//    @Test
//    public void saveQuestionTest() {
//        Question savedQuestion = this.questionRepository.save(this.question);
//        assertEquals(this.question, savedQuestion);
//    }
//
//    /*
//     * This Test is to test if a previously saved question is successfully Updated or Not
//     */
//    @Test
//    public void updateQuestionTest() {
//        Question savedQuestion = this.questionRepository.save(this.question);
//
//        Question updatedQuestion = new Question();
//        updatedQuestion.setId(this.question.getId());
//        updatedQuestion.setCategory(this.question.getCategory());
//        updatedQuestion.setTopic(this.topicTvShows);
//        updatedQuestion.setLevel("hard");
//        updatedQuestion.setLevel("t/f");
//        updatedQuestion.setStatement("Joey proposed to Rachel and Phoebe?");
//        List<String> options = new ArrayList<>();
//        options.add("True");
//        options.add("False");
//        updatedQuestion.setOptions(options);
//        updatedQuestion.setAnswer("True");
//        updatedQuestion.setTimeStamp(System.currentTimeMillis());
//        updatedQuestion.setAdmin(this.admin);
//
//        Question savedUpdatedQuestion = this.questionRepository.save(updatedQuestion);
//
//        assertNotEquals(savedQuestion, savedUpdatedQuestion);
//    }
//
//    /*
//     * This Test is to test if A Question is successfully Deleted or Not
//     */
//    @Test
//    public void deleteQuestionTest() {
//        Question savedQuestion = this.questionRepository.save(this.question);
//
//        this.questionRepository.delete(savedQuestion);
//        assertTrue(this.questionRepository.findById(savedQuestion.getId()).isEmpty());
//    }
//
//    /*
//     * This Test is to test if All Questions of given Category and Topic are successfully Fetched or Not
//     */
//    @Test
//    public void getAllQuestionsTest() {
//        Question savedQuestion1 = this.questionRepository.save(this.question);
//
//        this.question = new Question();
//        this.question.setId("1234567891");
//        this.question.setCategory(this.category);
//        this.question.setTopic(this.topicMovies);
//        this.question.setLevel("medium");
//        this.question.setType("mcq");
//        this.question.setStatement("Who is the director of the X-files?");
//        List<String> options = new ArrayList<>();
//        options.add("Rob Bowman");
//        options.add("Robert Redford");
//        options.add("Robin Williams");
//        options.add("Sergio Leone");
//        this.question.setOptions(options);
//        this.question.setAnswer("Rob Bowman");
//        this.question.setTimeStamp(System.currentTimeMillis());
//        this.question.setAdmin(this.admin);
//        Question savedQuestion2 = this.questionRepository.save(this.question);
//
//        this.question = new Question();
//        this.question.setId("1234567892");
//        this.question.setCategory(this.category);
//        this.question.setTopic(this.topicMovies);
//        this.question.setLevel("hard");
//        this.question.setType("mcq");
//        this.question.setStatement("What is the house number of the Simpsons?");
//        options = new ArrayList<>();
//        options.add("Number 742");
//        options.add("Number 212");
//        options.add("Number 212/1");
//        options.add("Number 21321");
//        this.question.setOptions(options);
//        this.question.setAnswer("Number 742");
//        this.question.setTimeStamp(System.currentTimeMillis());
//        this.question.setAdmin(this.admin);
//        Question savedQuestion3 = this.questionRepository.save(this.question);
//
//        this.questions = this.questionRepository.getAllQuestions(this.category.getName(), this.topicMovies.getName());
//
//        assertTrue(this.questions.contains(savedQuestion1));
//        assertTrue(this.questions.contains(savedQuestion2));
//        assertTrue(this.questions.contains(savedQuestion3));
//    }
//
//    /*
//     * This Test is to test if All Questions of given Category and Topic and Level are successfully Fetched or Not
//     */
//    @Test
//    public void getQuestionsTest() {
//        Question savedQuestion1 = this.questionRepository.save(this.question);
//
//        this.question = new Question();
//        this.question.setId("1021");
//        this.question.setCategory(this.category);
//        this.question.setTopic(this.topicTvShows);
//        this.question.setLevel("hard");
//        this.question.setType("t/f");
//        this.question.setStatement("Joey proposed to Rachel and Phoebe?");
//        List<String> options = new ArrayList<>();
//        options.add("True");
//        options.add("False");
//        this.question.setOptions(options);
//        this.question.setAnswer("True");
//        this.question.setTimeStamp(System.currentTimeMillis());
//        this.question.setAdmin(this.admin);
//        Question savedQuestion2 = this.questionRepository.save(this.question);
//
//        this.questions = this.questionRepository.getQuestions(this.category.getName(), this.topicMovies.getName(), "easy");
//        assertTrue(this.questions.contains(savedQuestion1));
//
//        this.questions = this.questionRepository.getQuestions(this.category.getName(), this.topicTvShows.getName(), "hard");
//        assertTrue(this.questions.contains(savedQuestion2));
//    }
//}