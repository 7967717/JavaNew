package io.rr.hyperskill;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner runApplication(TaskRepository taskRepository) {
		return (args -> {
			// call methods you want to use
		});
	}

	private void performCreateOperations(TaskRepository taskRepository) {
		Task articleTask = new Task("Finish article", "Finish the article and send for review", true, 0);
		taskRepository.save(articleTask);

		Task speechTask = new Task("Meeting speech", "Prepare the speech for the meeting", false, 2);
		taskRepository.save(speechTask);

		Task drTask = new Task("Call dr Robbins", "Cancel the visit", true, 1);
		taskRepository.save(drTask);

		Task bookingTask = new Task("Book a hotel", "Book a hotel for vacation", true, 4);
		Task savedTask = taskRepository.save(bookingTask);
	}
}
