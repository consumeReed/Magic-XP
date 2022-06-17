import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

import java.io.*;
import java.util.*;
/**
 * 
 * @author rmitc
 *	Test Class and write Json file for spells
 */
public class writeJson {
	
	public static void main(String[] args) {
		
	Gson gson = new Gson();
	
	ArrayList<spell> sps = new ArrayList<spell>();
	
	sps.add(new spell("Fire Strike", 11.5, new runes(2, 3, "mind"),13));
	sps.add(new spell("Fire Bolt", 22.5, new runes(3, 4, "chaos"),35));
	sps.add(new spell("Fire Blast", 34.5, new runes(4, 5, "death"),59));
	sps.add(new spell("Fire Wave", 42.5, new runes(5, 7, "blood"),75));
	sps.add(new spell("Fire Surge", 50.5, new runes(7, 10, "wrath"),95));
	
	spells s = new spells(sps);
	String json = gson.toJson(s);
	System.out.println(json.toString());

	try {
		JsonReader read = new JsonReader(new FileReader("bin\\SPELLS.json"));
		spells data = gson.fromJson(read, spells.class);
		for(int i = 0; i < data.sps.size(); i++)
		{
			System.out.println(data.sps.get(i).xp);
		}
		
	} catch (FileNotFoundException e) {
		e.printStackTrace();
	}
	}
}
