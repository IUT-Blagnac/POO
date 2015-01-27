package diverstestssimples;

import sd.iut.implementations.ArrayList;

public class ALO extends ArrayList<Object> {
	public static  void main (String argv[]) {
		ALO alo = new ALO();
		
		alo.add(new Object());
		alo.add(new Object());
		for (int i=0; i<alo.size();i++)
			System.out.println(alo.elementAt(i));
		
		ArrayList<Integer> ali = new ArrayList<Integer>();
		
		ali.add(10);
		ali.inserElementAt(0, 20);
		ali.inserElementAt(0, 30);
		for (int i=0; i<ali.size();i++)
			System.out.println(ali.elementAt(i));
	}
}
