package edu.curtin.app;

import java.util.Scanner;

public class Menu 
{
    private Scanner scanner;

    public Menu()
    {
        scanner = new Scanner(System.in);
    }

    public void start(WBS wbs)
    {
        Display display = new Display();
        boolean running = true;

        while(running)
        {
            display.show(wbs);

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
                    System.out.println("Not done yet");
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
    
}
