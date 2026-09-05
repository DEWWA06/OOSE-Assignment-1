package edu.curtin.app;

import java.util.List;
import java.util.Collections;

public class MedianStrategy implements EstimateStrategy
{
    @Override 
    public int getEstimate(List<Integer> estimates)
    {
        Collections.sort(estimates);
        return estimates.get(estimates.size() / 2);
    }
}
