package edu.curtin.app;

public class SimpleTask extends Task 
{
    private int effort;

    public SimpleTask(String id, String description, int effort) 
    {
        super(id, description);
        this.effort = effort;
    }

    @Override
    public int getEffort() 
    {
        return effort;
    }
}
