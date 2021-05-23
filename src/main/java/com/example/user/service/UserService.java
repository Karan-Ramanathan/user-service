package com.example.user.service;

import com.example.user.exception.ResourceAlreadyExistsException;
import com.example.user.exception.ResourceNotFoundException;
import com.example.user.model.User;
import com.example.user.repository.UserRepository;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class UserService {

  private final UserRepository userRepository;

  public UserService(UserRepository userRepository) {
    this.userRepository = userRepository;
  }

  public User getUser(String email) {
    return userRepository.findById(email).orElseThrow(
        () -> new ResourceNotFoundException("User with the provided email does not exist!")
    );
  }

  public User addUser(User addUser) {
    Optional<User> newUserEmail = userRepository.findById(addUser.getEmail());
    if (newUserEmail.isPresent()) {
      throw new ResourceAlreadyExistsException("Resource already exists in DB!");
    }
    return userRepository.save(addUser);
  }

  public User updateUser(String email, User updateUser) {
    return userRepository.findById(email)
        .map(user -> {
          user.setFirstName(updateUser.getFirstName());
          user.setLastName(updateUser.getLastName());
          user.setPassword(updateUser.getPassword());
          return userRepository.save(user);
        })
        .orElseGet(() -> {
          updateUser.setEmail(email);
          return userRepository.save(updateUser);
        });
  }

  public User deleteUser(String email) {
    Optional<User> deleteUser = userRepository.findById(email);
    if (deleteUser.isPresent()) {
      userRepository.deleteById(email);
      return deleteUser.get();
    }
    throw new ResourceNotFoundException("Resource to be deleted was not found in DB!");
  }
}
