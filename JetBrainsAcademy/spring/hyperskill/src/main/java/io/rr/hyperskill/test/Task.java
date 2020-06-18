package io.rr.hyperskill.test;

import lombok.Data;

@Data
public class Task {
    private int id;
    private String name;
    private String description;
    private boolean completed;
}
