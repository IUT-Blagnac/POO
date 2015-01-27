
public class CopyOfExoRepresentationMemoire {

	public static void main(String[] args) {
		int i;
		int tabInt[];
		int autreRefTab [];
		MyClass tabMc[];
		MyClass a, b, vmc;
		String s;

		s = "Jean";

		tabInt = new int [4];
		for (i=0; i<4; i++){
			tabInt[i] = (i+1)*10;
		}
		autreRefTab = tabInt;
		for (i=0; i<4; i++){
			tabInt[i] = tabInt[i] * 10;
		}

		a = new MyClass();
		b = a;
		tabMc  = new MyClass [4];
		vmc = new MyClass (4);
		tabMc[0] = new MyClass (4);
		tabMc[1] = tabMc[0];
		tabMc[2] = vmc;
		tabMc[3] = tabMc[2];
	}

}

