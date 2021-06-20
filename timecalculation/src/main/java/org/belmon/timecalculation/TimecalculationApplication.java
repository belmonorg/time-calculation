package org.belmon.timecalculation;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@SpringBootApplication
public class TimecalculationApplication implements CommandLineRunner {

    final Logger LOGGER = LoggerFactory.getLogger(getClass());
	
    public static void main(String[] args) 
    {
        SpringApplication app = new SpringApplication(TimecalculationApplication.class);
        app.run(args);
    }
 
    @Override
    public void run(String... args) throws Exception 
    {
    	LOGGER.info("Iniciada aplicacion Time Calculation..."); 
    	
    }

}
