package edu.curtin.app;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Logger;

public class EstimateManager 
{
    private static final Logger Log = Logger.getLogger(EstimateManager.class.getName());

    public void estimate(WBS wbs, Configuration configuration, Scanner scanner)
    {
        System.out.print("Task ID: ");
        String id = scanner.nextLine();

        Task task = wbs.getTask(id);

        if(task == null)
        {
            System.out.println("Task was not found");
            return;
        }

        estimateTask(task, configuration, scanner);

    }

    private void estimateTask(Task task, Configuration configuration, Scanner scanner)
    {
        if(task instanceof GroupTask)
        {
            GroupTask group = (GroupTask) task;

            for(Task child : group.getChildren())
            {
                estimateTask(child, configuration, scanner);
            }
        }
        else
        {
            LeafTask leaf = (LeafTask) task;

            System.out.println();
            System.out.println("Estimating: " + leaf.getDescription());

            List<Integer> estimates = new ArrayList<>();

            for(int i = 1; i <= configuration.getEstimators(); i++)
            {
                System.out.print("Estimate " + i + ": ");
                estimates.add(Integer.parseInt(scanner.nextLine()));
            }

            System.out.println();
            System.out.println("Entered estimates");

            for(Integer estimate : estimates)
            {
                System.out.println(estimate);
            }

            System.out.print("\n");

            int answer;

            if(configuration.getStrategy() instanceof DiscussStrategy)
            {
                boolean same = true;

                for(int i = 1; i<estimates.size(); i++)
                {
                    if(!estimates.get(i).equals(estimates.get(0)))
                    {
                        same = false;
                        break;
                    }
                }

                if(same)
                {
                    answer = estimates.get(0);
                }
                else
                {
                    System.out.print("Discussion is completed, enter the revised estimate: ");
                    answer = Integer.parseInt(scanner.nextLine());
                }
            }
            else
            {
                answer = configuration.getStrategy().getEstimate(estimates);
            }

            leaf.setEstimate(answer);
            Log.info(() -> "Task " + leaf.getId() + " esitmated as " + answer);
            System.out.println("Final estimate = " + answer);
        }
    }
}
