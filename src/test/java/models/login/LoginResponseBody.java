package models.login;

import lombok.Data;

@Data
public class LoginResponseBody {
    private String token;
    private String error;
}
