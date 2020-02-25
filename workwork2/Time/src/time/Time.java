package time;

public class Time {

	private int min;

	public Time(int hh, int mm) {
		this.min = hh * 60 + mm;
	}

	public Time() {
		this.min = 0;
	}

	public int getMins() {
		return min;
	}

	public int getHours() {
		return min / 60;
	}

	public String toString() {
		String s = String.format("%02d:%02d", this.getHours(), min % 60);
		return s;
	}

	public void add(int mins) {
		this.min += mins;
	}

	public void sub(int mins) {
		if (this.min < mins) {
			this.min = 60 * 24;
			this.min -= mins;
		} else {
			this.min -= mins;
		}
	}

	public boolean greaterThan(Time t) {
		return (this.getMins() > t.getMins());
	}

	public boolean lessThan(Time t) {
		return (this.getMins() < t.getMins());
	}

	public int compareTo(Time t) {

		return this.getMins() - t.getMins();
	}

	public static void main(String[] args) {

		Time t = new Time(0, 0);
		Time tm = new Time(4, 0);
		System.out.print(t.toString() + " - " + tm.toString() + " = ");
		t.sub(tm.getMins());
		System.out.println(t);

		System.out.println(new Time(8, 5));
		System.out.println(new Time(13, 0));
		System.out.println(new Time(10, 180));
		System.out.println(new Time());

		System.out.println(new Time(11, 0).greaterThan(new Time(11, 59)));
		System.out.println(new Time(12, 0).compareTo(new Time(13, 0)));

	}

}
