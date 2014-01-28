public static void main(String argv[]) {
	int i, j, k ;
	double d, e, f
	i = 1; // <1>
	j = i + 10 ; // <2><3>
	k = j ; // 
	e = 10.5; 
	if (e < i) { // <4><5>
		f = j + k ;
		k = (int) (f - e) ;
	}	
}