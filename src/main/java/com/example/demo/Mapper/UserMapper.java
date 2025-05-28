package com.example.demo.Mapper;

import org.springframework.stereotype.Component;

import com.example.demo.ModelDTO.UserDTO;
import com.example.demo.ModelDomain.User;

import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")

public interface UserMapper {

    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    UserDTO toDto(User user);
    List<UserDTO> toDtoList(List<User> users);

    User toEntity(UserDTO dto);
}