package practice;

import java.util.ArrayList;
import java.util.Arrays;

import com.sun.xml.internal.bind.v2.model.util.ArrayInfoUtil;
import com.sun.xml.internal.bind.v2.runtime.unmarshaller.XsiNilLoader.Array;

import jdk.nashorn.internal.ir.LiteralNode.ArrayLiteralNode;

 public class Demo3 {

	public static void main(String[] args) {
		c b = new b();
		b.my();
	}

}
 
 interface a{
	 default void my() {
		 System.out.println("aaa");
	 }
 }
 
 interface c{
	 default void my() {
		 System.out.println("bbb");
	 }
 }
 
 class b implements a,c{
	 public void my() {
//		 System.out.println("ccc");
		 a.super.my();
	 }
 }

