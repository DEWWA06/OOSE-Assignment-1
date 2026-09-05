package edu.curtin.app;

import java.io.IOException;

/**
 * Entry point into the application. To change the package, and/or the name of this class, make
 * sure to update the 'mainClass = ...' line in build.gradle.kts.
 */
public class App
{
    public static void main(String[] args)
    {
        if(args.length != 1)
        {
            System.out.println("Use : ./gradlew run --args=\"filename\"");
            return;
        }

        FileManager fileManager = new FileManager();

        try
        {
            WBS wbs = fileManager.load(args[0]);
            Menu menu = new Menu(args[0]);
            menu.start(wbs);
        }
        catch(IOException e)
        {
            System.out.println("There was an error loading the file");
        }
    }
}
