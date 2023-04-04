package miu.edu.lab1.service;

import miu.edu.lab1.domain.Post;
import miu.edu.lab1.domain.PostV2;
import miu.edu.lab1.domain.dto.response.PostDto;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

public interface PostService {
    List<PostDto> findAll();
    List<PostV2> findAllV2();
    PostDto findPostById(int id);

    void addPost(Post p);

    void deletePostById(int id);

    void updatePostById(int id, Post p);

    List<Post> findPostsByAuthor(String author);
}
