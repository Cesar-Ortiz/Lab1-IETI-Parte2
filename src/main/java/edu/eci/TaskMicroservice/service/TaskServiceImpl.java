package edu.eci.TaskMicroservice.service;

import edu.eci.TaskMicroservice.data.Task;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Service
public class TaskServiceImpl implements TaskService{

    private HashMap<String, Task> tasksMap = new HashMap<>();

    @Override
    public Task create(Task task) {
        tasksMap.put(task.getId(),task);
        return task;
    }

    @Override
    public Task findById(String id) {
        if(tasksMap.containsKey(id)){
            return tasksMap.get(id);
        }
        return null;
    }

    @Override
    public List<Task> all() {
        List<Task> tasks = new ArrayList<Task>();
        for(Task t : tasksMap.values()){
            tasks.add(t);
        }
        return tasks;
    }

    @Override
    public void deleteById(String id) {
        if(tasksMap.containsKey(id)){
            tasksMap.remove(id);
        }
    }

    @Override
    public Task update(Task task, String id) {
        tasksMap.put(id, task);
        return task;
    }
}
