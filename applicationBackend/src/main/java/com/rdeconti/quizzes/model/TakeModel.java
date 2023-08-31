package com.rdeconti.quizzes.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table( name = "TAKES" )
public class TakeModel implements Serializable {

    /*
    FIELD       DESCRIPTION
    id	        The unique id to identify the take.
    User id	    The user id to identify the quiz taker.
    QuizService id	    The quiz id to identify the quiz.
    Status	    The status of the take. It can be enrolled, started, paused, finished, declared.
    Score	    The total score obtained by the user.
    Created At	It stores the date and time at which the take is created.
    Updated At	It stores the date and time at which the take is updated.
    Started At	It stores the date and time at which the take started.
    Finished At	It stores the date and time at which the take is finished.
    Content	    The column used to store the take remarks.
    */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "ID", nullable = false )
    private Integer id;

    @Column( name = "USER_ID", nullable = false )
    private Integer userId;

    @Column( name = "QUIZ_ID", nullable = false )
    private Integer quizId;

    @Column( name = "STATUS", nullable = false )
    private String status;

    @Column( name = "SCORE", nullable = false )
    private Integer score;

    @Column( name = "CREATED_AT", nullable = false )
    private String createdAt;

    @Column( name = "UPDATED_AT", nullable = false )
    private String updatedAt;

    @Column( name = "STARTED_AT", nullable = false )
    private String startedAt;

    @Column( name = "FINISHED_AT", nullable = false )
    private String finishedAt;

    @Column( name = "CONTENT", nullable = false )
    private String content;


}
