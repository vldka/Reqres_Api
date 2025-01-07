package models.lombok.singleUser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@lombok.Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Data {
    private Integer id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;
}
