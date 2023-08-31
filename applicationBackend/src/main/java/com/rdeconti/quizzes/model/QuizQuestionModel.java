package com.rdeconti.quizzes.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table( name = "QUIZ_QUESTIONS" )
public class QuizQuestionModel implements Serializable {

    /*
    FIELD       DESCRIPTION
    id	        The unique id to identify the quiz question.
    QuizService id  	The quiz id to identify the parent test/quiz.
    Type	    The type of question. The type can be a single choice(Yes/No), multiple-choice or select. We can also have type as input and textarea in case the quiz result need manual checks.
    Active	    Flag to identify whether the question is active. A quiz can have several questions, but only selective questions remain active at a time.
    Level	    The level of the question to identify whether it's easy, medium, or difficult.
    Score	    The score of an individual question. We should make sure that only selective questions are active at a time and the total score of the active questions is equal to the quiz score before publishing the quiz.
    Created At	It stores the date and time at which the question is created.
    Updated At	It stores the date and time at which the question is updated.
    Content	    The column used to store the question.
    */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "ID", nullable = false )
    private Integer id;

    @Column( name = "QUIZ_ID", nullable = false )
    private Integer quizId;

    @Column( name = "TYPE", nullable = false )
    private Integer type;

    @Column( name = "ACTIVE", nullable = false )
    private String active;

    @Column( name = "LEVEL", nullable = false )
    private String level;

    @Column( name = "SCORE", nullable = false )
    private Integer score;

    @Column( name = "CREATED_AT", nullable = false )
    private String createdAt;

    @Column( name = "UPDATED_AT", nullable = false )
    private String updatedAt;

    @Column( name = "CONTENT", nullable = false )
    private String content;

}
