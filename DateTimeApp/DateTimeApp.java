public class DateTimeApp extends Applet implements Runnable{
	Thread th;
	public void init(){
		the =new Thread(this);
		th.start();
	}
	public void paint(Gra g){
		Date d=new Date();
		g.drawString(d.toString(),50,100);
	
	}
	public void run(){
		while(true) {
			repaint();
			try{
				Thread.sleep(1000);
			}
			catch(Exception ex){
				
			}
		}
	}
}