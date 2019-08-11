package org.starichkov.java.examples.spring;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;

/**
 * @author Vadim Starichkov
 * @since 11.08.2019 15:49
 */
@Configuration
@PropertySource("classpath:application.properties")
public class Config {

  @Bean
  public PropertySourcesPlaceholderConfigurer propertyConfig() {
    return new PropertySourcesPlaceholderConfigurer();
  }
}
