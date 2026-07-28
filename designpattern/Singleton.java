package designpattern;

//This version is not thread-safe
class Single {
	
	private static Single reference;
	
	private Single() {}
	
	public static Single createSingletonObj() {
		
		if(reference == null) {
			reference = new Single();
		}
		return reference;
	}

}

public class Singleton {

    public static void main(String[] args) {

    	Single s1 = Single.createSingletonObj();
        Single s2 = Single.createSingletonObj();

        System.out.println(s1 == s2);
    }
}
