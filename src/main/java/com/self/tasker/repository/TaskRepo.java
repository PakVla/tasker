package com.self.tasker.repository;

import com.self.tasker.entity.TaskEntity;
import org.springframework.data.repository.CrudRepository;

public interface TaskRepo extends CrudRepository<TaskEntity, Long> {
}
