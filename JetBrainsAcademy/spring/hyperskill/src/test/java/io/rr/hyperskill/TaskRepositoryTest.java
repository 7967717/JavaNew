package io.rr.hyperskill;

import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = DemoApplication.class)
public class TaskRepositoryTest extends TestCase {

    @Autowired
    private TaskRepository taskRepository;

    @Test
    public void test0() {
        Task articleTask = new Task("Finish article", "Finish the article and send for review", true, 0);
        taskRepository.save(articleTask);

        Task speechTask = new Task("Meeting speech", "Prepare the speech for the meeting", false, 2);
        taskRepository.save(speechTask);

        Task drTask = new Task("Call dr Robbins", "Cancel the visit", true, 1);
        taskRepository.save(drTask);

        Task bookingTask = new Task("Book a hotel", "Book a hotel for vacation", true, 4);
        Task savedTask = taskRepository.save(bookingTask);


        System.out.println("Task list:");
        for (Task task : taskRepository.findAll()) {
            System.out.println(task);
        }

        System.out.println("List of enabled ordered tasks:");
        for (Task task : taskRepository.findAllByEnabledOrderByPriorityAsc(true)) {
            System.out.println(task);
        }

        System.out.println("List of tasks with hotel:");
        for (Task task : taskRepository.findBySummaryContaining("hotel")) {
            System.out.println(task);
        }

        System.out.println("Updating tasks's title");
        Task task = taskRepository.findByTitle("Meeting speech");

        if (task != null) {
            System.out.println(task);
            task.setEnabled(true);
            taskRepository.save(task);
            System.out.println(taskRepository.findByTitle("Meeting speech"));
        }
    }
}