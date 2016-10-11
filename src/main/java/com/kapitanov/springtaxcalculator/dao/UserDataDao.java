package com.kapitanov.springtaxcalculator.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.kapitanov.springtaxcalculator.model.UserData;

@Transactional
public interface UserDataDao extends CrudRepository<UserData, Long>{

}
