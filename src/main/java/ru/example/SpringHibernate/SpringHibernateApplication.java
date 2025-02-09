package ru.example.SpringHibernate;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class SpringHibernateApplication {

	public static void main(String[] args) {
		var context = SpringApplication.run(SpringHibernateApplication.class, args);
	}
}
