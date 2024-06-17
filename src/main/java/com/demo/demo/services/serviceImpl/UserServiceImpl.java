package com.demo.demo.services.serviceImpl;

import com.demo.demo.dtos.CreateUserDTO;
import com.demo.demo.exceptions.BadRequestException;
import com.demo.demo.models.User;
import com.demo.demo.repositories.IUserRepository;
import com.demo.demo.services.IUserService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService {
    public final IUserRepository userRepository;

    @Override
    @Transactional
    public User createUser(CreateUserDTO createUserDTO) {
        Optional<User> userOptional = this.userRepository.findUserByEmailOrPhoneNumber(createUserDTO.getEmail(), createUserDTO.getPhone());
        if (userOptional.isPresent()) {
          throw new BadRequestException(String.format("User with email '%s' or phone number '%s' already exists", createUserDTO.getEmail(), createUserDTO.getPhone()));
        }
        try {
            User user = new User();
            user.setFirstName(createUserDTO.getFirstName());
            user.setLastName(createUserDTO.getLastName());
            user.setEmail(createUserDTO.getEmail());
            user.setPassword(createUserDTO.getPassword());
            user.setPhone(createUserDTO.getPhone());
            user.setGender(createUserDTO.getGender());

            this.userRepository.save(user);
            return user;

        } catch (Exception e) {
            throw new BadRequestException("Failed to create user", e);
        }
    }
}
