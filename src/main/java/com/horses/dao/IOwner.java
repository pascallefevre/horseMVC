package com.horses.dao;

import org.springframework.data.repository.CrudRepository;

import com.horses.domain.Owner;

public interface IOwner extends CrudRepository<Owner, Integer>
{

}
