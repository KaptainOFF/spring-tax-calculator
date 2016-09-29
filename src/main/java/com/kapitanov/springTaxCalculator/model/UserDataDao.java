package com.kapitanov.springTaxCalculator.model;

import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface UserDataDao extends CrudRepository<UserData, Long>{

}
