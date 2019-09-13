package com.iiht.CapsuleTaskManager.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.iiht.CapsuleTaskManager.dao.TaskMongoRepository;
import com.iiht.CapsuleTaskManager.entity.TaskMongoEntity;

@RestController
@RequestMapping("/api/v1/taskTable/")
public class TaskTableService {

	@Autowired
	private TaskMongoRepository taskTableRepo;
	
	

	@RequestMapping(value = "/getTaskTable", method = RequestMethod.GET)
	public ResponseEntity<List<TaskMongoEntity>> findTaskTable() {
		return ResponseEntity.ok(taskTableRepo.findAll());
	}

	@RequestMapping(value = "/getTaskTableByID/{id}", method = RequestMethod.GET)
	public ResponseEntity<Optional<TaskMongoEntity>> findTaskTableById(@PathVariable("id") Long id) {
		return ResponseEntity.ok(taskTableRepo.findById(id+""));
	}
	
	@RequestMapping(value = "/saveTaskTable/{id}", method = RequestMethod.POST)
	public ResponseEntity<TaskMongoEntity> saveTaskDetails(@PathVariable("id") Long id,  @RequestBody TaskMongoEntity taskTable) {
		return ResponseEntity.ok(taskTableRepo.save(taskTable));
	}
	
	@RequestMapping(value = "/updateTaskTable/{id}", method = RequestMethod.PUT)
	public TaskMongoEntity updateTaskDetails(@PathVariable("id")Long id , @RequestBody TaskMongoEntity taskTable) {
		TaskMongoEntity taskTableUpdate = taskTableRepo.findById(id+"").orElseThrow(
				() -> new  ResourceNotFoundException("TaskTable not foud for id :" + id));
		
		taskTableUpdate.setEndDate(taskTable.getEndDate());
		taskTableUpdate.setPriority(taskTable.getPriority());
		taskTableUpdate.setStartDate(taskTable.getStartDate());
		taskTableUpdate.setTask(taskTable.getTask());
		
		TaskMongoEntity taskTableUpdated = taskTableRepo.save(taskTableUpdate);
		return taskTableUpdated;
	}

	@RequestMapping(value = "/deleteTaskTable/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<TaskMongoEntity> deleteParentDetails(@PathVariable("id") Long id) {
		TaskMongoEntity taskTableDelete = taskTableRepo.findById(id+"")
				.orElseThrow(() -> new ResourceNotFoundException("Task table not found with id :" + id));
		taskTableRepo.delete(taskTableDelete);
		return ResponseEntity.ok().build();
	}
}
