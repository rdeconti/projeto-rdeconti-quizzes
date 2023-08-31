package com.rdeconti.quizzes.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Calendar;

@Data
@Entity
@Table( name = "QUIZ_ANSWERS" )
public class QuizAnswerModel implements Serializable {

    /*
    FIELD       DESCRIPTION
    id	        The unique id to identify the quiz answer.
    QuizService id	    The quiz id to identify the parent test/quiz.
    Question id	The question id to identify the parent question.
    Active	    Flag to identify whether the answer is active.
    Correct	    Flag to identify whether the answer is correct.
    Created At	It stores the date and time at which the answer is created.
    Updated At	It stores the date and time at which the answer is updated.
    Content	    The column used to store the answer.
    */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "ID", nullable = false )
    private Integer id;

    @Column( name = "QUIZ_ID", nullable = false )
    private Integer quizId;

    @Column( name = "QUESTION_ID", nullable = false )
    private Integer questionId;

    @Column( name = "ACTIVE", nullable = false )
    private Integer active;

    @Column( name = "CORRECT", nullable = false )
    private Integer correct;

    @Column( name = "CREATED_AT", nullable = false )
    private Calendar createdAt;

    @Column( name = "UPDATED_AT", nullable = false )
    private String updatedAt;

    @Column( name = "CONTENT", nullable = false )
    private String content;

}
