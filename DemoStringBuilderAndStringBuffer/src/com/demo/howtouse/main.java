package com.demo.howtouse;

public class main {

	public static void main(String[] args) {
		
		/* Using the StringBuilder */
//		StringBuilder data = new StringBuilder("start");
//		ThreadForString r = new ThreadForString(data,"--thread 1--");
//		new Thread(r).start();
//		ThreadForString r2 = new ThreadForString(data,"--thread 2--");
//		new Thread(r2).start();
//		System.out.println(data.toString());
		
		
		/* Using the StringBuilder */
		StringBuffer data = new StringBuffer("start");
		ThreadUsingBuffer r = new ThreadUsingBuffer(data,"--thread 1--");
		new Thread(r).start();
		ThreadUsingBuffer r2 = new ThreadUsingBuffer(data,"--thread 2--");
		new Thread(r2).start();
		
		
		PrintString string = new PrintString(data.toString());
		Thread T1 =  new Thread(string);
		T1.start();
		 try {             
		       T1.join(); 
		    } catch (InterruptedException e) {
		       e.printStackTrace();
		    }
	}

}
