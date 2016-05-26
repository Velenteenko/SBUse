package com.ua.ingk.spboot.initial.repository;

import java.util.Set;

import com.ua.ingk.spboot.initial.entity.DomainObject;

public interface DataRepository<T extends DomainObject> {

	void persist(T object);

	void delete(T object);

	Set<String> getRandomData();

}
