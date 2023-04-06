package miu.edu.lab1.controller;

import miu.edu.lab1.domain.Post;
import miu.edu.lab1.domain.dto.response.PostDto;
import miu.edu.lab1.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    PostService postService;

    @GetMapping
    public List<PostDto> findAll() {
        return postService.findAll();
    }

    @GetMapping("/{id}")
    public PostDto findPostById(@PathVariable int id) {
        return postService.findPostById(id);

    }
    @PostMapping
    public void addPost(@RequestBody Post p){
         postService.addPost(p);
    }
    @DeleteMapping("/{id}")
    public void deletePostById(@PathVariable int id){
        postService.deletePostById(id);
    }
   @PutMapping ("/{id}")
    public void updatePostById(@PathVariable int id, @RequestBody Post p){
        postService.updatePostById(id,p);
   }
    @GetMapping("/search")
    public List<Post> findPostsByAuthor(@RequestParam String author){
        return postService.findPostsByAuthor(author);
    }
}
