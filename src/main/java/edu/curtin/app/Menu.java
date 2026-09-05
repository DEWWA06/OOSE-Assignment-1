package edu.curtin.app;

import java.util.Scanner;

public class Menu 
{
    private Scanner scanner;
    private Configuration configuration;

    public Menu()
    {
        scanner = new Scanner(System.in);
        configuration = new Configuration();
    }

    public void start(WBS wbs)
    {
        Display display = new Display();
        boolean running = true;

        while(running)
        {
            display.show(wbs, configuration);

            System.out.println();
            System.out.println("1. Estimate effort");
            System.out.println("2. Configure");
            System.out.println("3. Quit");
            System.out.println("Choice: ");

            String choice = scanner.nextLine();

            switch(choice)
            {
                case "1":
                    System.out.println("Not done yet");
                    break;

                case "2":
                    configure();
                    break;

                case "3":
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice");
                    break;
            }

            System.out.println();
        }
    } 

    private void configure()
    {
        System.out.print("Number of estimators: ");
        configuration.setEstimators(Integer.parseInt(scanner.nextLine()));

        System.out.println("1. Highest");
        System.out.println("2. Median");
        System.out.println("3. Discuss");
        System.out.println("Choice: ");

        String choice = scanner.nextLine();

        switch(choice)
        {
            case "1":
                configuration.setStrategy(new HighestStrategy());
                break;

            case "2":
                configuration.setStrategy(new MedianStrategy());
                break;

            case "3":
                configuration.setStrategy(new DiscussStrategy());
                break;

            default:
                System.out.println("Invalid choice");
                break;
        }
        System.out.println("Configuration is updated");
    }

    public Configuration getConfiguration()
    {
        return configuration;
    }
}
