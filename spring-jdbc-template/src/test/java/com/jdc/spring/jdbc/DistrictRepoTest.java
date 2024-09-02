package com.jdc.spring.jdbc;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import com.jdc.spring.jdbc.repository.DistrictRepo;

@SpringBootTest
public class DistrictRepoTest {

	@Autowired
	private DistrictRepo districtRepo;
	
	@ParameterizedTest
	@CsvSource({
	    "1, 'Downtown Yangon'",
	    "2, 'North Okkalapa'",
	    "3, 'South Dagon'",
	    "4, 'Insein'",
	    "5, 'Hlaing'",
	    "6, 'Shwepyitha'",
	    "7, 'Hlaingthaya'",
	    "8, 'Mingaladon'",
	    "9, 'Thaketa'",
	    "10, 'Kamayut'",
	    "11, 'Kyeemyindaing'",
	    "12, 'Sanchaung'",
	    "13, 'Thingangyun'",
	    "14, 'Tamwe'",
	    "15, 'Mayangone'",
	    "16, 'Kyauktada'",
	    "17, 'Dagon'",
	    "18, 'Pabedan'",
	    "19, 'Lanmadaw'",
	    "20, 'Bahan'"
	})
	void test_search(Integer divisionId, String name, int expectedSize) {
        var result = districtRepo.search(divisionId, name);
        assertNotNull(result, "The search result should not be null");
        assertEquals(expectedSize, result.size(), "The size of the search result is incorrect");

        // Optionally, check the attributes of the results
        if (expectedSize > 0) {
            var firstResult = result.get(0);
            assertEquals(divisionId, firstResult.divisionId(), "The division ID of the first result is incorrect");
            assertEquals(name, firstResult.name(), "The name of the first result is incorrect");
        }
    }
}
