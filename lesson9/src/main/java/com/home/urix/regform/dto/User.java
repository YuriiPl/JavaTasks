package com.home.urix.regform.dto;

import com.home.urix.regform.entity.UserSex;
import jdk.nashorn.internal.objects.annotations.Constructor;
import lombok.*;


import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class User {
    private String password;

    private String name;

    private String email;

    private String login;

    private boolean acceptNewsLatter;

    private UserSex userSex;
}
