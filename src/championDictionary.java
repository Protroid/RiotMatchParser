package matchHistoryParser;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.*;
import com.robrua.orianna.type.dto.staticdata.Champion;

public class championDictionary 
{
	Map<Long, String> championDictionary = new HashMap<>();
	
	
	public championDictionary(List<com.robrua.orianna.type.core.staticdata.Champion> allChamps)
	{
		for(int i = 0; i < allChamps.size()-1; i++)
		{
			championDictionary.put(allChamps.get(i).getID(), allChamps.get(i).getName());
		}
	}
	
	public championDictionary()
	{
		Scanner currentLine = null;
		String currentString;
		try 
		{
			currentLine = new Scanner(new FileInputStream("<Enter the filepath>"));
		} 
		catch (FileNotFoundException e) {}
				
		while (currentLine.hasNextLine())
		{
			String[] values = null;

			currentString = currentLine.nextLine();
			for(int i = 0; i<currentString.length(); i++)
			{
				values = currentString.split(",");
			}
			//System.out.println(":"+values[0]+":");
			championDictionary.put(Long.parseLong(values[0]), values[1]);
		}
	}
	
	public Map<Long, String> getDictionary()
	{
		return championDictionary;
	}
	
	public void writeToDictionary()
	{
		File file = new File("<Enter the filepath>");
		try
		{
		    PrintWriter writer = new PrintWriter(file, "UTF-8");
		    for (Map.Entry<Long, String> entry : championDictionary.entrySet())
		    {
		        writer.println(entry.getKey()+","+entry.getValue());
		    }

			writer.close();
		} 
		catch (Exception e) {} 
	}
}
