package com.openclassrooms.bobapp;

// import méthode JUnit
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class BobappApplicationTests {

	@Test
	void contextLoads() {
	    //provoque un échec
	    fail("Échec volontaire");
	}

}
