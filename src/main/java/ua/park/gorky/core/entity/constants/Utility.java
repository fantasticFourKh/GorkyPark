package ua.park.gorky.core.entity.constants;

import javax.servlet.http.Part;
import java.sql.Time;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Random;

public class Utility {

	public static Timestamp getDate() {
		java.util.Date utilDate = new java.util.Date();
		return new Timestamp(utilDate.getTime());
	}

	public static String createNewPath() {
		Random rand = new Random();
		StringBuilder str = new StringBuilder();
		for (int i = 0; i < 10; i++) {
			boolean flag = rand.nextBoolean();
			Character c;
			if (flag) {
				c = (char) ('a' + rand.nextInt(26));
				c = Character.toUpperCase(c);
			} else {
				c = (char) ('a' + rand.nextInt(26));
			}
			str.append(c);
		}
		return str.toString() + ".mypic";
	}

	public static String extractFileName(Part part) {
		String contentDisp = part.getHeader("content-disposition");
		String[] items = contentDisp.split(";");
		for (String s : items) {
			if (s.trim().startsWith("filename")) {
				return s.substring(s.indexOf("=") + 2, s.length() - 1);
			}
		}
		return "";
	}

	public static Time getTodayTime() {
		Calendar cal = Calendar.getInstance();
		SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
		return Time.valueOf(sdf.format(cal.getTime()));
	}

	public static Timestamp getTomorrowDate() {
		Calendar cal = Calendar.getInstance();
		java.util.Date utilDate = cal.getTime();
		cal.setTime(utilDate);
		cal.add(Calendar.DATE, 1);
		utilDate = cal.getTime();
		return new Timestamp(utilDate.getTime());
	}
}
