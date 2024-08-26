package com.jdc.spring.jdbc.dao;

import com.jdc.spring.jdbc.dto.AccountDto;
import com.jdc.spring.jdbc.dto.AccountFrom;

public interface AccountDao {

	int insert(AccountFrom from);
	long count();
	AccountDto findById(int id);
}
