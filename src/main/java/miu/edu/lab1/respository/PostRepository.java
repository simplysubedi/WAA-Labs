package miu.edu.lab1.respository;

import miu.edu.lab1.domain.Post;
import miu.edu.lab1.domain.PostV2;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PostRepository {
    List<Post> findAll();
    Post findPostById(int id);
    void addPost(Post p);
    void deletePostById(int id);
    void updatePostById(int id, Post p);
    List<PostV2> findAllV2();

    List<Post> findPostsByAuthor(String author);
}
