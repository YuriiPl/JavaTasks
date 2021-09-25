package com.home.urix.regform.tdo;

import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class NoteDTO {

    private String password;

    private String name;

    private String email;

    private String login;

    boolean accept;

}
