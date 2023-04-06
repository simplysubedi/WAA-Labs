package miu.edu.lab1.controller;

import miu.edu.lab1.domain.User;
import miu.edu.lab1.domain.dto.response.PostDto;
import miu.edu.lab1.domain.dto.response.UserDto;
import miu.edu.lab1.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {
    @Autowired
    UserService userService;

    @GetMapping
    public List<UserDto> findAll(@RequestParam(required = false) Integer noOfPosts) {
        System.out.println(noOfPosts);
        if (noOfPosts == null) {
            return userService.findAll();
        } else {
            return userService.getPostsOfUser(noOfPosts);
        }
    }

    @GetMapping("/{id}")
    public UserDto findUserById(@PathVariable int id) {
        return userService.findUserById(id);
    }

    @PostMapping
    public void addUser(@RequestBody User user) {
        userService.addUser(user);
    }

    @GetMapping("/{id}/posts")
    List<PostDto> getAllPostByUserId(@PathVariable int id) {
        return userService.getAllPostsByUserId(id);
    }
}
