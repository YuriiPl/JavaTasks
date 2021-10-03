package com.home.urix.regform.entity;

import com.home.urix.regform.dto.UserDto;
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

    public User(UserDto userDto){
        this.password=userDto.getPassword();
        this.name=userDto.getName();
        this.email=userDto.getEmail();
        this.login=userDto.getLogin();
        this.acceptNewsLatter=userDto.isAcceptNewsLatter();
        this.userSex=userDto.getUserSex();
    }

    @Column(name = "passwd")
    private String password;

    @Column(name = "username")
    private String name;

    @Column(name = "mail", unique = true)
    private String email;

    @Column(name = "userlogin", unique = true)
    private String login;

    @Column(name = "newsaccept")
    private boolean acceptNewsLatter;

    @Column(name = "sex")
    private UserSex userSex;

}
