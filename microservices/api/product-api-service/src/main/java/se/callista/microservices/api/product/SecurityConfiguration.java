package se.callista.microservices.api.product;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

import javax.sql.DataSource;

/**
 * Created by magnus on 18/08/14.
 */
@Configuration
//@EnableWebMvcSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    private static final Logger LOG = LoggerFactory.getLogger(SecurityConfiguration.class);

    /*
    @Autowired
    private DataSource dataSource;

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
        auth.
            jdbcAuthentication()
            .dataSource(dataSource)
            .withDefaultSchema();
    }
    */

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        LOG.info("### Setting up access to hystrix...");

        http
            .authorizeRequests()
                .antMatchers("/hystrix.stream").permitAll();
        LOG.info("### Setting up access to hystrix, done!");
    }

}