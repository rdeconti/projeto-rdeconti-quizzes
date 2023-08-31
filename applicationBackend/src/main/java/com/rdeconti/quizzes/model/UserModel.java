package com.rdeconti.quizzes.model;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Data
@Entity
@Table( name = "USERS" )
public class UserModel implements Serializable {

        /*
        FIELD           DESCRIPTION
        id	            The unique id to identify the user.
        First Name	    The first name of the user.
        Middle Name	    The middle name of the user.
        Last Name	    The last name of the user.
        Mobile	        The mobile number of the user. It can be used for login and registration purposes.
        Email	        The email of the user. It can be used for login and registration purposes.
        Password        The password hash generated by the appropriate algorithm (Hash). We must avoid storing plain passwords.
        Host	        The flag to identify whether the user can host a quiz.
        Registered At	This column can be used to calculate the life of the user with the application.
        Last Login	    It can be used to identify the last login of the user.
        Intro	        The brief introduction of the Host User to be displayed on the Test or QuizService Page.
        Profile	        The owner details to be displayed on the Test or QuizService Page.
        */

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column( name = "ID", nullable = false )
        private Integer id;

        @Column( name = "FIRST_NAME", nullable = false )
        private String firstName;

        @Column( name = "MIDDLE_NAME", nullable = false )
        private String middleName;

        @Column( name = "LAST_NAME", nullable = false )
        private String lastName;

        @Column( name = "MOBILE", nullable = false )
        private String mobile;

        @Column( name = "EMAIL", nullable = false )
        private String email;

        @Column( name = "PASSWORD", nullable = false )
        private String password;

        @Column( name = "HOST", nullable = false )
        private String host;

        @Column( name = "REGISTERED_AT", nullable = false )
        private String registeredAt;

        @Column( name = "LAST_LOGIN", nullable = false )
        private String lastLogin;

        @Column( name = "INTRO", nullable = false )
        private String intro;

        @Column( name = "PROFILE", nullable = false )
        private String profile;

}