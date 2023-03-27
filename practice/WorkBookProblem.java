package practice;

public class WorkBookProblem {

	public static void main(String[] args) {
		int chapter = 5;
		int k = 3;  //problems in one page
		int[] charpterArr = {4,10,10}; // problems in each chapter
		
		int page = 1 ;
		int count=0;
		
		for(int i=0 ; i<charpterArr.length ; i++) {
			int problems = charpterArr[i];
			for(int problem =1 ;problem<=problems ; problem++) {
				if(problem == page)
					count++;
				if((problem % k )==0 || problem==problems) // if end of the problem is equal 
					page++;								   // to number of problems
			}
		}
		System.out.println(count);
	}

}
