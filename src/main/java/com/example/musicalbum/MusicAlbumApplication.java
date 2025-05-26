package com.example.musicalbum;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = "com.example.musicalbum")
@EnableJpaRepositories(basePackages = "com.example.musicalbum.repository")
public class MusicAlbumApplication {
	public static void main(String[] args) {
		SpringApplication.run(MusicAlbumApplication.class, args);
	}

}
