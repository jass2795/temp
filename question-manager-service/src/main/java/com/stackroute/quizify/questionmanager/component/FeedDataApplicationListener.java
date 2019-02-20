package com.stackroute.quizify.questionmanager.component;

import com.stackroute.quizify.questionmanager.domain.Admin;
import com.stackroute.quizify.questionmanager.domain.Category;
import com.stackroute.quizify.questionmanager.domain.Question;
import com.stackroute.quizify.questionmanager.domain.Topic;
import com.stackroute.quizify.questionmanager.exception.QuestionAlreadyExistsException;
import com.stackroute.quizify.questionmanager.repository.QuestionRepository;
import com.stackroute.quizify.questionmanager.service.QuestionService;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.stereotype.Component;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@Component
public class FeedDataApplicationListener implements ApplicationListener<ContextRefreshedEvent>
{
    private QuestionService questionService;
    private Admin admin;
    private Category category;
    private Topic topic;
    private Question question;

    @Autowired
    public FeedDataApplicationListener(QuestionService questionService) {
        this.questionService = questionService;
        /**
         * Dummy Data For Admin Class
         */
        this.admin = new Admin();
        this.admin.setId("101");
        this.admin.setName("Kaustav");

        /**
         * Dummy Data For Category Class
         */
        this.category = new Category();
        this.category.setName("Entertainment");
        this.category.setImageUrl("https://www.gudstory.com/wp-content/uploads/2018/10/Entertainment-1.jpg");
        this.category.setTimeStamp(""+System.currentTimeMillis());
        this.category.setAdmin(this.admin);
        /**
         * Dummy Data For Topic Class
         */
        this.topic = new Topic();
        this.topic.setName("Movies");
        this.topic.setImageUrl("https://boygeniusreport.files.wordpress.com/2016/03/movies-tiles.jpg?quality=98&strip=all");
        this.topic.setTimeStamp(""+System.currentTimeMillis());
        this.topic.setAdmin(this.admin);
        /**
         * Dummy Data For Question Class
         */
        this.question = new Question();

        this.question.setCategory(this.category);
        this.question.setTopic(this.topic);
        this.question.setAdmin(this.admin);
        /**
         * Empty List of Question
         */

    };

//    @Value("com/stackroute/quizify/questionmanager/data/MoviesBasicAll.xlsx")
//    private Resource resource;

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event)
    {
        File file = new File("../ibm-wave3-quizify/question-manager-service/assets/MoviesBasicAll.xlsx");
        System.out.println("-----------------------------------------------------------------------"+file.exists());
        try {
            XSSFWorkbook myWorkBook = new XSSFWorkbook(new FileInputStream(file));
        } catch (IOException e) {
            e.printStackTrace();
        }

        try
        {
            // Finds the XLSX file
           Resource resource = new ClassPathResource("data/MoviesBasicAll.xlsx");


            // Finds the workbook instance for XLSX file

            XSSFWorkbook myWorkBook = new XSSFWorkbook(new FileInputStream(resource.getFile()));
            // Return first sheet from the XLSX workbook
            XSSFSheet mySheet = myWorkBook.getSheetAt(0);
            // Get iterator to all the rows in current sheet
            Iterator<Row> rowIterator = mySheet.iterator();
            // Traversing over each row of XLSX file
            rowIterator.next();//Skipping 1st line
            while (rowIterator.hasNext()) {
                Row row = rowIterator.next();
                this.question.setId("Q_" + System.currentTimeMillis());

                // For each row, iterate through each columns
                Iterator<Cell> cellIterator = row.cellIterator();
                Cell cell;
                List<String> options = null;
                for (int i=1; cellIterator.hasNext(); i++)
                {
                    cell = cellIterator.next();
                    switch (i)
                    {
                        case 3:
                            this.question.setTag(cell.getStringCellValue());
                            break;
                        case 4:
                            this.question.setGenre(cell.getStringCellValue());
                            break;
                        case 5:
                            this.question.setLevel(cell.getStringCellValue());
                            break;
                        case 6:
                            this.question.setType(cell.getStringCellValue());
                        case 7:
                            this.question.setStatement(cell.getStringCellValue());
                        case 8:
                        {
                            options = new ArrayList<>();
                        }
                        case 9:
                        case 10:
                            options.add(cell.getStringCellValue());
                            break;
                        case 11:
                        {
                            options.add(cell.getStringCellValue());
                            this.question.setOptions(options);
                        }
                        break;
                        case 12:
                            this.question.setAnswer(cell.getStringCellValue());
                            break;
                    }

                }
                this.question.setTimeStamp(""+System.currentTimeMillis());
                this.questionService.addNewQuestion(this.question);
            }
        }
        catch (IOException | QuestionAlreadyExistsException e)
        {
            e.printStackTrace();
        }
    }
}
