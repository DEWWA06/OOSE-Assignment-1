package edu.curtin.app;

import java.io.IOException;
import java.util.logging.LogManager;
import java.io.FileInputStream;

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

        try
        {
            LogManager.getLogManager().readConfiguration(new FileInputStream("Logging.properties"));
        }
        catch(IOException e)
        {
            System.out.println("Couldnt load logging configuration");
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
        catch(InvalidWBSFileException e)
        {
            System.out.println("There is an error when loading the file");
        }
    }
}
