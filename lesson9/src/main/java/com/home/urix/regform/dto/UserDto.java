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
public class UserDto {
    @NotBlank
    @Pattern(regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)[a-zA-Z\\d]{6,24}$", message = "wrongPassword")
    private String password;

    @Pattern(regexp = "^(?! )(?!.* $)(?!(?:.* ){2})[a-zA-Zа-щьюяіїєґА-ЩЮЯІЇЄҐ ']{2,}$", message = "wrongUsername")
    private String name;

    @Email(message = "wrongEmail")
    private String email;

    @Pattern(regexp = "^[\\w\\d]+$", message = "wrongLogin")
    @Size(min = 6, max = 24, message = "wrongLoginSize")
    private String login;

    private boolean acceptNewsLatter;

    @NotNull(message = "wrongGender")
    @Enumerated(EnumType.STRING)
    private UserSex userSex;
}
