
public class Tempo {
	public static void main (String argv[])
	{
	   Animal [] ta = new Animal [5] ;

	   Animal  a1 = new Animal () ;
	   Animal  a2 = new Perroquet () ;
	   Chien  a3 = new Labrador () ;
	   Animal  a4 = new Minetou () ;
	   Labrador  a5 = new Jimmy () ;
	   Chien  a6 = new Chien () ;
	   Chat  a7 = new Minetou () ;
	   Animal  a8 = new Caniche () ;

	   a1.crier () ;
	   a2.crier () ;
	   a3.crier () ;
	   a4.crier () ;
	   a5.crier () ;
	   a6.crier () ;
	   a7.crier () ;
	   a8.crier () ;

	   ta[0] = a4 ;
	   ta[1] = a6 ;
	   ta[2] = a2 ;
	   ta[3] = a3 ;
	   ta[4] = ta[0] ;

	   System.out.println ("");

	   for (int i=0 ; i<ta.length ; i++)
	       ta[i].crier () ;
	}

}
class Animal {
	   public void crier () {
	       System.out.println ("Pas de bruit");
	   }
	}

	class Chat extends Animal {
	   public void crier () {
	       System.out.println ("Miaou");
	   }
	}

	class Oiseau extends Animal {
	   public void crier () {
	       System.out.println ("Cui");
	   }
	}  

	class Chien extends Animal {
	}
	 
	class Labrador extends Chien {
	   public void crier () {
	       System.out.println ("OuaOuaOua");
	   }
	}  

	class Jimmy extends Labrador {
	   public void crier () {
	       System.out.println ("Ouaf Waouf");
	   }
	}

	class Minetou extends Chat  {
	}

	class Caniche extends Chien {
	}

	class Perroquet extends Oiseau {
	   public void crier () {
	       System.out.println ("C'est coco");
	   }
	} 