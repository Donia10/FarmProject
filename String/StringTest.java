class StringTest {
	public static void main(String[]args){
		String str1= new String("Hi");
		String str2="hi";
		
		//compare two reference not value ...str1 reference to object different str2
		System.out.println("if (str1==str2)");
		System.out.println(str1==str2);
		// compare between two values b el caps char
		System.out.println(str1.equals(str2));
		//compare between two values ignore el caps char
	    System.out.println(str1.equalsIgnoreCase(str2));
		
		String s1=new String ("welcome ");
		String s2="welcome";
		String str=s1+s2;
		str +="java" ; // str =str+"java"  w dh m3nah en et create obj gded w byshawr 3leh str w el obj el 2deem (s1+s2) gahz ll garbage collector
		System.out.println(str);
		
		str=str.concat("world"); // dh nfs eli ablo et create obj gded w by4wr 3leh str w  el object el adeem eli kan feh(welcome welcome java)gahz ll garbage collector
	    System.out.println(str);
		
		String ss1="welcome";
		String ss2="welcome";
		System.out.println(ss1==ss2);


	}
}