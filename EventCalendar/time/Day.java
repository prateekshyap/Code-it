package time;

public class Day
{
	public static int encodeDay(String day)
	{
		String[] dateData = day.split([-/.]);
		StringBuilder codedDay = new StringBuilder();
		int d = Integer.parseInt(dateData[1]);
		d *= 100;
		d += Integer.parseInt(dateData[0]);
		codedDay.append(d);
		codedDay.append(Integer.parseInt(dateData[2])%100);
		return codedDay.toString();
	}
	public String decode(int day)
	{
		return "";
	}
}