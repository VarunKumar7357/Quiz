package com.gvk.quizservice.model;

import lombok.Data;

@Data
public class QuizDto {
    private String categoryName;
    private Integer numQ;
    private String title;
}
