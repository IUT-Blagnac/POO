public class ClasseEssai {
	public static void afficheTab (int[] pfT) { 
		int i; 
		
		for (i=0; i<pfT.length; i++) {
			System.out.println(pfT[i]); 
		} 
	}
	public static int somTab (int[] pfT) {
		int i, som;
		som = 0;
		
		for (i=0; i<pfT.length; i++) {
			som = som+pfT[i]; 
		}
		return som;
	}
	public static void changeTab (int[] pfT) {
		int i ;
		
		for (i=0; i<pfT.length; i++) {
			pfT[i] = pfT[i] * 100; 
		}
	}
	
	public static void main(String argv[]) {
		int tab [],  i, som; 
		int tab3 [] = {1, 2, 3};
		
		tab = new int [5];  // <1>
		for (i = 0; i < tab.length; i++) {
			tab[i] = 20+i;
		}
		ClasseEssai.afficheTab(tab); // <2>
		System.out.println ( ClasseEssai.somTab(tab) ); // <3>
		System.out.println ( ClasseEssai.somTab(tab3) ); // <4>
		ClasseEssai.changeTab(tab); // <5>
		ClasseEssai.afficheTab(tab); // <6>
	}
}