import java.text.NumberFormat;
import java.util.Locale;

public class ClasseEssai {

	public static void main(String[] arguments) throws Exception {
		
		Personne shmi, anakin, padme ;
		
		shmi = new Personne("Shmi","Skywalker","feminin",null,null); // <1>
		System.out.println(shmi);
		
		//ClasseEssai.testChangeObjet(shmi) ; // <2>
		System.out.println(shmi);
		
		System.out.println("->"+Locale.FRANCE.getCountry());
	}
	
	public static void testChangeObjet (Personne p) {
		p.setNom ("Nouveau nom", "Autre prénom"); // <3>
	}
}

//Type Personne
class Personne {
	private String nom ;
	private String prenom ;
	private String sexe ;
	private Personne descendantDe ;
	private Personne conjointDe ;

	// Constructeur
	// usage:
	// Personne parent, conjoint ;
	// Personne p = new Personne("prenom","nom","feminin",parent,conjoint);
	Personne(String valeurInitialePrenom, String valeurInitialeNom, String valeurInitialeSexe, Personne valeurInitialeDescendantDe, Personne valeurInitialeConjointDe){
		nom = valeurInitialeNom ;
		prenom = valeurInitialePrenom ;
		sexe = valeurInitialeSexe ;
		descendantDe = valeurInitialeDescendantDe ;
		conjointDe = valeurInitialeConjointDe ;
	}

	public void setNom (String n, String p) {
		this.nom = n; // <4>
		this.prenom = p;
	}
	
	public void setConjointDe (Personne p) {
		this.conjointDe = p;
	}

	public String toString() { // Appelée lorsqu'on fait System.out.println(unePersonne);
		String resultat = "" ;
		resultat = resultat + "Personne: " + System.identityHashCode(this) + "\n" ;
		resultat = resultat + "  Nom: " + nom + "\n" ;
		resultat = resultat + "  Prenom: " + prenom + "\n" ;
		resultat = resultat + "  Sexe: " + sexe + "\n" ;
		resultat = resultat + "  Conjoint de: " + System.identityHashCode(conjointDe) + "\n" ;
		resultat = resultat + "  Descendant de: " + System.identityHashCode(descendantDe) ;
		return resultat ;
	}
}