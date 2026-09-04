package edu.curtin.app;

public abstract class Task 
{
    private String id;
    private String description;

    public Task(String id, String description) 
    {
        this.id = id;
        this.description = description;
    }

    public String getId()
    {
        return id;
    }

    public String getDescription()
    {
        return description;
    }

    public abstract int getEffort();
}
