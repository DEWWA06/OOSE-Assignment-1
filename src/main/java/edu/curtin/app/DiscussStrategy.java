package edu.curtin.app;

import java.util.List;
import java.util.Scanner;

public class DiscussStrategy implements EstimateStrategy
{
    private Scanner scanner;

    public DiscussStrategy(Scanner scanner)
    {
        this.scanner = scanner;
    }
    
    @Override 
    public int getEstimate(List<Integer> estimates)
    {
        System.out.print("Enter estimate: ");

        return Integer.parseInt(scanner.nextLine());
    }
}
