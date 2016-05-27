package com.ua.ingk.spboot.initial.repository;

import java.sql.Types;
import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.jdbc.core.JdbcOperations;
import org.springframework.jdbc.support.rowset.SqlRowSet;
import org.springframework.stereotype.Repository;

import com.ua.ingk.spboot.initial.entity.Data;

@Repository("dataRepository")
public class DataRepositoryImpl implements DataRepository<Data> {

	@Value("${datarepo.sql.insert}")
	private String sqlInsert;

	@Value("${datarepo.sql.delete}")
	private String sqlDelete;

	@Value("${datarepo.sql.randomdata}")
	private String sqlRandomData;

	@Value("${table.data.description.name}")
	private String collumnDescriptionName;

	@Autowired
	protected JdbcOperations jdbcOperations;

	@Override
	public void persist(Data object) {

		Object[] params = new Object[] { object.getId(), object.getDescription() };

		int[] types = new int[] { Types.VARCHAR, Types.VARCHAR };

		// StringBuffer stringBuffer = new StringBuffer();
		// stringBuffer.append("INSERT INTO YOURAPP_DATA").append(" (data_id,
		// data_description)").append(" VALUES (?,?)");

		jdbcOperations.update(sqlInsert, params, types);
	}

	@Override
	public void delete(Data object) {
		jdbcOperations.update(sqlDelete + "'" + object.getId().toString() + "';");
	}

	@Override
	public Set<String> getRandomData() {
		Set<String> result = new HashSet<>();

		SqlRowSet rowSet = jdbcOperations.queryForRowSet(sqlRandomData);

		while (rowSet.next()) {
			result.add(rowSet.getString(collumnDescriptionName));
		}

		return result;
	}

}
