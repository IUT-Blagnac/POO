class Article {
    String nom ;
    int numero ;
    int categorie ;
    int quantite ;
    
    Article(String pNom, int pNumero){
        nom = pNom ;
        numero = pNumero ;
        categorie = 1 ;
        quantite = 1 ;
    }
    Article(String pNom, int pNumero, int pCategorie, int pQuantite){
        nom = pNom ;
        numero = pNumero ;
        categorie = pCategorie ;
        quantite = pQuantite ;
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
    int vendre(int combien) throws Exception{
        if (quantite >= combien) { throw new Exception("stock insuffisant"); }
        quantite = quantite - combien ;
        return(quantite);
    }
    int reprendre(int combien){
        quantite = quantite + combien ;
        return(quantite);
    }
}