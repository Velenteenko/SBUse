package com.ua.ingk.spboot.initial.service;

import java.util.Set;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.ua.ingk.spboot.initial.entity.Data;
import com.ua.ingk.spboot.initial.repository.DataRepository;

@Service("dataService")
public class DataServiceImpl implements DataService {

	private static final Logger logger = LoggerFactory.getLogger(DataServiceImpl.class);

	@Autowired
	@Qualifier("dataRepository")
	private DataRepository<Data> dataRepository;

	@Override
	public boolean persist(String problem) {

		try {
			dataRepository.persist(new Data(UUID.randomUUID(), problem));
			return true;
		} catch (Exception e) {
			logger.error("ERROR SAVING DATA: " + e.getMessage());
			return false;
		}
	}

	@Override
	public Set<String> getRandomData() {
		return dataRepository.getRandomData();
	}

}
