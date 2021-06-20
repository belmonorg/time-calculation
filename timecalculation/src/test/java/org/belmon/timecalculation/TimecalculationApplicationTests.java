package org.belmon.timecalculation;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.text.ParseException;

import org.belmon.timecalculation.services.TimeCalculationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TimecalculationApplicationTests {
	
	@Autowired
	TimeCalculationService timeCalculationService;
	
	@Test
	void contextLoads() {
		 assertThat(timeCalculationService).isNotNull();
	}

	
	@Test
	void calculaDiferencia() throws ParseException {
		long diff = timeCalculationService.getDiffMinutes("Thu, 21 Dec 2000 16:01:07 +0200", "Thu, 21 Dec 2000 17:01:27 +0200");
		assertEquals(60L,diff);

		diff = timeCalculationService.getDiffMinutes("Thu, 21 Dec 2000 16:01:07 +0200", "Thu, 21 Dec 2000 17:01:27 +0100");
		assertEquals(120L,diff);

		diff = timeCalculationService.getDiffMinutes("Thu, 21 Dec 2000 16:01:07 +0200", "Thu, 21 Dec 2000 17:01:27 -0300");
		assertEquals(360L,diff);

		diff = timeCalculationService.getDiffMinutes("Thu, 21 Dec 2000 16:01:07 +0100", "Thu, 21 Dec 2000 17:01:07 +0200");
		assertEquals(0L,diff);

		diff = timeCalculationService.getDiffMinutes("Thu, 21 Dec 2000 16:01:07 +0100", "Thu, 20 Dec 2000 17:01:35 +0200");
		assertEquals(1439L,diff);

		diff = timeCalculationService.getDiffMinutes("Thu, 20 Dec 2000 17:01:35 +0200", "Thu, 21 Dec 2000 16:01:07 +0100");
		assertEquals(1439L,diff);
	}

}
