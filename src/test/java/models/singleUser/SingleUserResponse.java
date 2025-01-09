package models.singleUser;

import lombok.Data;

@Data
public class SingleUserResponse {
    private DataBodyResponse data;
    private SupportBodyResponse support;
}
