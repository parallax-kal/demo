package com.demo.demo.services;


import com.demo.demo.dtos.CreateUserDTO;
import com.demo.demo.dtos.UpdateUserDTO;
import com.demo.demo.models.User;

import java.util.List;
import java.util.UUID;

public interface IUserService {
    public User createUser(CreateUserDTO user);
    public List<User> getAllUsers();
    public User getUserById(UUID uuid);
    public User getUserByEmail(String email);
    public User updateUser(UUID userId, UpdateUserDTO updateUserDTO);
    public User deleteUser(UUID userId);
}
