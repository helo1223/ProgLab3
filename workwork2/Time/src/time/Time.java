package time;

public class Time {

	private int min;

	public Time(int hh, int mm) {
		this.min = hh * 60 + mm;
	}

	public Time() {
		this.min = 0;
	}

	public Time(int hh) {
		this.min = hh * 60;
	}

	public int getMins() {
		return min % 60;
	}

	public int getMinsOnly() {
		return min;
	}

	public int getHours() {
		return min / 60;
	}

	public String toString() {
		String s = String.format("%02d:%02d", this.getHours(), this.getMins());
		return s;
	}

	public void addHours(int hh) {
		this.min += 60*(hh%24);

	}

	public void addMins(int mins) {
		this.min += mins - (1440*(mins/1440));
	}

	public void add(Time t) {
		this.addMins(t.getMins());
	}

	public void sub(int mins) {
		if(mins > this.min){
			this.min += 60*24*(mins/1440) - mins;
		}else{
			this.min -=mins;
		}
	}

	public boolean greaterThan(Time t) {
		return (this.getMinsOnly() > t.getMinsOnly());
	}

	public boolean lessThan(Time t) {
		return (this.getMinsOnly() < t.getMinsOnly());
	}

	public int compareTo(Time t) {

		return this.getMinsOnly() - t.getMinsOnly();
	}

	public static void main(String[] args) {

		Time t = new Time(0, 30);
		Time tm = new Time(48, 30);
		System.out.println("t: "+t);
		t.addHours(2);
		System.out.println("+2h: "+t);
		t.addHours(48);
		System.out.println("+48h: "+t);
		t.addMins(4320);
		System.out.println("+4320m: "+t);
		System.out.print(t + " + " + tm + " = ");
		t.add(tm);
		System.out.println(t);
		t.sub(2880);
		System.out.println("-2880m: "+t);
		t.sub(150);
		System.out.println("-151m: "+t);
		
		System.out.println();
		System.out.println(new Time(8, 5));
		System.out.println(new Time(13, 0));
		System.out.println(new Time(10, 180));
		System.out.println(new Time());
		System.out.println();
		System.out.println(new Time(11, 0).greaterThan(new Time(11, 59)));
		System.out.println(new Time(12, 0).compareTo(new Time(13, 0)));

	}

}
