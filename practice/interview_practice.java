package practice;

import java.util.ArrayList;

public class interview_practice {
	public static void main(String[] args) {
		  new interview_practice().m1(new ArrayList<Object>());
		 }

		 void m1(ArrayList< ? super C> l){
		  l.add(new C(){

		  });
		  System.out.println(l);
		 }
		}

		interface C{
		
		}

		class B{

		}
		class A extends B implements C{

		}
		


