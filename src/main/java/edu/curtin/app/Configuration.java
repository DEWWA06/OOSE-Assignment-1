package edu.curtin.app;

public class Configuration 
{
    private int estimators;
    private EstimateStrategy strategy;

    public Configuration()
    {
        estimators = 3;
        strategy = new HighestStrategy();
    }

    public int getEstimators()
    {
        return estimators;
    }

    public void setEstimators(int estimators)
    {
        this.estimators = estimators;
    }

    public EstimateStrategy getStrategy()
    {
        return strategy;
    }

    public void setStrategy(EstimateStrategy strategy)
    {
        this.strategy = strategy;
    }

    public String getStrategyName()
    {
        if(strategy instanceof HighestStrategy)
        {
            return "Highest";
        }
        else if(strategy instanceof MedianStrategy)
        {
            return "Median";
        }
        else
        {
            return "Discuss";
        }
    }
}
