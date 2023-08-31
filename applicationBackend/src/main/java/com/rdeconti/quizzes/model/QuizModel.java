package com.rdeconti.quizzes.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table( name = "QUIZ_MODELS" )
public class QuizModel implements Serializable {

    /*
    FIELD           DESCRIPTION
    id	            The unique id to identify the quiz.
    Host id	        The host id to identify the quiz host.
    Title	        The quiz title to be displayed on the QuizService Page and the lists.
    Meta Title	    The meta title to be used for browser title and SEO.
    Slug	        The slug to form the URL.
    Summary	        The summary to mention the key highlights.
    Type	        The type to distinguish between the test and the quiz.
    Score	        The total score of the quiz.
    Published	    It can be used to identify whether the test/quiz is publicly available.
    Created At	    It stores the date and time at which the test/quiz is created.
    Updated At	    It stores the date and time at which the test/quiz is updated.
    Published At	It stores the date and time at which the test/quiz is published.
    Starts At	    It stores the date and time at which the test/quiz starts and opens up for takes.
    Ends At	        It stores the date and time at which the test/quiz closes for takes.
    Content	        The column used to store the test/quiz data.
    */

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "ID", nullable = false )
    private Integer id;

    @Column( name = "HOST_ID", nullable = false )
    private Integer hostId;

    @Column( name = "TITLE", nullable = false )
    private String title;

    @Column( name = "META_TITLE", nullable = false )
    private String metaTitle;

    @Column( name = "SLUG", nullable = false )
    private String slug;

    @Column( name = "SUMMARY", nullable = false )
    private String summary;

    @Column( name = "TYPE", nullable = false )
    private String type;

    @Column( name = "SCORE", nullable = false )
    private Integer score;

    @Column( name = "PUBLISHED", nullable = false )
    private String published;

    @Column( name = "CREATED_AT", nullable = false )
    private String createdAt;

    @Column( name = "UPDATED_AT", nullable = false )
    private String updatedAt;

    @Column( name = "PUBLISHED_AT", nullable = false )
    private String publishedAt;

    @Column( name = "STARTS_AT", nullable = false )
    private String startsAt;

    @Column( name = "ENDS_AT", nullable = false )
    private String endsAt;

    @Column( name = "CONTENT", nullable = false )
    private String content;

}
