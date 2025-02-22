package models.singleUser;

@lombok.Data
public class SingleUserDataResponse {
    private Integer id;
    private String email;
    private String first_name;
    private String last_name;
    private String avatar;
}
