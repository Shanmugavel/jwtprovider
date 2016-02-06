package xyz.shanmugavel.poc.jwtprovider;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

import lombok.extern.slf4j.Slf4j;
import xyz.shanmugavel.poc.jwtprovider.persistence.PersistenceConfig;
import xyz.shanmugavel.poc.jwtprovider.security.SecurityConfigAdapter;
import xyz.shanmugavel.poc.jwtprovider.service.ServiceConfig;
import xyz.shanmugavel.poc.jwtprovider.web.WebConfig;

/**
 * Hello world!
 *
 */
@SpringBootApplication
@Import({ SecurityConfigAdapter.class, WebConfig.class, ServiceConfig.class, PersistenceConfig.class})
@Slf4j
public class App 
{
	
    public static void main( String[] args )
    {
    	SpringApplication.run(App.class, args);
    	log.info("Bootstrapped App!!!");
    }
}
