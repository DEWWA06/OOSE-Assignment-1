package edu.curtin.app;

import java.util.ArrayList;
import java.util.List;

public class GroupTask extends Task
{
    private List<Task> children;

    public GroupTask(String id, String description)
    {
        super(id, description);
        children = new ArrayList<>();
    }

    public void addTask(Task task)
    {
        children.add(task);
    }

    public List<Task> getChildren()
    {
        return children;
    }

    @Override 
    public int getEffort()
    {
        int total = 0;

        for(Task task : children)
        {
            total+= task.getEffort();
        }

        return total;
    }
}
