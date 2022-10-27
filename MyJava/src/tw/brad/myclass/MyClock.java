package tw.brad.myclass;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JLabel;

public class MyClock extends JLabel{
	private Timer timer;
	
	public MyClock() {
		timer = new Timer();
		timer.schedule(new ClockTask(), 0, 1000);
	}
	
	private class ClockTask extends TimerTask{
		@Override
		public void run() {
//			Calendar now = Calendar.getInstance();	// 時間顯示v1
//			int yy = now.get(Calendar.YEAR);
//			int mm = now.get(Calendar.MONTH);
//			int dd = now.get(Calendar.DAY_OF_MONTH);
//			int h = now.get(Calendar.HOUR_OF_DAY);
//			int m = now.get(Calendar.MINUTE);
//			int s = now.get(Calendar.SECOND);
//			setText(String.format("%04d-%02d-%02d %02d:%02d:%02d", yy, mm, dd, h, m, s));	// 時間顯示補0
			
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");	// 時間顯示v2
			setText(sdf.format(new Date()));
		}
	}
}
