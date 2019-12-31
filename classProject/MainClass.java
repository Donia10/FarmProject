public class MainClass{
  public static void main (String[] args){
    
       SerratedDisc myCarDisc =new SerratedDisc(5,3);
        myCarDisc.spin();
		
		SerratedDisc.setCOMPNAME("Hello static memebers");
		String result=SerratedDisc.getCOMPNAME();
		
		System.out.println(result);
		
		myCarDisc.setSize(2);
		myCarDisc.setNumberOfPins(2);
		System.out.println(myCarDisc.getSize()+"-----"+myCarDisc.getNumberOfPins());
		
  }
}