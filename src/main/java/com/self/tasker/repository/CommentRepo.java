package com.self.tasker.repository;

import com.self.tasker.entity.CommentEntity;
import org.springframework.data.repository.CrudRepository;

public interface CommentRepo extends CrudRepository<CommentEntity, Long> {
}
