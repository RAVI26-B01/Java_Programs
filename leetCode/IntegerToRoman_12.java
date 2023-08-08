package leetcode;

public class IntegerToRoman_12 {

	public static void main(String[] args) {
		int n=3999;
		integerToRoman(n);
	}

	private static void integerToRoman(int n) {
		StringBuffer bf = new StringBuffer();
		int mul=1;
		while(n>0) {
//			int rem = n%10;
//			rem=rem*mul;
//			mul=mul*10;
//			n=n/10;
//			String roman = getRoman(rem);
//			bf.insert(0,roman);
			
//			int quot =n/mul;
//			quot=quot*mul;
//			n=n%mul;
//			mul=mul/10;
//			
//			String roman = getRoman(quot);
//			bf.append(roman);
			
			
			
		}
		
		System.out.println(bf);
	}
	
	public static String getRoman(int n){
		String ans="";
		switch (n) {
		case 1: ans= "I";break;
		case 5: ans= "V";break;
		case 10: ans= "X";break;
		case 50: ans= "L";break;
		case 100: ans= "C";break;
		case 500: ans= "D";break;
		case 1000: ans= "M";break;
		case 40: ans= "XL";break;
		case 90: ans= "XC";break;
		case 900: ans= "CM";break;
		case 400: ans= "CD";break;
		case 4: ans= "IV";break;
		default:
			break;
		}
		return ans;
    }
	
	public static String getRoman2(int n, int quot, int factor){
		String ans="";
		switch (factor) {
		case 1: ans= "I";break;
		case 5: ans= "V";break;
		case 10: ans= "X";break;
		case 50: ans= "L";break;
		case 100: ans= "C";break;
		case 500: ans= "D";break;
		case 1000: ans= "M";break;
		case 40: ans= "XL";break;
		case 90: ans= "XC";break;                                       // 3999 // 3000 // 3 //1000
		case 900: ans= "CM";break;
		case 400: ans= "CD";break;
		case 4: ans= "IV";break;
		default:
			break;
		}
		
		for(int i = 0; i<quot-1; i++) {
			ans += ans;
		}
		
		return ans;
    }

}
