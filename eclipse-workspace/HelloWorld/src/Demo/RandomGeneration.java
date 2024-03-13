package Demo;

import java.util.Random;

public class RandomGeneration {

	
	public static void main(String[] args)
	{
		Random random = new Random();
		long l=(long)(Math.random() * 900000000000L) + 100000000000L;
		String res = Long.toString(l);
		 System.out.println(res);
		 
		 String utrNo = "AXB3114173008512";
			String regex = "((?<=[0-9])(?=[a-zA-Z]))";
			String[] utrAlphanumeric = utrNo.split(regex);
			for(String s : utrAlphanumeric)
			{
			    System.out.println(s);
			}
			
			
			
	}
}
