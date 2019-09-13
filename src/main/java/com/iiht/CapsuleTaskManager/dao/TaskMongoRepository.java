package com.iiht.CapsuleTaskManager.dao;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.iiht.CapsuleTaskManager.entity.TaskMongoEntity;

public interface TaskMongoRepository extends MongoRepository<TaskMongoEntity, String> {

	public TaskMongoEntity findBytaskId(long taskId);
	
}
