import java.util.*;

public class CompteDepot extends Compte {
	private ArrayList<Operation> alOperations;

	public CompteDepot() {
		this("Pas de numéro", "Pas de propriétaire");
	}

	public CompteDepot(String pNumCompte, String pNomProp) {
		super(pNumCompte, pNomProp);
		this.alOperations = new ArrayList<Operation>();
	}

	@Override
	public void afficher() {
		super.afficher();
		System.out.println("  Les Opérations :");
		for (Operation o : this.alOperations)
			System.out.println("    - " + o.getSens() + " : " + o.getMontant());
	}

	@Override
	public void retirer(double pSomme) throws CompteException {
		super.retirer(pSomme);
		this.alOperations.add(new Operation(SensOperation.DEBIT, pSomme));
	}

	@Override
	public void deposer(double pSomme) throws CompteException {
		super.deposer(pSomme);
		this.alOperations.add(new Operation(SensOperation.CREDIT, pSomme));
	}

	public Operation[] getOperations() {
		return this.alOperations.toArray(new Operation[0]);
	}
}
