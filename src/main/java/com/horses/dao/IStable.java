package com.horses.dao;

import org.springframework.data.repository.CrudRepository;

import com.horses.domain.Stable;

public interface IStable extends CrudRepository<Stable, Integer>
{

}
