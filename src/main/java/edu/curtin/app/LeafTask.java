package edu.curtin.app;

public class LeafTask extends Task 
{
    private Integer effort;

    public LeafTask(String id, String description, Integer effort) 
    {
        super(id, description);
        this.effort = effort;
    }

    public Integer getEstimate()
    {
        return effort;
    }

    public void setEstimate(Integer effort)
    {
        this.effort = effort;
    }

    @Override
    public int getEffort() 
    {
        if(effort ==null)
        {
            return 0;
        }
        return effort;
    }
}
