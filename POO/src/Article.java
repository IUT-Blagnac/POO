class Article {
    String nom ;
    int numero ;
    int categorie ;
    int quantite ;
    
    Article(String pfNom, int pfNumero){
        nom = pfNom ;
        numero = pfNumero ;
        categorie = 1 ;
        quantite = 1 ;
    }
    Article(String pfNom, int pfNumero, int pfCategorie, int pfQuantite){
        nom = pfNom ;
        numero = pfNumero ;
        categorie = pfCategorie ;
        quantite = pfQuantite ;
    }
    
    boolean enStock(){
        return(quantite > 0);
    }
    int vendre() throws Exception{
        if (! enStock()) { throw new Exception("vente impossible"); }
        quantite = quantite - 1 ;
        return(quantite);
    }
    int reprendre(){
        quantite = quantite + 1 ;
        return(quantite);
    }
    int vendre(int pfCombien) throws Exception{
        if (quantite < pfCombien) { throw new Exception("stock insuffisant"); }
        quantite = quantite - pfCombien ;
        return(quantite);
    }
    int reprendre(int pfCombien){
        quantite = quantite + pfCombien ;
        return(quantite);
    }
}