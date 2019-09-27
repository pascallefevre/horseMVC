package com.horses.dao;

import org.springframework.data.repository.CrudRepository;

import com.horses.domain.Horse;

public interface IHorseDao extends CrudRepository<Horse, Integer>
{

}
