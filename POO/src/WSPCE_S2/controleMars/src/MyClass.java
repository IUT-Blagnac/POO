
public class MyClass
{
	private double val ;

	public MyClass () {
		this.val = 10.0;
	}
	public MyClass (double pValue) {
		this.val = pValue;
	}
	public void plusplus () {
		this.val = this.val + 1;
	}
	public double getValue () {
		return this.val;
	}
}
