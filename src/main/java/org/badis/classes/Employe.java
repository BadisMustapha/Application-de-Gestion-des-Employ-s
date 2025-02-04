package org.badis.classes;

public class Employe {


    // Attributs
    private int id;
    private String nom;
    private String poste;
    private double salaire;
    private static int dernierId = 0; // Variable statique pour générer des IDs uniques

    // Constructeur par défaut
    public Employe() {
        this.id = ++dernierId;
        this.nom = "";
        this.poste = "";
        this.salaire = 0.0;
    }

    // Constructeur avec tous les attributs
    public Employe(String nom, String poste, double salaire) {
        this.id = ++dernierId;
        this.nom = nom;
        this.poste = poste;
        this.salaire = salaire;
    }

    // Getters et Setters
    public int getId() { return id; }
    public String getNom() { return nom; }
    public void setNom(String nom) { this.nom = nom; }
    public String getPoste() { return poste; }
    public void setPoste(String poste) { this.poste = poste; }
    public double getSalaire() { return salaire; }
    public void setSalaire(double salaire) { this.salaire = salaire; }

    // Méthode toString()
    @Override
    public String toString() {
        return "ID: " + id + ", Nom: " + nom + ", Poste: " + poste + ", Salaire: " + salaire;
    }

    // Méthode statique pour comparer deux employés par salaire
    public static int compareParSalaire(Employe e1, Employe e2) {
        return Double.compare(e1.salaire, e2.salaire);
    }


}
