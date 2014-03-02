import java.io.*;
import java.util.*;
import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;

class Main
{
	
	public static void main(String args[])throws Exception
	{
		try
		{
			Translate.setClientId("Your client ID here");
			Translate.setClientSecret("Your client secret here");
			Language.setClientId("MOTECH_GSoC2014");
			Language.setClientSecret("LMzqN/ytBZ1LFyHJYIKWujglpiWwgQ7uOjZTOFx+nHk=");
			
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String src = br.readLine();				//Name of the source file
			String dest = br.readLine();			//Name of the destination file
			String sLang = br.readLine();			//Name of the source language
			String dLang = br.readLine();			//Name of the destination language
			
			Main M = new Main();
			M.convert(src, dest, M.determine(sLang.toUpperCase()), M.determine(dLang.toUpperCase()));
			
			
		}
		catch(Exception e)
		{
			System.out.println("Exception");
		}
	}
	
	public void convert(String sourcepath, String destpath, Language sourceLang, Language destLang)throws Exception
	{
		
		Parser P = new Parser();
		FileMaker FM = new FileMaker();
		P.getDataFromFile(sourcepath);
		ArrayList<String> before, after, modified;
		
		before = P.getBeforeList();
		after = P.getAfterList();
		
		String[] afterTran = new String[after.size()];
		afterTran = after.toArray(afterTran);
		
				
		modified = new ArrayList<String>();
		String sb = null;
		//System.out.println("Size:"+before.size());
		for(int i=0; i<before.size(); i++)
		{
			sb = "";
			String s = before.get(i);
			String t = Translate.execute(after.get(i), sourceLang, destLang);
			sb = s+"="+t;
						
			if(!(sb.trim()).equals("="))
			modified.add(sb);
			else
			modified.add(s);
			//System.out.println(modified.get(i));
			
		}
		
		FM.writeToFile(destpath, modified);
	}
	
	//Determine the respective languages in terms of enums
	public Language determine(String lang)
	{
		Language tmp;
		if(lang.equals("ARABIC"))tmp = Language.ARABIC;
		else if (lang.equals("BULGARIAN"))tmp = Language.BULGARIAN;
		else if (lang.equals("CATALAN"))tmp = Language.CATALAN;
		else if (lang.equals("CHINESE_SIMPLIFIED"))tmp = Language.CHINESE_SIMPLIFIED;
		else if (lang.equals("CHINESE_TRADITIONAL"))tmp = Language.CHINESE_TRADITIONAL;
		else if (lang.equals("CZECH"))tmp = Language.CZECH;
		else if (lang.equals("DANISH"))tmp = Language.DANISH;
		else if (lang.equals("DUTCH"))tmp = Language.DUTCH;
		else if (lang.equals("ENGLISH"))tmp = Language.ENGLISH;
		else if (lang.equals("ESTONIAN"))tmp = Language.ESTONIAN;
		else if (lang.equals("FINNISH"))tmp = Language.FINNISH;
		else if (lang.equals("FRENCH"))tmp = Language.FRENCH;
		else if (lang.equals("GERMAN"))tmp = Language.GERMAN;
		else if (lang.equals("GREEK"))tmp = Language.GREEK;
		else if (lang.equals("HAITIAN_CREOLE"))tmp = Language.HAITIAN_CREOLE;
		else if (lang.equals("HEBREW"))tmp = Language.HEBREW;
		else if (lang.equals("HINDI"))tmp = Language.HINDI;
		else if (lang.equals("HMONG_DAW"))tmp = Language.HMONG_DAW;
		else if (lang.equals("HUNGARIAN"))tmp = Language.HUNGARIAN;
		else if (lang.equals("INDONESIAN"))tmp = Language.INDONESIAN;
		else if (lang.equals("ITALIAN"))tmp = Language.ITALIAN;
		else if (lang.equals("JAPANESE"))tmp = Language.JAPANESE;
		else if (lang.equals("KOREAN"))tmp = Language.KOREAN;
		else if (lang.equals("LATVIAN"))tmp = Language.LATVIAN;
		else if (lang.equals("LITHUANIAN"))tmp = Language.LITHUANIAN;
		else if (lang.equals("MALAY"))tmp = Language.MALAY;
		else if (lang.equals("NORWEGIAN"))tmp = Language.NORWEGIAN;
		else if (lang.equals("PERSIAN"))tmp = Language.PERSIAN;
		else if (lang.equals("POLISH"))tmp = Language.POLISH;
		else if (lang.equals("PORTUGUESE"))tmp = Language.PORTUGUESE;
		else if (lang.equals("ROMANIAN"))tmp = Language.ROMANIAN;
		else if (lang.equals("RUSSIAN"))tmp = Language.RUSSIAN;
		else if (lang.equals("SLOVAK"))tmp = Language.SLOVAK;
		else if (lang.equals("SLOVENIAN"))tmp = Language.SLOVENIAN;
		else if (lang.equals("SPANISH"))tmp = Language.SPANISH;
		else if (lang.equals("SWEDISH"))tmp = Language.SWEDISH;
		else if (lang.equals("THAI"))tmp = Language.THAI;
		else if (lang.equals("TURKISH"))tmp = Language.TURKISH;
		else if (lang.equals("UKRAINIAN"))tmp = Language.UKRAINIAN;
		else if (lang.equals("URDU"))tmp = Language.URDU;
		else if (lang.equals("VIETNAMESE"))tmp = Language.VIETNAMESE;
		else tmp = Language.ENGLISH;
		
		return tmp;
	}
}
				
			
			
		