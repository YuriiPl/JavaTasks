package com.home.urix.regform.entity;

import com.home.urix.regform.dto.User;
import lombok.*;


import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
@Entity // This tells Hibernate to make a table out of this class
public class UserDto {

    public UserDto(User user){
        this.password=user.getPassword();
        this.name=user.getName();
        this.email=user.getEmail();
        this.login=user.getLogin();
        this.acceptNewsLatter=user.isAcceptNewsLatter();
        this.userSex=user.getUserSex();
    }

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    long id;

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
