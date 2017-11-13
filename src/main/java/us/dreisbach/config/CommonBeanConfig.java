package us.dreisbach.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@Configuration
@EnableJpaRepositories("us.dreisbach.repositories")
public class CommonBeanConfig {

}
