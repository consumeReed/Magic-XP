import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.Scanner;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;

public class calc {
	
	static String curLvl;
	static String desLvl;
	static String name;
	
	static String curXP;
	static String desXP;
	
	static double cXP;
	static double dXP;
	static boolean run;
	
	public static void main(String[] args)
	{
		int lv = 0;
		XPcalc x = new XPcalc();
		Scanner sc = new Scanner(System.in);
		run = true;
		System.out.println("Enter your name");
		name = sc.nextLine();
		player p = new player(name);
		curLvl = p.magicLvl;
		curXP = p.magicXp;
		
		while(run) {
		run = false;
        System.out.println("Enter your desired level");
        desLvl = sc.nextLine();
        desXP = x.getXP(desLvl);
        
        cXP = Double.parseDouble(curXP);
        dXP = Double.parseDouble(desXP);
        
        if(cXP<dXP) {
        System.out.printf("\nCurrent xp: %.0f\n",cXP);
        System.out.printf("\nDesired xp: %.0f\n",dXP);
        
        lv = Integer.parseInt(curLvl);
        
        
        double diff = dXP - cXP;
        
        System.out.printf("\nDifference in xp: %.0f",diff);
        double casts = 0;
        Gson gson = new Gson();
        try {
    		JsonReader read = new JsonReader(new FileReader("bin\\SPELLS.json"));
    		spells data = gson.fromJson(read, spells.class);
    		for(int i = 0; i < data.sps.size(); i++)
    		{
    			if(lv>=data.sps.get(i).req) {
    				casts=diff/data.sps.get(i).xp;
    				System.out.printf("\nIt will take %.0f casts of %s", casts, data.sps.get(i).name);
    			}
    		}
    		
    	} catch (FileNotFoundException e) {
    		e.printStackTrace();
    	}
        
	}
        else
        {
        	System.out.println("You are already at or above this level");
        }
        boolean ans = false;
        while(!ans) {
        System.out.println("\nIf you would to recalculate enter (R) or quit enter (Q)");
        String inp = sc.nextLine();
        if("q".equals(inp.toLowerCase()))
        {
        	return;
        }
        if("r".equals(inp.toLowerCase()))
        {
        	run = true;
        	break;
        }
        else
        {
        	System.out.println("Command incorrect, try again");
		}
        }
	}
	
	
	
	
}
}