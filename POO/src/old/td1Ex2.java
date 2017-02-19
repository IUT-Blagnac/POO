public static void main(String[] argv) {
	int i, j, k ;
	double d, e, f
	i = 1; 
	j = i + 10 ; 
	k = j ; 
	e = 10.5; 
	// <1>
	if (e < i) { 
		f = j + k ;
		k = (int) (f - e) ;
	}	
}