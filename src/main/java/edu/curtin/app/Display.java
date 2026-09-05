package edu.curtin.app;

public class Display 
{
    public void show(WBS wbs, Configuration configuration)
    {
        for(Task task : wbs.getRoots())
        {
            print(task, 0);
        }

        System.out.println();
        System.out.println("Total known effort = " + wbs.getTotalEffort());
        System.out.println("UnkNown tasks = " + wbs.getUnknownTasks());

        System.out.println();
        System.out.println("Estimators = " + configuration.getEstimators());
        System.out.println("Strategy = " + configuration.getStrategyName());
    }

    private void print(Task task,int level)
    {
        for(int i=0; i<level; i++)
        {
            System.out.print("    ");
        }

        System.out.print(task.getDescription());

        if(task instanceof LeafTask)
        {
            LeafTask leaf = (LeafTask) task;

            if(leaf.getEstimate() != null)
            {
                System.out.print(", effort = " +leaf.getEstimate());
            }
        }

        System.out.println();

        if(task instanceof GroupTask)
        {
            GroupTask group = (GroupTask) task;

            for(Task child : group.getChildren())
            {
                print(child, level + 1);
            }
        }

    }
}
