package miu.edu.lab1.respository.impl;

import miu.edu.lab1.domain.Post;
import miu.edu.lab1.domain.PostV2;
import miu.edu.lab1.respository.PostRepository;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
@Repository
public class PostRepositoryImpl implements PostRepository {
    private static List<Post> posts;
    private static List<PostV2> postsV2;
    private static int postId = 3111;

    static {
        posts = new ArrayList<>();
        Post p1 = new Post(1, "Art of Programming", "All the shortcuts of programming", "Mack Huming");
        Post p3 = new Post(1, "Art of Programming v2", "All the shortcuts of programming", "Mack Huming");
        Post p2 = new Post(2, "Basics of Programming", "All the basics of programming", "Figo Tumber");
        posts.add(p1);
        posts.add(p2);
        posts.add(p3);
        postsV2 = new ArrayList<>();
        PostV2 pV1 = new PostV2(1, "Art of Programming V2", "All the shortcuts of programming", "Mack Huming");
        PostV2 pV2 = new PostV2(2, "Basics of Programming V2", "All the basics of programming", "Figo Tumber");
        postsV2.add(pV1);
        postsV2.add(pV2);
    }

    public List<Post> findAll() {
        return posts;
    }
    public List<PostV2> findAllV2() {
        return postsV2;
    }

    @Override
    public List<Post> findPostsByAuthor(String author) {
        return posts
                .stream()
                .filter(l -> l.getAuthor() .equals(author))
                .toList();
    }

    public Post findPostById(int id) {
        return posts
                .stream()
                .filter(l -> l.getId() == id)
                .findFirst()
                .orElse(null);
    }

    public void addPost(Post p) {
        p.setId(postId);
        postId++;
        posts.add(p);
    }

    public void deletePostById(int id) {
        var post = posts
                .stream()
                .filter(l -> l.getId() == id)
                .findFirst().get();
        posts.remove(post);
    }
    public void updatePostById(int id, Post p) {
        Post toUpdate = findPostById(id);
        toUpdate.setAuthor(p.getAuthor());
        toUpdate.setContent(p.getContent());
        toUpdate.setTitle(p.getTitle());
    }
}
