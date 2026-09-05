package edu.curtin.app;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class FileManager 
{
    public void load(String fileName) throws IOException
    {
        try(BufferedReader reader = new BufferedReader(new FileReader(fileName)))
        {
            String line;

            while((line = reader.readLine()) != null)
            {
                String[] parts = line.split(";");

                for(int i = 0; i<parts.length; i++)
                {
                    parts[i] = parts[i].trim();
                }
            }
        }
    }
    
}
