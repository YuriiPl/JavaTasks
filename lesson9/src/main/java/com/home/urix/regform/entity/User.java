package com.home.urix.regform.entity;

import lombok.*;


import javax.persistence.*;
import javax.validation.constraints.*;


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

    @NotBlank
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,24}$", message = "wrongPassword")
    @Column(name = "passwd")
    private String password;

    @Pattern(regexp = "^\\w{2,24}$", message = "wrongUsername")
    @Column(name = "username")
    private String name;

    @Email(message = "wrongEmail")
    @Column(name = "mail", unique = true)
    private String email;

    @Pattern(regexp = "^\\w{2,24}$", message = "wrongLogin")
    @Size(min = 2, max = 24, message = "wrongLoginSize")
    @Column(name = "userlogin", unique = true)
    private String login;

    @Column(name = "newsaccept")
    //@NotEmpty(message = "wrongAcceptNews")
    private boolean acceptNewsLatter;

    @Column(name = "sex")
    //@NotEmpty(message = "wrongSex")
    @Enumerated(EnumType.STRING)
    private UserSex userSex;

}
