package com.home.urix.regform.dto;

import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity // This tells Hibernate to make a table out of this class
public class User {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    long id;

    @Column(name = "passwd")
    private String password;

    @Column(name = "username")
    private String name;

    @Column(name = "mail")
    private String email;

    @Column(name = "userlogin", unique = true)
    private String login;

    @Column(name = "newsaccept")
    boolean acceptNewsLatter;

}
