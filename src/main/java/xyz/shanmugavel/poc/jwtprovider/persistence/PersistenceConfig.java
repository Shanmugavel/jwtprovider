/**
 * 
 */
package xyz.shanmugavel.poc.jwtprovider.persistence;

import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * @author shanmugavelsundaramoorthy
 *
 */
@Configuration
@EnableTransactionManagement
@EnableJpaRepositories(basePackages={"xyz.shanmugavel.poc.jwtprovider.persistence"})
@EntityScan(basePackages={"xyz.shanmugavel.poc.jwtprovider.persistence.model", "xyz.shanmugavel.poc.jwtprovider.persistence.converter"})
public class PersistenceConfig {

}
