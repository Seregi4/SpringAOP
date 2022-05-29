package com.levanov.springAop;

import com.levanov.springAop.entity.Book;
import com.levanov.springAop.repository.BookRepository;
import io.swagger.v3.oas.models.OpenAPI;
import io.swagger.v3.oas.models.info.Info;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication
public class SpringAopApplication  implements CommandLineRunner {

	@Autowired
	private final BookRepository bookRepository;

	public SpringAopApplication(BookRepository bookRepository) {
		this.bookRepository = bookRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(SpringAopApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		Book book1 = new Book("Война и мри","Л.Н. Толстой");
		Book book2 = new Book("Народные сказки","Народ");
		Book book3 = new Book("Зверобой","Д.Ф. Купер");

		bookRepository.save(book1);
		bookRepository.save(book2);
		bookRepository.save(book3);
	}

	//  http://localhost:8081/swagger-ui/index.html?configUrl=/v3/api-docs/swagger-config
	@Configuration
	public class SwaggerConfig {

		@Bean
		public OpenAPI customOpenAPI() {
			return new OpenAPI()
					.info(
							new Info()
									.title("Car-service Api")
									.version("1.0.0")
					);
		}

	}

}