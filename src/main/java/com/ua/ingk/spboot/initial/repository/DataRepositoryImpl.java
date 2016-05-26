package com.ua.ingk.spboot.initial.repository;

import java.sql.Types;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.stereotype.Repository;

import com.ua.ingk.spboot.initial.entity.Data;

@Repository("dataRepository")
public class DataRepositoryImpl implements DataRepository<Data> {

	@Autowired
	protected JdbcOperations jdbcOperations;

	@Override
	public void persist(Data object) {

		Object[] params = new Object[] { object.getId(), object.getDescription() };

		int[] types = new int[] { Types.INTEGER, Types.VARCHAR };

		StringBuffer stringBuffer = new StringBuffer();
		stringBuffer.append("INSERT INTO YOURAPP_DATA").append(" (data_id, data_description)").append(" VALUES (?,?)");

		jdbcOperations.update(stringBuffer.toString(), params, types);
	}

	@Override
	public void delete(Data object) {
		// TODO Auto-generated method stub

	}

	@Override
	public Set<String> getRandomData() {
		// TODO Auto-generated method stub
		return null;
	}

}
