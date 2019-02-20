//package com.stackroute.quizify.questionmanager.service;
//
//import com.stackroute.quizify.questionmanager.domain.Admin;
//import com.stackroute.quizify.questionmanager.domain.Category;
//import com.stackroute.quizify.questionmanager.domain.Question;
//import com.stackroute.quizify.questionmanager.domain.Topic;
//import com.stackroute.quizify.questionmanager.exception.NoQuestionFoundException;
//import com.stackroute.quizify.questionmanager.exception.QuestionAlreadyExistsException;
//import com.stackroute.quizify.questionmanager.exception.QuestionDoesNotExistException;
//import com.stackroute.quizify.questionmanager.repository.QuestionRepository;
//import org.junit.After;
//import org.junit.Before;
//import org.junit.Test;
//import org.mockito.InjectMocks;
//import org.mockito.Mock;
//import org.mockito.MockitoAnnotations;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.*;
//import static org.mockito.ArgumentMatchers.any;
//import static org.mockito.Mockito.*;
//
//public class QuestionServiceImplTest {
//
//    private Admin admin;
//    private Category category;
//    private Topic topicMovies;
//    private Topic topicTvShows;
//    private Question question;
//    private List<Question> questions;
//
//    @Mock
//    private QuestionRepository questionRepository;
//
//    @InjectMocks
//    private QuestionServiceImpl questionService;
//
//    /*
//     * Setting Up Values for all required objects and lists
//     * Objects will be Initialized before each Test
//     */
//    @Before
//    public void setUp() throws Exception {
//        MockitoAnnotations.initMocks(this);
//
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
//    @After
//    public void tearDown() throws Exception {
//        this.questions = null;
//        this.question = null;
//        this.topicTvShows = null;
//        this.topicMovies = null;
//        this.category = null;
//        this.admin = null;
//    }
//
//    @Test
//    public void addNewQuestionSuccessTest() throws QuestionAlreadyExistsException {
//        when(this.questionRepository.existsById((String)any())).thenReturn(false);
//        when(this.questionRepository.save((Question)any())).thenReturn(this.question);
//
//        Question savedQuestion = this.questionService.addNewQuestion(this.question);
//        assertEquals(this.question, savedQuestion);
//
//        verify(this.questionRepository, times(1)).existsById((String)any());
//        verify(this.questionRepository, times(1)).save((Question)any());
//    }
//
//    @Test(expected = QuestionAlreadyExistsException.class)
//    public void addNewQuestionFailureTest() throws QuestionAlreadyExistsException {
//        when(this.questionRepository.existsById((String)any())).thenReturn(true);
//
//        Question savedQuestion = this.questionService.addNewQuestion(this.question);
//
//        verify(this.questionRepository, times(1)).existsById((String)any());
//
//    }
//
//    @Test
//    public void updateQuestionSuccessTest() throws QuestionDoesNotExistException {
//        when(this.questionRepository.existsById((String)any())).thenReturn(true);
//        when(this.questionRepository.save((Question)any())).thenReturn(this.question);
//
//        Question updatedQuestion = this.questionService.updateQuestion(this.question);
//        assertEquals(this.question, updatedQuestion);
//
//        verify(this.questionRepository, times(1)).existsById((String)any());
//        verify(this.questionRepository, times(1)).save((Question)any());
//    }
//
//    @Test(expected = QuestionDoesNotExistException.class)
//    public void updateQuestionFailureTest() throws QuestionDoesNotExistException {
//        when(this.questionRepository.existsById((String)any())).thenReturn(false);
//
//        Question savedQuestion = this.questionService.updateQuestion(this.question);
//
//        verify(this.questionRepository, times(1)).existsById((String)any());
//    }
//
//    @Test
//    public void removeQuestionSuccessTest() throws QuestionDoesNotExistException {
//        when(this.questionRepository.existsById((String)any())).thenReturn(true);
//
//        Question updatedQuestion = this.questionService.removeQuestion(this.question);
//        assertEquals(this.question, updatedQuestion);
//
//        verify(this.questionRepository, times(1)).existsById((String)any());
//        verify(this.questionRepository, times(1)).delete((Question)any());
//    }
//
//    @Test(expected = QuestionDoesNotExistException.class)
//    public void removeQuestionFailureTest() throws QuestionDoesNotExistException {
//        when(this.questionRepository.existsById((String)any())).thenReturn(false);
//
//        this.questionService.removeQuestion(this.question);
//
//        verify(this.questionRepository, times(1)).existsById((String)any());
//    }
//
//    @Test
//    public void getQuestionSuccessTest() throws NoQuestionFoundException {
//        this.questions.add(this.question);
//
//        this.question = new Question();
//        this.question.setId("1234567891");
//        this.question.setCategory(this.category);
//        this.question.setTopic(this.topicMovies);
//        this.question.setLevel("easy");
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
//        this.questions.add(this.question);
//
//        this.question = new Question();
//        this.question.setId("1234567892");
//        this.question.setCategory(this.category);
//        this.question.setTopic(this.topicMovies);
//        this.question.setLevel("easy");
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
//        this.questions.add(this.question);
//
//        when(this.questionRepository.getQuestions((String)any(), (String)any(), (String)any())).thenReturn(this.questions);
//
//        List<Question> questionList= this.questionService.getQuestion(this.category.getName(), this.topicMovies.getName(), "easy", 2);
//
//        assertFalse(questionList.isEmpty());
//
//        verify(this.questionRepository, times(1)).getQuestions((String)any(), (String)any(), (String)any());
//    }
//
//    @Test(expected = NoQuestionFoundException.class)
//    public void getQuestionFailureTest() throws NoQuestionFoundException {
//        when(this.questionRepository.getQuestions((String)any(), (String)any(), (String)any())).thenReturn(this.questions);
//
//        this.questionService.getQuestion(this.category.getName(), this.topicMovies.getName(), "easy", 2);
//
//        verify(this.questionRepository, times(1)).getQuestions((String)any(), (String)any(), (String)any());
//    }
//
//    @Test
//    public void getAllQuestionsSuccessTest() throws NoQuestionFoundException {
//        this.questions.add(this.question);
//
//        this.question = new Question();
//        this.question.setId("1234567891");
//        this.question.setCategory(this.category);
//        this.question.setTopic(this.topicMovies);
//        this.question.setLevel("easy");
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
//        this.questions.add(this.question);
//
//        this.question = new Question();
//        this.question.setId("1234567892");
//        this.question.setCategory(this.category);
//        this.question.setTopic(this.topicMovies);
//        this.question.setLevel("easy");
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
//        this.questions.add(this.question);
//
//        when(this.questionRepository.getAllQuestions((String)any(), (String)any())).thenReturn(this.questions);
//
//        List<Question> questionList= this.questionService.getAllQuestions(this.category.getName(), this.topicMovies.getName());
//
//        assertFalse(questionList.isEmpty());
//
//        verify(this.questionRepository, times(1)).getAllQuestions((String)any(), (String)any());
//    }
//
//    @Test(expected = NoQuestionFoundException.class)
//    public void getAllQuestionsFailureTest() throws NoQuestionFoundException {
//        when(this.questionRepository.getAllQuestions((String)any(), (String)any())).thenReturn(this.questions);
//
//        this.questionService.getAllQuestions(this.category.getName(), this.topicMovies.getName());
//
//        verify(this.questionRepository, times(1)).getAllQuestions((String)any(), (String)any());
//    }
//}