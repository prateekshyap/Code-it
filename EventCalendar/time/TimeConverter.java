package time;

public class TimeConverter
{
	public static int convertStringTo24Format(String time)
	{
		int len = time.length();
		int[] formattedTime = new int[2];
		int hour = 0, minute = 0;
		hour = time.charAt(0)-'0';
		if (time.charAt(1) != ':')
		{
			hour *= 10;
			hour += time.charAt(1)-'0';
			minute = time.charAt(3)-'0';
			minute *= 10;
			minute += time.charAt(4)-'0';
		}
		else
		{
			minute = time.charAt(2)-'0';
			minute *= 10;
			minute += time.charAt(3)-'0';
		}
		hour = hour%12;
		if (time.charAt(len-2) == 'P' || time.charAt(len-1) == 'p')
			hour += 12;
		formattedTime[0] = hour;
		formattedTime[1] = minute;
		// return formattedTime;
		int finalTime = formattedTime[0]*60;
		finalTime += formattedTime[1];
		return finalTime;
	}
	public static String convert24ToStringFormat(int timeValue)
	{
		StringBuilder build = new StringBuilder();
		boolean isPost = false;

		int[] time = new int[2];
		time[0] = timeValue/60;
		time[1] = timeValue%60;

		if (time[0] == 0)
			build.append("12");
		else if (time[0] > 12)
		{
			isPost = true;
			build.append(time[0]-12);
		}
		else
		{
			isPost = false;
			build.append(time[0]);
		}
		build.append(':');
		if (time[1] < 10)
			build.append('0');
		build.append(time[1]);
		build.append(isPost ? "PM" : "AM");

		return build.toString();
	}
}