package miu.edu.lab1.service.impl;

import miu.edu.lab1.domain.User;
import miu.edu.lab1.domain.dto.response.PostDto;
import miu.edu.lab1.domain.dto.response.UserDto;

import miu.edu.lab1.respository.UserRepository;
import miu.edu.lab1.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;
    @Autowired
    ModelMapper modelMapper;

    @Override
    public List<UserDto> findAll() {
      return getUserDto(userRepository.findAll());
    }

    @Override
    public UserDto findUserById(int id) {
        return modelMapper.map(userRepository.findById(id),UserDto.class);
    }

    @Override
    public void addUser(User user) {
        userRepository.save(user);
    }

    @Override
    public List<PostDto> getAllPostsByUserId(int id) {
        User user=userRepository.findById(id).get();
        return user.getPosts().stream().map(x->modelMapper.map(x,PostDto.class)).toList();
    }

    @Override
    public List<UserDto> getPostsOfUser(Integer noOfPosts) {
        List<User> users= userRepository.findUserByPostsGreaterThan(noOfPosts);
        return getUserDto(users);
    }


    private List<UserDto> getUserDto(Iterable<User> user) {
        List<UserDto> userDtos = new ArrayList<>();
        user.forEach(p -> userDtos.add(modelMapper.map(p, UserDto.class)));
        return userDtos;
    }


}
