package edu.curtin.app;

public class LeafTask extends Task 
{
    private int effort;

    public LeafTask(String id, String description, int effort) 
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
