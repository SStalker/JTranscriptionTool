package specialclasses;

import java.util.Vector;

import view.Database;



public class SubTitleDb {

	private Database database = new Database();
	
	private int i = 0;
	private long[] importantValue;
	
	public long[] sortDbValues()
	{
    	try {
  
			Vector<Vector<Object>> vectorbox = database.getDataVector();
			importantValue = new long[vectorbox.size()];
			if(i < vectorbox.size()) 
			{
				int zaehler = 0;
				for(int j=0; j < vectorbox.size();j++) 
				{
					
					
					importantValue[j] = (Long) vectorbox.elementAt(zaehler).elementAt(3);
					System.out.println("Wert im Array: " + importantValue[j]);
					
					
					System.out.println("ZŠhler: " + zaehler);
					System.out.println("J: " + j);
					if(j > 0) 
					{
						
						if(importantValue[j-1] > importantValue[j]) 
						{
							long cache = 0;
							cache = importantValue[j];
							importantValue[j] = importantValue[j-1];
							importantValue[j-1] = cache;
							for(int i = 0;i < vectorbox.size();i++) 
							{
								System.out.println("Wert" + i + ": " +importantValue[i]);
							}
							
							
						}
						else 
						{
							for(int i = 0;i < vectorbox.size();i++) 
							{
								System.out.println("Wert" + i + ": " +importantValue[i]);
							}
						}
					}
					zaehler++;
				}
								
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return importantValue;
	}
	
}
