# Rapport : Application de Gestion des Employés

## 1. Introduction
Le projet consiste à développer une application Java pour gérer les employés d'une entreprise en utilisant les concepts fondamentaux de la **programmation orientée objet (POO)**. Cette application permet de manipuler un tableau d'objets `Employe[]` avec une capacité maximale de 50 employés et offre plusieurs fonctionnalités clés, telles que l'ajout, la modification, la suppression, l'affichage, la recherche, le calcul de la masse salariale et le tri des employés par salaire.

---

## 2. Étapes de Réalisation

### **Étape 1 : Analyse des Besoins**
- Comprendre les objectifs de l'application :
    - Ajouter, modifier, supprimer, afficher, rechercher des employés.
    - Calculer la masse salariale.
    - Trier les employés par salaire.
- Identifier les données nécessaires pour chaque employé :
    - ID unique.
    - Nom complet.
    - Poste occupé.
    - Salaire mensuel.
- Définir les spécifications techniques :
    - Utiliser une classe `Employe` pour représenter chaque employé.
    - Utiliser un tableau `Employe[]` pour stocker les employés.
    - Implémenter une classe principale `GestionEmployes` pour gérer les opérations.

---

### **Étape 2 : Conception des Classes**

#### **Classe `Employe`**
- **Attributs privés** :
    - `id` (identifiant unique).
    - `nom` (nom complet).
    - `poste` (poste occupé).
    - `salaire` (salaire mensuel).
- **Constructeurs** :
    - Un constructeur par défaut.
    - Un constructeur avec tous les attributs.
- **Méthodes** :
    - Getters et setters pour accéder/modifier les attributs.
    - Une méthode `toString()` pour afficher les informations complètes d'un employé.
    - Une méthode statique `compareParSalaire` pour comparer deux employés par leur salaire.

#### **Classe `GestionEmployes`**
- **Tableau `Employe[]`** pour stocker les employés (capacité maximale : 50).
- **Variable `nbEmployes`** pour suivre le nombre d'employés actuels.
- **Méthodes statiques** pour chaque fonctionnalité demandée :
    - `printMenu()` : Afficher le menu principal.
    - `ajouterEmploye(Employe employe)` : Ajouter un nouvel employé.
    - `modifierEmploye(int id, String nouveauNom, String nouveauPoste, double nouveauSalaire)` : Modifier un employé existant.
    - `supprimerEmploye(int id)` : Supprimer un employé.
    - `afficherEmployes()` : Afficher tous les employés.
    - `rechercherEmploye(String critere)` : Rechercher un employé par nom ou poste.
    - `calculerMasseSalariale()` : Calculer la somme des salaires.
    - `trierEmployesParSalaire(boolean ordreCroissant)` : Trier les employés par salaire.

---

### **Étape 3 : Implémentation du Code**

