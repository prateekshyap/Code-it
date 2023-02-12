package time;

public class Day
{
	public static int encodeDay(String day)
	{
		int[] dateData = day.split("[-/.]");
		StringBuilder codedDay = new StringBuilder();
		int d = dateData[1];
		d *= 100;
		d += dateData[0];
		codedDay.append(d);
		codedDay.append(dateData[2]%100);
		return codedDay.toString();
	}
	public String decode(int day)
	{
		return "";
	}
}