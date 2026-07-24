package leetcode;

import java.util.ArrayList;
import java.util.List;

/*
 *  n==2
 									(0, 0, '')
								 	    |	
									(1, 0, '(')  
								   /           \
							(2, 0, '((')      (1, 1, '()')
							   /                   /
						(2, 1, '(()')           (2, 1, '()(')
						  \                          \
					(2, 2, '(())')                (2, 2, '()()')
						      |	                             |
					res.append('(())')             res.append('()()')
 */
public class Generate_paranthsis_22 {

	public static void main(String[] args) {
		System.out.println(generateParenthesis(3));
		System.out.println(generateParenthesis(2));
	}
	
	public static List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        recurse(res, 0, 0, "", n);
        return res;
    }
    
    public static void recurse(List<String> res, int left, int right, String s, int n) {
        if (s.length() == n * 2) {
            res.add(s);
            return;
        }
        
        if (left < n) {
            recurse(res, left + 1, right, s + "(", n);
        }
        
        // right ) bracket will append if and only if left ( is present i.e. left > right
        if (right < left) {
            recurse(res, left, right + 1, s + ")", n);
        }
    }
	// See above tree diagram with parameters (left, right, s) for better understanding
}
