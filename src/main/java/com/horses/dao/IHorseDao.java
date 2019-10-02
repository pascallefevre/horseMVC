package com.horses.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.horses.domain.Horse;

@Repository
public interface IHorseDao extends CrudRepository<Horse, Integer>
{

}
