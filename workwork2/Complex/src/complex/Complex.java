package complex;

/** Komplex számokat reprezentáló osztály. */
public class Complex {
	/**
	 * Valós és képzetes rész
	 */
	private double re, im;

	/** Konstruktor. Re: valós rész, Im: képzetes rész */
	public Complex(double re, double im) {
		this.re = re;
		this.im = im;
	}

	public Complex(double d) {
		this.re = d;
		this.im = 0;
	}

	/** Default konstruktor, nullára inicializál */
	public Complex() {
		this(0, 0);
	}

	public void setRe(double re) {
		this.re = re;
	}

	public void setIm(double im) {
		this.im = im;
	}

	public double getRe() {
		return re;
	}

	public double getIm() {
		return im;
	}

	public String toString() {
		String s = (this.re + (this.im < 0 ? "" : "+") + this.im + "i");
		return s;
	}

	/** Visszaadja a szám abszolút értékét. */
	public double abs() {
		double d = Math.sqrt(re * re + im * im);
		return d;
	}

	/** Összeadja this-t és c-t, az eredmény a visszatérési érték. */
	public Complex add(Complex c) {
		Complex ret = new Complex(re + c.re, im + c.im);
		return ret;
	}

	public Complex mult(Complex x) {
		Complex ret = new Complex((re * x.re) - (im * x.im), (re * x.im + im * x.re));
		return ret;

	}

	public static void main(String[] args) {

		// a)
		Complex a1 = new Complex(3, 4);
		Complex a2 = new Complex(1, 0);
		Complex a3 = new Complex(5, -3);
		System.out.println(a1.toString());
		System.out.println(a2.toString());
		System.out.println(a3.toString());
		System.out.println();

		// b)

		Complex b1 = new Complex(1);
		Complex b2 = new Complex(2);
		Complex b3 = new Complex(3);
		System.out.println(b1.add(b2).add(b3));
		Complex b4 = new Complex(5);
		Complex b5 = new Complex(10);
		System.out.println(b4.add(b5));
		System.out.println();

		// c)

		Complex c1 = new Complex(1, 2);
		Complex c2 = new Complex(2, -3);
		System.out.println(c1.mult(c2));
		Complex c3 = new Complex(2);
		Complex c4 = new Complex(0, 5);
		System.out.println(c3.mult(c4));

	}

}
