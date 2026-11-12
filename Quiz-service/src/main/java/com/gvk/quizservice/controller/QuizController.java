package com.gvk.quizservice.controller;


import com.gvk.quizservice.model.QuestionWrapper;
import com.gvk.quizservice.model.QuizDto;
import com.gvk.quizservice.model.Response;
import com.gvk.quizservice.service.QuizService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/Quiz")
public class QuizController {

    QuizService quizService;

    private QuizController(QuizService quizService){
        this.quizService=quizService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createQuiz(@RequestBody QuizDto quizDto){
        return quizService.createQuiz(quizDto.getCategoryName(), quizDto.getNumQ(), quizDto.getTitle());
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(@PathVariable Integer id){
          return quizService.getQuizQuestions( id);
    }
    @PostMapping("/submit/{id}")
    public ResponseEntity<Integer> submitQuiz(@PathVariable Integer id, @RequestBody List<Response> responses){
        return quizService.calculateResults( id, responses);
    }
}
