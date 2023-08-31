package com.rdeconti.quizzes.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table( name = "QUIZ_METAS" )
public class QuizMetaModel implements Serializable {

    /*
    FIELD       DESCRIPTION
    id	        The unique id to identify the quiz meta.
    QuizService id	    The quiz id to identify the parent test/quiz.
    Key	        The key identifying the meta.
    Content	    The column used to store the quiz metadata.
    */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "ID", nullable = false )
    private Integer id;

    @Column( name = "QUIZ_ID", nullable = false )
    private Integer quizId;

    @Column( name = "KEY", nullable = false )
    private String key;

    @Column( name = "CONTENT", nullable = false )
    private String content;

}
