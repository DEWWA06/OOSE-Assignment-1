package edu.curtin.app;

import java.util.List;

public class HighestStrategy implements EstimateStrategy
{
    @Override
    public int getEstimate(List<Integer> estimates)
    {
        int highest = estimates.get(0);

        for(int estimate : estimates)
        {
            if(estimate > highest)
            {
                highest = estimate;
            }
        }
        return highest;
    }   
}
