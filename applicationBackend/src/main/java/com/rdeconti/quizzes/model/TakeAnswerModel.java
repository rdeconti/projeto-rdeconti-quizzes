package com.rdeconti.quizzes.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table( name = "TAKE_ANSWERS" )
public class TakeAnswerModel implements Serializable {

    /*
    FIELD       DESCRIPTION
    id	        The unique id to identify the take answer.
    Take id	    The take id to identify the quiz attempt.
    Answer id	The answer id to identify the quiz answer.
    Active	    Flag to identify whether the answer is active.
    Created At	It stores the date and time at which the answer is created.
    Updated At	It stores the date and time at which the answer is updated.
    Content	    The column used to store the answer in case of input or textarea type of questions.
    */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "ID", nullable = false )
    private Integer id;

    @Column( name = "TAKE_ID", nullable = false )
    private Integer takeId;

    @Column( name = "ANSWER_ID", nullable = false )
    private Integer answerId;

    @Column( name = "ACTIVE", nullable = false )
    private String active;

    @Column( name = "CREATED_AT", nullable = false )
    private String createdAt;

    @Column( name = "UPDATED_AT", nullable = false )
    private String updatedAt;

    @Column( name = "CONTENT", nullable = false )
    private String content;
}
