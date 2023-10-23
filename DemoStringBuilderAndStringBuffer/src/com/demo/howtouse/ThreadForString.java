package com.demo.howtouse;

public class ThreadForString implements Runnable{
	private StringBuilder java ;
	private String threadName;
	public ThreadForString(StringBuilder data , String threadName){
		java = data;
		this.threadName=threadName;
	}
	@Override
	public void run() {
		for(int  a = 0 ; a < 10 ; a++) {
			java.append(threadName);
		}
		System.out.println(java.toString());
	}

}
