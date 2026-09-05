package edu.curtin.app;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FileManager 
{
    public WBS load(String fileName) throws IOException
    {
        WBS wbs = new WBS();
        List<TaskData> data = new ArrayList<>();

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

                Integer effort = null;
                if(parts.length == 4 && !parts[3].isEmpty())
                {
                    effort = Integer.parseInt(parts[3]);
                }

                data.add(new TaskData(parts[0], parts[1], parts[2], effort));
            }
        }

        List<String> parentIds = new ArrayList<>();

        for(TaskData task : data)
        {
            if(!task.parentId.isEmpty())
            {
                parentIds.add(task.parentId);
            }
        }
        
        for(TaskData task : data)
        {
            if(parentIds.contains(task.id))
            {
                wbs.addTask(new GroupTask(task.id, task.description));
            }
            else
            {
                wbs.addTask(new LeafTask(task.id, task.description, task.effort));
            }
        }

        for(TaskData task : data)
        {
            Task current = wbs.getTask(task.id);

            if(task.parentId.isEmpty())
            {
                wbs.addRoot(current);
            }
            else
            {
                Task parent = wbs.getTask(task.parentId);

                if(parent instanceof GroupTask)
                {
                    ((GroupTask) parent).addTask(current);
                }
            }
        }
        return wbs;
    }  
    
    private static class TaskData
    {
        private String parentId;
        private String id;
        private String description;
        private Integer effort;

        public TaskData(String parentId, String id, String description, Integer effort)
        {
            this.parentId = parentId;
            this.id = id;
            this.description = description;
            this.effort = effort;
        }
    }

    public void save(String fileName, WBS wbs) throws IOException
    {
        try(BufferedWriter writer = new BufferedWriter(new FileWriter(fileName)))
        {
            for(Task task : wbs.getRoots())
            {
                saveTask(writer, "", task);
            }
        }
    }

    private void saveTask(BufferedWriter writer, String parentId, Task task) throws IOException
    {
        writer.write(parentId);
        writer.write(";");
        writer.write(task.getId());
        writer.write(";");
        writer.write(task.getDescription());

        if(task instanceof LeafTask)
        {
            LeafTask leaf = (LeafTask) task;
            writer.write(";");

            if(leaf.getEstimate() != null)
            {
                writer.write(Integer.toString(leaf.getEstimate()));
            }
        }

        writer.newLine();

        if(task instanceof GroupTask)
        {
            GroupTask group = (GroupTask) task;

            for(Task child : group.getChildren())
            {
                saveTask(writer, task.getId(), child);
            }
        }

    }
}
