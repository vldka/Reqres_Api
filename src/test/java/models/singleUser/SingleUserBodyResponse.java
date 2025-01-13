package models.singleUser;

import lombok.Data;

@Data
public class SingleUserBodyResponse {
    private SingleUserDataResponse data;
    private SingleUserSupportResponse support;
}
