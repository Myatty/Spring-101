package com.jdc.spring.jdbc.dao;

 import java.sql.Statement;

import javax.sql.DataSource;

import org.springframework.jdbc.core.DataClassRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.support.GeneratedKeyHolder;

import com.jdc.spring.jdbc.dto.AccountDto;
import com.jdc.spring.jdbc.dto.AccountFrom;

public class AccountDaoImpl implements AccountDao{
	
	private JdbcTemplate template;
	private RowMapper<AccountDto> rowMapper;
	
	public AccountDaoImpl(DataSource dataSource) {
		template = new JdbcTemplate(dataSource);
		rowMapper = new DataClassRowMapper<>(AccountDto.class); // When sql's column names and JAVA record names are identical
	}

	@Override
	public int insert(AccountFrom from) {
		var sql = "INSERT INTO ACCOUNT (name, phone) VALUES (?, ?);";
		var keys = new GeneratedKeyHolder();
		template.update(con -> {
			var stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			stmt.setString(1, from.name());
			stmt.setString(2, from.phone());
			
			return stmt;
		}, keys);
		
		return keys.getKey().intValue();
	}

	@Override
	public long count() {
		return template.queryForObject("SELECT count(id) FROM ACCOUNT", Long.class);
	}

	@Override
	public AccountDto findById(int id) {
		var sql = "SELECT count(id) FROM ACCOUNT WHERE id = ?";
		return template.queryForObject(sql, rowMapper, id);
	}


}
