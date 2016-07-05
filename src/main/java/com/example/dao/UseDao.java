package com.example.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.example.bean.User;
@Component
public interface UseDao extends CrudRepository<User, Integer> {

	User findUserById(Integer id);
}
