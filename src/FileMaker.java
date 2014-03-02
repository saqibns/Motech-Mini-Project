import java.io.FileOutputStream;
import java.io.BufferedWriter;
import java.io.OutputStreamWriter;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
class FileMaker
{
	public void writeToFile(String path, ArrayList<String> data)throws IOException
	{
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(path), "UTF8"));
		for(String line : data)
		{
			bw.append(line).append("\r\n");
			bw.flush();
			
		}
		bw.close();
	}
}