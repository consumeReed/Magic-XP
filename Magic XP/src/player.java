import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class player {
	
	static List<String> list = new LinkedList();
	static String magicLvl;
	static String magicXp;
	static final String url = "https://secure.runescape.com/m=hiscore_oldschool/index_lite.ws?player=";
	
	public player(String name)
	{
		try {
			DownloadPage(url+name.replaceAll(" ", "%20"));
		} catch (Exception e) {
			System.err.println("Invalid name");
		}
		try {
			String tmp = list.get(7);
			String[] tmpArr = tmp.split(",");
			magicLvl = tmpArr[1];
			magicXp = tmpArr[2];
		}
		catch(Exception e)
		{
			System.err.println("Invalid name");
		}
	}
	
	/**
	 * 0 Overall
	 * 1 Attack
	 * 2 Defence
	 * 3 Strength
	 * 4 Hitpoints
	 * 5 Ranged
	 * 6 Prayer
	 * 7 Magic
	 * 8 Cooking
	 * 9 Woodcutting
	 * 10 Fletching
	 * 11 Fishing
	 * 12 Firemaking
	 * 13 Crafting
	 * 14 Smithing
	 * 15 Mining
	 * 16 Herblore
	 * 17 Agility
	 * 18 Thieving
	 * 19 Slayer
	 * 20 Farming
	 * 21 Runecrafting
	 * 22 Hunter
	 * 23 Construction
	 * 
	 */
	public static void DownloadPage(String webURL) throws IOException {
    	
        URL url = new URL(webURL);
        InputStream is =  url.openStream();
        try( BufferedReader br = new BufferedReader(new InputStreamReader(is))) {
            String line;
            
            while ((line = br.readLine()) != null) {
            	list.add(line);
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }

	}
	
	public static void main(String[] args)
	{
		Scanner sc = new Scanner(System.in);
        System.out.println("Enter your name: ");
        String name = sc.nextLine();
        
        player p = new player(name);
        System.out.println(p.list.get(7));
        System.out.println(p.magicLvl);
        System.out.println(p.magicXp);
	}

}
