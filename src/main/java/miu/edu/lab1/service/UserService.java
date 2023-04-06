package miu.edu.lab1.service;

import miu.edu.lab1.domain.User;
import miu.edu.lab1.domain.dto.response.PostDto;
import miu.edu.lab1.domain.dto.response.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();

    UserDto findUserById(int id);

    void addUser(User user);

    List<PostDto> getAllPostsByUserId(int id);

    List<UserDto> getPostsOfUser(Integer noOfPosts);
}