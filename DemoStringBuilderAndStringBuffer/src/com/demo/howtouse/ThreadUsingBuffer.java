package com.demo.howtouse;

public class ThreadUsingBuffer implements Runnable {
	private StringBuffer java ;
	private String threadName;
	public ThreadUsingBuffer(StringBuffer data , String threadName){
		java = data;
		this.threadName=threadName;
	}
	@Override
	public void run() {
		for(int  a = 0 ; a < 5 ; a++) {
			java.append(threadName);
			
		}
	}
}
