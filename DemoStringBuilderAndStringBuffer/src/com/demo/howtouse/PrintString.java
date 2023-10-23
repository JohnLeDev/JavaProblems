package com.demo.howtouse;

public class PrintString  implements Runnable{
	private String data; 
	public PrintString(String data) {
		this.data = data;
	}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		System.out.println(data);
	}

}
