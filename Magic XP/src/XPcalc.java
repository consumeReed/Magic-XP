import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.HashMap;
import java.util.Map;

public class XPcalc {

	Map<String, String> xpLvl = new HashMap<String, String>();
	
	public XPcalc()
	{
		BufferedReader br = null;
		try {
			File f = new File("bin\\xps.txt");
			br = new BufferedReader(new FileReader(f));
			String line = null;
			while((line = br.readLine()) != null)
			{
				String[] parts = line.split(" ");
				
				String lvl = parts[0].trim();
				String xp = parts[1].trim();
				xpLvl.put(lvl, xp);
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
	}
	
	public String getXP(String lv)
	{
		return xpLvl.get(lv);
	}
	
}
