 public class SerratedDisc {
private int size;
private int numberOfPins;

private static String COMPNAME;// dh kda et5zn mra wa7da f el memory  

public void setSize(int size){
	this.size=size;
}
public void setNumberOfPins(int numberOfPins){
	this.numberOfPins=numberOfPins;
}
public int getSize(){
	return size;
}
public int getNumberOfPins(){
	return numberOfPins;
}
public static void setCOMPNAME (String name){
	COMPNAME=name;
}
public static String getCOMPNAME(){
	return COMPNAME;
}


public SerratedDisc(int size,int numberOfPins){
	this.size=size;
	this.numberOfPins=numberOfPins;
}

public void spin(){
System.out.println("The Disc is spinning now "+"size obj="+size+"and numberOfPins obj="+numberOfPins);
}
}