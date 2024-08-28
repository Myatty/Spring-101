package com.jdc.spring.jdbc;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.*;
import com.jdc.spring.jdbc.repository.DivisionRepo;

@SpringBootTest
public class DivisionRepoTest {

	@Autowired
	private DivisionRepo repo;
	
	@ParameterizedTest
	@CsvSource({
		",15",
		"M,3",
		"N,1",
		"Yangon Region,1",
		""
	})
	void test_search(String name , int size) {
		
		var result = repo.search(name);
		asssertEquals(size, result.size());
	}
	
	@ParameterizedTest
	@CsvSource({
		
	})
	void test_find_by_id(int id, String name, long districts) {
		
	}
}
