package dk.kea.kinoxp_rest.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class JwtRequestModel  {
    private String username;
    private String password;
}
