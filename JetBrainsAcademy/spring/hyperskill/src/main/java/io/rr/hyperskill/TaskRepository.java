package io.rr.hyperskill;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface TaskRepository extends CrudRepository<Task, Long> {

    Task findByTitle(String title);

    List<Task> findAllByEnabled(boolean isEnabled);

    List<Task> findAllByEnabledOrderByPriorityAsc(boolean isEnabled);

    List<Task> findBySummaryContaining(String string);

}
