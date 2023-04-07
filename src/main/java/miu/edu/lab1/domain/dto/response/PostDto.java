package miu.edu.lab1.domain.dto.response;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import miu.edu.lab1.domain.Comment;

import java.util.List;

@Data
public class PostDto {
    long id;
    String title;

    String author;
    List<Comment> comments;
}
