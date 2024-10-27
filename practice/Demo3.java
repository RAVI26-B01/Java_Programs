package practice;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

class userDO{
	String name;
	String dept;
	public userDO(String name, String dept) {
		super();
		this.name = name;
		this.dept = dept;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	
	
	
}
public class Demo3 {
	public static void main(String[] args) {
		
		List<userDO> userList = new ArrayList<>();
		userList.add(new userDO("ravi","marketing"));
		userList.add(new userDO("ravi","devops"));
		userList.add(new userDO("kumar","test"));
		Map<String, List<userDO>> collect = userList.stream().collect(Collectors.groupingBy(userDO::getName));
		System.out.println(collect);
		
		int[] ar = {1, 2, 3 ,4, 3, 1};
		Map<Integer, Long> collect2 = Arrays.stream(ar).mapToObj(x->x).collect(Collectors.groupingBy(x->x,Collectors.counting()));
		System.out.println(collect2);
	}

}