1. **Création de la classe `Employe`** :
    - Définition des attributs privés et des constructeurs.
    - Implémentation des getters, setters, `toString()`, et `compareParSalaire`.

   ```java
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

#### **Création de la classe `GestionEmployes`**
La classe `GestionEmployes` est la classe principale qui gère les opérations liées aux employés. Elle contient :
- Un tableau `Employe[]` pour stocker les employés (capacité maximale : 50).
- Une variable `nbEmployes` pour suivre le nombre d'employés actuels.
- Des méthodes statiques pour chaque fonctionnalité demandée :

#### **Programme Principal `GestionEmployes`**
- Création d'un menu interactif pour permettre à l'utilisateur d'effectuer différentes actions.
- Gestion des entrées utilisateur via la classe Scanner.

##### **Structure de la classe `GestionEmployes`**
    ```java
    public class GestionEmployes {
        private static Employe[] employes = new Employe[50]; // Tableau pour stocker les employés
        private static int nbEmployes = 0; // Nombre d'employés actuels
    
        // Méthode pour afficher le menu principal
        public static void printMenu() {
            System.out.println("=== Menu Principal ===");
            System.out.println("1. Ajouter un employé");
            System.out.println("2. Modifier un employé");
            System.out.println("3. Supprimer un employé");
            System.out.println("4. Afficher la liste des employés");
            System.out.println("5. Rechercher un employé");
            System.out.println("6. Calculer la masse salariale");
            System.out.println("7. Trier les employés par salaire");
            System.out.println("8. Quitter");
            System.out.print("Choix : ");
        }
    
        // Méthode pour ajouter un nouvel employé
        public static void ajouterEmploye(Employe employe) {
            if (nbEmployes < 50) {
                employes[nbEmployes++] = employe;
                System.out.println("Employé ajouté avec succès !");
            } else {
                System.out.println("Le tableau est plein !");
            }
        }
    
        // Méthode pour modifier un employé existant
        public static void modifierEmploye(int id, String nouveauNom, String nouveauPoste, double nouveauSalaire) {
            for (int i = 0; i < nbEmployes; i++) {
                if (employes[i].getId() == id) {
                    employes[i].setNom(nouveauNom);
                    employes[i].setPoste(nouveauPoste);
                    employes[i].setSalaire(nouveauSalaire);
                    System.out.println("Employé modifié avec succès !");
                    return;
                }
            }
            System.out.println("Aucun employé trouvé avec cet ID.");
        }
    
        // Méthode pour supprimer un employé
        public static void supprimerEmploye(int id) {
            for (int i = 0; i < nbEmployes; i++) {
                if (employes[i].getId() == id) {
                    for (int j = i; j < nbEmployes - 1; j++) {
                        employes[j] = employes[j + 1];
                    }
                    employes[--nbEmployes] = null;
                    System.out.println("Employé supprimé avec succès !");
                    return;
                }
            }
            System.out.println("Aucun employé trouvé avec cet ID.");
        }
    
        // Méthode pour afficher tous les employés
        public static void afficherEmployes() {
            if (nbEmployes == 0) {
                System.out.println("Aucun employé enregistré !");
            } else {
                for (int i = 0; i < nbEmployes; i++) {
                    System.out.println(employes[i]);
                }
            }
        }
    
        // Méthode pour rechercher un employé
        public static void rechercherEmploye(String critere) {
            boolean found = false;
            for (int i = 0; i < nbEmployes; i++) {
                if (employes[i].getNom().contains(critere) || employes[i].getPoste().contains(critere)) {
                    System.out.println(employes[i]);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("Aucun employé trouvé correspondant au critère.");
            }
        }
    
        // Méthode pour calculer la masse salariale
        public static double calculerMasseSalariale() {
            double total = 0;
            for (int i = 0; i < nbEmployes; i++) {
                total += employes[i].getSalaire();
            }
            return total;
        }
    
        // Méthode pour trier les employés par salaire
        public static void trierEmployesParSalaire(boolean ordreCroissant) {
            Arrays.sort(employes, 0, nbEmployes, (e1, e2) -> ordreCroissant ? Employe.compareParSalaire(e1, e2) : -Employe.compareParSalaire(e1, e2));
            System.out.println("Liste triée :");
            afficherEmployes();
        }

        // Programme principal
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int choix;
    
            do {
                printMenu();
                choix = scanner.nextInt();
                scanner.nextLine(); // Consommer le retour à la ligne
    
                switch (choix) {
                    case 1:
                        System.out.print("Nom : ");
                        String nom = scanner.nextLine();
                        System.out.print("Poste : ");
                        String poste = scanner.nextLine();
                        System.out.print("Salaire : ");
                        double salaire = scanner.nextDouble();
                        ajouterEmploye(new Employe( nom, poste, salaire));
                        break;
                    case 2:
                        System.out.print("ID à modifier : ");
                        int idModif = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Nouveau nom : ");
                        String nouveauNom = scanner.nextLine();
                        System.out.print("Nouveau poste : ");
                        String nouveauPoste = scanner.nextLine();
                        System.out.print("Nouveau salaire : ");
                        double nouveauSalaire = scanner.nextDouble();
                        modifierEmploye(idModif, nouveauNom, nouveauPoste, nouveauSalaire);
                        break;
                    case 3:
                        System.out.print("ID à supprimer : ");
                        int idSuppr = scanner.nextInt();
                        supprimerEmploye(idSuppr);
                        break;
                    case 4:
                        afficherEmployes();
                        break;
                    case 5:
                        System.out.print("Rechercher par nom ou poste : ");
                        String critere = scanner.nextLine();
                        rechercherEmploye(critere);
                        break;
                    case 6:
                        System.out.println("Masse salariale : " + calculerMasseSalariale());
                        break;
                    case 7:
                        System.out.print("Trier par salaire (1 pour croissant, 2 pour décroissant) : ");
                        int ordre = scanner.nextInt();
                        trierEmployesParSalaire(ordre == 1);
                        break;
                    case 8:
                        System.out.println("Au revoir !");
                        break;
                    default:
                        System.out.println("Choix invalide !");
                }
            } while (choix != 8);
    
            scanner.close();
        }
    }
---
### **Étape 4 : Tests et Validation**
- Tester chaque fonctionnalité individuellement :
  - Ajouter un employé.
  - Modifier un employé.
  - Supprimer un employé.
  - Afficher la liste des employés.
  - Rechercher un employé.
  - Calculer la masse salariale.
  - Trier les employés par salaire.
  
### **Mèthode PrintMenu() :**

<img src="images/printMenuR.png">

### **Mèthode AjouterEmploye(Employe employe) :**
<img src="images/ajouterEmployeR.png">

### **Mèthode ModifierEmploye(int id, String nouveauNom, String nouveauPoste, double nouveauSalaire) :**
<img src="images/modifieR.png">

### **Mèthode SupprimerEmploye(int id)**
<img src="images/supprimerR.png">

## Mèthode AfficherEmployes()**
<img src="images/afficherR.png">

### **Mèthode RechercherEmploye(String critere)**
<img src="images/rechercheR.png">

### **Mèthode CalculerMasseSalariale()**
<img src="images/calculerR.png">

### **Mèthode TrierEmployesParSalaire(boolean ordreCroissant)**
<img src="images/trieR.png">

---

## 2. Difficultés Rencontrées

Lors de la réalisation du projet, plusieurs difficultés ont été identifiées et résolues :

 - Gestion des IDs uniques : Pour garantir que chaque employé a un ID unique, une variable statique dernierId a été introduite dans la classe Employe.
 - Tri des employés : La méthode Arrays.sort a été utilisée avec une comparaison personnalisée pour trier les employés par salaire.
 - Validation des entrées utilisateur : Des vérifications ont été ajoutées pour éviter les erreurs liées à des entrées invalides.



