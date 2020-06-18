package io.rr.hyperskill;

import lombok.Data;
import lombok.NoArgsConstructor;
import javax.persistence.*;

@Data
@NoArgsConstructor
@Entity
@Table(name = "task")
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String title;
    private String summary;
    private boolean enabled;
    private int priority;

    public Task(String title, String summary, boolean enabled, int priority) {
        this.title = title;
        this.summary = summary;
        this.enabled = enabled;
        this.priority = priority;
    }
}
