package Demo;
class customException extends Exception
{
	public customException(String msg)
	{
		super(msg);
	}
}
public class demo {
	
	public static void fun(int age) throws customException
	{
		if(age < 18) throw new customException("You are not eligible to vote");
	}
	
	public static void main(String[]args)
	{
		int age = 16;
		try
		{
			demo.fun(age);
			System.out.print("you are eligible");
		}
		catch(Exception e)
		{
			System.out.print(e.getMessage());
		}
	}

}
