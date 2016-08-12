package org.wyk.main;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.TimerTask;



public class MyTimerTask extends TimerTask{

	@Override
	public void run() {
		// TODO Auto-generated method stub
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println("shijian " + sdf.format(new Date()));
	}

	
}
