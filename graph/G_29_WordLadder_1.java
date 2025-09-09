package graph;

import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class G_29_WordLadder_1 {

	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "cog";
		List<String> wordList = Arrays.asList("hot","dot","dog","lot","log","cog");
		int ladderLength = ladderLength(beginWord, endWord, wordList);
		System.out.println(ladderLength);
	}
	
	
	 public static int ladderLength(String beginWord, String endWord, List<String> wordList) {
		Queue<pair29> queue = new LinkedList<>();
		queue.add(new pair29(beginWord, 1));
		
		Set<String> set = new HashSet<>();
		int len = wordList.size();
		for(int i = 0 ; i<len ; i++) {
			set.add(wordList.get(i));
		}
		
		while(!queue.isEmpty()) {
			pair29 pair = queue.peek();
			String word = pair.word;
			int level = pair.level;
			queue.poll();
			
			if(word.equals(endWord))
				return level;
			
			for(int i = 0 ; i<word.length() ; i++) {
				for(char ch = 'a'; ch<'z';ch++) {
					char[] charArray = word.toCharArray();
					charArray[i] = ch;
					String replacedWord = new String(charArray);
					if(set.contains(replacedWord)) {
						set.remove(replacedWord);
						queue.add(new pair29(replacedWord, level+1));
					}
				}
			}
			
		}
		return 0;
	  }
}

class pair29{
	String word;
	int level;
	pair29(String _word, int _level){
		this.word = _word;
		this.level = _level;
	}
 }


