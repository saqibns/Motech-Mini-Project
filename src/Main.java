import java.io.*;
import java.util.*;
import com.memetix.mst.language.Language;
import com.memetix.mst.translate.Translate;
import java.net.UnknownHostException;

class Main
{
	
	public static void main(String args[])throws Exception
	{
        String src, dest, sLang, dLang;
		try
		{
			Translate.setClientId("Client ID");
			Translate.setClientSecret("Client Secret");
			Language.setClientId("Client ID");
			Language.setClientSecret("Client Secret");

            if(args.length == 4)
            {
                src = args[0];
                dest = args[1];
                sLang = args[2];
                dLang = args[3];

            }



			else
            {
                if(args.length>0 && args.length<4)
                {
                    System.out.println("Invalid number of arguments");
                }
			    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
                System.out.print("Source file path: ");
			    src = br.readLine();			//Name of the source file
                System.out.print("Destination file path: ");
			    dest = br.readLine();			//Name of the destination file
                System.out.print("Source language: ");
			    sLang = br.readLine();			//Name of the source language
                System.out.print("Target language: ");
			    dLang = br.readLine();			//Name of the destination language
            }



            Main M = new Main();
            Language sL = M.determine(sLang.toUpperCase());
            Language dL = M.determine(dLang.toUpperCase());
            boolean one, two;
            one = sL == null;
            two = dL == null;
            if(one || two)
            {
                if (one)
                    System.out.println("Invalid Source Language");
                if (two)
                    System.out.println("Invalid Target Language");

            }

            else
			    M.convert(src, dest, sL, dL);
			
			
		}
        catch (UnknownHostException e)
        {
            System.out.println("\nIP address of the host could not be determined.");
        }
        catch (FileNotFoundException e)
        {
            System.out.println("\nError in accessing file.");
        }
		catch(Exception e)
		{
			System.out.println("\nAn error occurred while translating.");
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
        float percent = 0F;
        int total = before.size();
        System.out.print("Translating: 0%");
		for(int i=0; i<total; i++)
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
            percent = i*100/total;
            //System.out.println(percent);
            System.out.print("\rTranslating: "+(int)percent+"%\t");
			
		}
        System.out.print("\rDone Translating\t\t");
        System.out.println();
		System.out.println("Writing to file...");
		FM.writeToFile(destpath, modified);
        System.out.println("Done writing.");
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
		else tmp = null;
		
		return tmp;
	}
}
				
			
			
		