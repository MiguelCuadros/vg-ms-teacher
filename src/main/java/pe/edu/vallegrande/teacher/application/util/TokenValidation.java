package pe.edu.vallegrande.teacher.application.util;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class TokenValidation {

    private boolean valid;
    private String role;

}
