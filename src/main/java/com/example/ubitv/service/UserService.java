package com.example.ubitv.service;

import com.example.ubitv.entity.UserEntity;
import com.example.ubitv.exception.UserAlreadyExistException;
import com.example.ubitv.exception.UserByIdNotFoundException;
import com.example.ubitv.model.User;
import com.example.ubitv.repository.UserRepo;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    private final UserRepo userRepo;

    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public void registration(UserEntity user) throws UserAlreadyExistException {
        if (userRepo.findByUsername(user.getUsername()) != null) {
            throw new UserAlreadyExistException("Пользователь с таким username уже существует");
        }
        userRepo.save(user);
    }

    public User getOne(Long id) throws UserByIdNotFoundException {
        UserEntity user = userRepo.findById(id).get();
        if(user == null) {
            throw new UserByIdNotFoundException("Пользователь с таким id не найден");
        }
        return User.toModel(user);
    }

    public Long delete(Long id) {
        userRepo.deleteById(id);
        return id;
    }
}
