package edu.curtin.app;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class WBS 
{
    private Map<String, Task> tasks;
    private List<Task> roots;

    public WBS()
    {
        tasks = new HashMap<>();
        roots = new ArrayList<>();
    }
    
    public void addTask(Task task)
    {
        tasks.put(task.getId(), task);
    }

    public Task getTask(String id)
    {
        return tasks.get(id);
    }

    public void addRoot(Task task)
    {
        roots.add(task);
    }

    public List<Task> getRoots()
    {
        return roots;
    }

    public boolean hasTask(String id)
    {
        return tasks.containsKey(id);
    }

    public Map<String, Task> getTasks()
    {
        return tasks;
    }

    public void display()
    {
        System.out.println("Work Breakdown Structure");
    }

    public void clear()
    {
        tasks.clear();
        roots.clear();
    }

    public int size()
    {
        return tasks.size();
    }
}


