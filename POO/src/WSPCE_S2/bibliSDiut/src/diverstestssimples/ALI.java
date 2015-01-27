package diverstestssimples;

import sd.iut.implementations.ArrayList;

public class ALI extends ArrayList<Integer> {
	public static  void main (String argv[]) {
		ALI ali = new ALI();
		
		ali.add(10);
		ali.inserElementAt(0, 20);
		ali.inserElementAt(0, 30);
		for (int i=0; i<ali.size();i++)
			System.out.println(ali.elementAt(i));
	}
}
