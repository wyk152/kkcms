package org.wyk.main;

import java.util.Timer;

public class Mytimer {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Timer t = new Timer();
		t.schedule(new MyTimerTask(), 2000, 3000);
	}

}
