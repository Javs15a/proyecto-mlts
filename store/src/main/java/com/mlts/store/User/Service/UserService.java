package com.mlts.store.User.Service;

import com.mlts.store.Exception.NotFoundException;
import com.mlts.store.User.Dto.UserDto;

import java.util.List;

public interface UserService {
    UserDto findUserById(Integer id) throws NotFoundException;
    List<UserDto> findAllUsers();
    UserDto createUser(UserDto dto);
    UserDto updateUser(UserDto dto) throws NotFoundException;
    boolean deleteUser(Integer id) throws NotFoundException;
}
