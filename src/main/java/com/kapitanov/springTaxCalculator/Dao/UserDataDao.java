package com.kapitanov.springTaxCalculator.Dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import com.kapitanov.springTaxCalculator.Model.UserData;

@Transactional
public interface UserDataDao extends CrudRepository<UserData, Long>{

}
