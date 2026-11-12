package com.gvk.quizservice.service;


import com.gvk.quizservice.Dao.QuizDao;
import com.gvk.quizservice.feign.QuizInterface;
import com.gvk.quizservice.model.QuestionWrapper;
import com.gvk.quizservice.model.Quiz;
import com.gvk.quizservice.model.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;

@Service
public class QuizService {
    @Autowired
    QuizDao quizDao;

    @Autowired
    QuizInterface quizInterface;

    public ResponseEntity<String> createQuiz(String category, int numQ, String title){

        List<Integer> questions= quizInterface.getQuestionsForQuiz(category,numQ).getBody();
        Quiz quiz= new Quiz();
        quiz.setTitle(title);
        quiz.setQuestionsids(questions);
        quizDao.save(quiz);
        return new ResponseEntity<>("Success", HttpStatus.CREATED);
    }
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions( Integer id){
        Quiz quiz= quizDao.findById(id).get();
        List<Integer> questionIds= quiz.getQuestionsids();

      ResponseEntity<List<QuestionWrapper>> questions = quizInterface.getQuestionsFromId(questionIds);
        return questions;
    }
    public ResponseEntity<Integer> calculateResults( Integer id,List<Response> responses){
       ResponseEntity<Integer> score = quizInterface.getScore(responses);
       return score;
    }
}
