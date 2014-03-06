import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.File;
import java.util.ArrayList;
class Parser
{
    private ArrayList<String> before, after;
	
	public Parser()
	{
		//The 'before' list stores names before the equals sign
		before = new ArrayList<String>();
		//The 'after' list stores names after the equals sign
		after = new ArrayList<String>();
		
		
	}
	
	/*Utility method that extracts strings from the lines and separates them into
	 *two lists, one containing strings before the equals sign and one after it
	 */
	public void getDataFromFile(String filename)throws IOException
	{
				
		File f = new File(filename);
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(filename),"UTF8"));
        
        String line = null;
        while((line = br.readLine())!=null)
            {
                
                    String[] ele = line.split("=");
                    if(ele.length == 2)					//That is, if a new line doesn't occur
					{
						//Add the strings obtained into their respective lists
						before.add(ele[0]);
						after.add(ele[1]);
					}
					else
					{
						//Add the data as it is
						before.add(ele[0]);
						after.add(ele[0]);
					}
			}
			
    }
	
	//Accessor method to get the first list
	public ArrayList<String> getBeforeList()
	{
		return before;
	}
	
	public ArrayList<String> getAfterList()
	{
		return after;
	}
}

    