package us.dreisbach.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

@Configuration
@Profile("test")
public class TestConfig {
	public TestConfig() {
		System.out.println("Test profile");
	}
}
