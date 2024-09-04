package practice;


class b {
	int m1() {
		int a =10;
		try {
			return ++a;
		} catch (ArithmeticException e) {
			return ++a;
		}
		
	}
}
public class Demo3
{ 
   public static void main(String[] args) 
   {
	   b b = new b();
	   int m1 = b.m1();
	   System.out.println(m1);
   }  
} 
