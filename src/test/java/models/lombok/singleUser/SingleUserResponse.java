package models.lombok.singleUser;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;
import lombok.Getter;

@Data
@Getter
@JsonIgnoreProperties(ignoreUnknown = true)
public class SingleUserResponse {
    private models.lombok.singleUser.Data data;
    private Support support;
}
