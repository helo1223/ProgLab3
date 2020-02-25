package fraction;

public class Fraction {

	private int num, den;

	public Fraction() {
		this.num = 0;
		this.den = 1;
	}

	public Fraction(int p) {
		this.num = p;
		this.den = 1;
	}

	public Fraction(int p, int q) {
		this.num = p;
		this.den = q;
	}

	public int getNum() {
		return num;
	}

	public int getDen() {
		return den;
	}

	public double doubleValue() {
		return (double) num / (double) den;
	}

	public Fraction reciprocal() {
		return new Fraction(this.den, this.num);
	}

	public void add(double a) {
		this.num += a * this.den;
	}

	public void sub(double a) {
		this.num -= a * this.den;
	}

	public void mult(double a) {
		this.num *= a;
	}

	public void div(double a) {
		this.den *= a;
	}

	private static int euklidesz(int a, int b) {
		if (a == 0) {
			return b;
		} else {
			return euklidesz(b % a, a);
		}
	}

	public void simplify() {
		int kozos = euklidesz(this.num, this.den);
		this.num /= kozos;
		this.den /= kozos;
	}

	public boolean greaterThan(Fraction f) {
		return (this.doubleValue() > f.doubleValue());
	}

	public boolean lessThan(Fraction f) {
		return (this.doubleValue() < f.doubleValue());
	}

	public int compareTo(Fraction f) {
		return (int) (this.doubleValue() - f.doubleValue());
	}

	public static void main(String[] args) {
		Fraction on = new Fraction(1, 4);
		Fraction bo = on.reciprocal();
		System.out.println(on.doubleValue());
		System.out.println(bo.doubleValue());
		on.mult(4);
		System.out.println(on.doubleValue());
		on.div(3);
		System.out.println(on.doubleValue());
		on.add(1.25);
		System.out.println(on.doubleValue());

		Fraction odd = new Fraction(8, 36);
		System.out.println(odd.getNum() + " / " + odd.getDen() + " = " + odd.doubleValue());
		odd.simplify();
		System.out.println(odd.getNum() + " / " + odd.getDen() + " = " + odd.doubleValue());

		System.out.println(odd.doubleValue());
		System.out.println(on.doubleValue());
		System.out.println(odd.greaterThan(on));
		System.out.println(odd.compareTo(on));
	}

}
