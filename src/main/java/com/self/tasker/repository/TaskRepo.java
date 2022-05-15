package com.self.tasker.repository;

import com.self.tasker.entity.TaskEntity;
import com.self.tasker.entity.UserEntity;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface TaskRepo extends CrudRepository<TaskEntity, Long> {
    List<TaskEntity> findByUserCreator(Optional<UserEntity> byId);

    List<TaskEntity> findByUserCreatorAndCompleted(Optional<UserEntity> byId, Boolean completed);

    List<TaskEntity> findByIdUserExecutor(Long id);

    List<TaskEntity> findByIdUserExecutorAndCompleted(Long id, Boolean completed);

    List<TaskEntity> findByCompleted(Boolean completed);
}
