package miu.edu.lab1.domain.dto.response;

import lombok.Data;
import miu.edu.lab1.domain.Post;

import java.util.List;

@Data
public class UserDto {
    long id;
    String name;
    List<Post> posts;
}
