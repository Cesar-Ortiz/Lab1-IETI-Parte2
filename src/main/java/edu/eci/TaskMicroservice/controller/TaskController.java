package edu.eci.TaskMicroservice.controller;

import edu.eci.TaskMicroservice.data.Task;
import edu.eci.TaskMicroservice.dto.TaskDto;
import edu.eci.TaskMicroservice.service.TaskService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/v2/task")
public class TaskController {
    private int cont=0;
    private final TaskService taskService;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @GetMapping
    public ResponseEntity<List<Task>> all(){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(taskService.all());
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Task> findById(@PathVariable String id){
        try{
            return ResponseEntity.status(HttpStatus.OK).body(taskService.findById(id));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PostMapping
    public ResponseEntity<Task> create(@RequestBody TaskDto taskdto){
        try{
            cont = cont+1;
            String id = String.valueOf(cont);
            Task task = new Task(id,taskdto.getName(),taskdto.getDescription(),taskdto.getStatus(),taskdto.getAssignedTo(),taskdto.getDueDate(),taskdto.getCreated());
            return ResponseEntity.status(HttpStatus.OK).body(taskService.create(task));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Task> update(@RequestBody TaskDto taskDto,@PathVariable String id){
        try{
            Task task = new Task(id,taskDto.getName(),taskDto.getDescription(),taskDto.getStatus(),taskDto.getAssignedTo(),taskDto.getDueDate(),taskDto.getCreated());
            return ResponseEntity.status(HttpStatus.OK).body(taskService.update(task, id));
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }

    @DeleteMapping("{id}")
    public ResponseEntity<String> deleteById(@PathVariable String id){
        try{
            taskService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).body("OK");
        }
        catch (Exception e){
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null);
        }
    }
}
