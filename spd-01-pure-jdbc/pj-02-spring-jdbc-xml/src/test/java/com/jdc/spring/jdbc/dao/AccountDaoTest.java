package com.jdc.spring.jdbc.dao;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.sql.SQLException;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.context.support.GenericXmlApplicationContext;

import com.jdc.spring.jdbc.dto.AccountFrom;


public class AccountDaoTest {

	static GenericXmlApplicationContext context;

	@BeforeAll
	static void beforeAll() {
		context = new GenericXmlApplicationContext("classpath:/application.xml");
	}
	

	@Order(1)
	@ParameterizedTest
	@CsvSource({
		"Myint Myat, 0942461324, 1",
		"Your Dad, 0932423424, 2",
		"Your Mom, 09324234, 3"
	})
	void test_insert(String name, String phone, int expectedId) {
		var from = new AccountFrom(name, phone);
		var id = dao.create(from);
		assertEquals(expectedId, id)
				
	}
	
	@Order(2)
	@Test
	void test_select_count() {

	    var sql = "select count(*) from ACCOUNT";

	    try (var stmt = connection.prepareStatement(sql)) {

	        var rs = stmt.executeQuery();

	        if (rs.next()) {
	            var count = rs.getLong(1);
	            assertEquals(3L, count);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace(); // Print the SQL error for easier debugging
	        fail("SQL execution failed: " + e.getMessage()); // Fail the test if SQL fails
	    }
	}


	@Order(3)
	@ParameterizedTest
	@CsvSource({
		"Myint Myat, 0942461324, 1",
		"Your Dad, 0932423424, 2",
		"Your Mom, 09324234, 3"
	})
	void test_find_by_id(String name, String phone, int id) {
		
		var sql = "SELECT * FROM  ACCOUNT where id = ? ";
		
		try( var stmt = connection.prepareStatement(sql)){
			
			stmt.setInt(1, id);
			
			var rs = stmt.executeQuery();
			
			if(rs.next()) {
				var nameColumn = rs.getString("name");
				var phoneColumn = rs.getString("phone");
				
				assertEquals(name , nameColumn);
				assertEquals(phone , phoneColumn);
				
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	}
}
