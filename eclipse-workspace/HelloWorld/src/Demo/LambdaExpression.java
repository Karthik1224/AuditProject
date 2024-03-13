package Demo;

@FunctionalInterface
interface myInterface
{
	public void fun();
}

@FunctionalInterface
interface MyInterface
{
	public int add(int a,int b);
}


//ways to implement interface methods

class MyClass implements myInterface{

	@Override
	public void fun() {
		
		System.out.println("hello world");
		
	}
	
}


public class LambdaExpression {

	public static void main(String[] args) {
		
//		MyClass myclass = new MyClass();
//		myclass.fun();
//		
//		myInterface obj = ()->System.out.println("hello world");
//		obj.fun();
		
		MyInterface i = (a,b)-> a+b;

		System.out.println(i.add(3, 5));

	}

}
