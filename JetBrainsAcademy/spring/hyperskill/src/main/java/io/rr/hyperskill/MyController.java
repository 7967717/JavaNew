package io.rr.hyperskill;

import io.rr.hyperskill.test.Task;
import io.rr.hyperskill.test.UserInfo;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class MyController {
    private final ArrayList<Task> tasks = new ArrayList<>();

    @PostMapping(value = "/greet", consumes = "application/json")
    public String greet(@RequestBody UserInfo userInfo) {
        if (userInfo.isEnabled()) {
            return String.format("Hello! Nice to see you, %s!", userInfo.getName());
        } else return String.format("Hello! Nice to see you, %s! Your account is disabled", userInfo.getName());
    }

    @PostMapping(value = "/greetUsers", consumes = "application/json")
    public List<String> greetUsers(@RequestBody List<UserInfo> users) {
        ArrayList<String> list = new ArrayList<>();
        for (UserInfo user : users) {
            if (user.isEnabled()) {
                list.add(String.format("Hello! Nice to see you, %s!", user.getName()));
            } else list.add(String.format("Hello! Nice to see you, %s! Your account is disabled!", user.getName()));
        }
        return list;
    }

    @PostMapping("/tasks")
    public void addTask(@RequestBody Task task) {
        tasks.add(task);
    }

    @GetMapping("/tasks/{id}")
    public Task getTaskByID(@PathVariable int id) {
        return tasks.get(id - 1);
    }

}
