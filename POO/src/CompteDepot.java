import java.util.*;

public class CompteDepot extends Compte {
	private ArrayList<Operation> alOperations;

	public CompteDepot() {
		this("Pas de numéro", "Pas de propriétaire");
	}

	public CompteDepot(String pfNumCompte, String pfNomProp) {
		super(pfNumCompte, pfNomProp);
		this.alOperations = new ArrayList<Operation>();
	}

	@Override
	public void afficher() {
		super.afficher();
		System.out.println("  Les Operations :");
		for (Operation o : this.alOperations)
			System.out.println("    - " + o.getSens() + " : " + o.getMontant());
	}

	@Override
	public void retirer(double pfMontant) throws CompteException {
		super.retirer(pfMontant);
		this.alOperations.add(new Operation(SensOperation.DEBIT, pfMontant));
	}

	@Override
	public void deposer(double pfMontant) throws CompteException {
		super.deposer(pfMontant);
		this.alOperations.add(new Operation(SensOperation.CREDIT, pfMontant));
	}

	public Operation[] getOperations() {
		return this.alOperations.toArray(new Operation[0]);
	}
}
