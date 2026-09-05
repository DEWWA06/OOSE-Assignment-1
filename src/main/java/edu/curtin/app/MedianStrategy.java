package edu.curtin.app;

import java.util.List;

public class MedianStrategy implements EstimateStrategy
{
    @Override 
    public int getEstimate(List<Integer> estimates)
    {
        return estimates.get(0);
    }
}
