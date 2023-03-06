package org.spring.app.config;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.TransactionManager;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import javax.sql.DataSource;
import java.util.Objects;

@Configuration
@ComponentScan("org.spring.app")
@EnableWebMvc
@PropertySource("classpath:database.properties")
public class SpringConfig implements WebMvcConfigurer {
    private final Environment environment;

    public SpringConfig(Environment environment) {
        this.environment = environment;
    }

    @Bean
    public InternalResourceViewResolver viewResolver() {
        InternalResourceViewResolver viewResolver = new InternalResourceViewResolver();
        viewResolver.setPrefix("/WEB-INF/views/");
        viewResolver.setSuffix(".jsp");
        return viewResolver;
    }

    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/resources/**")
                .addResourceLocations("/resources/");
    }

    @Bean
    public DataSource dataSource() {
        HikariConfig config = new HikariConfig();
        config.setDriverClassName(environment.getProperty("jdbc.driver"));
        config.setJdbcUrl(environment.getProperty("jdbc.url"));
        config.setUsername(environment.getProperty("jdbc.username"));
        config.setPassword(environment.getProperty("jdbc.password"));
        config.setTransactionIsolation(environment.getProperty("jdbc.transactionIsolation"));
        config.setMaximumPoolSize(
                Integer.parseInt(
                        Objects.requireNonNull(
                                environment.getProperty("jdbc.maximumPoolSize"))));
        config.setMinimumIdle(
                Integer.parseInt(
                        Objects.requireNonNull(
                                environment.getProperty("jdbc.minimumIdle"))));
        config.setIdleTimeout(
                Long.parseLong(
                        Objects.requireNonNull(
                                environment.getProperty("jdbc.idleTimeout"))));
        config.setConnectionTimeout(
                Long.parseLong(
                        Objects.requireNonNull(
                                environment.getProperty("jdbc.connectionTimeout"))));
        return new HikariDataSource(config);
    }

    @Bean
    public JdbcTemplate jdbcTemplate() {
        return new JdbcTemplate(dataSource());
    }

    @Bean
    public TransactionManager transactionManager() {
        return new DataSourceTransactionManager(dataSource());
    }


}
