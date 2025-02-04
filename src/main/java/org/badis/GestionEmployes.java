package org.badis;

import org.badis.classes.Employe;

import java.util.Scanner;

public class GestionEmployes {

    private static Employe[] employes = new Employe[50];
    private static int nbEmployes = 0;

    // Afficher le menu principal
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

    // Ajouter un employé
    public static void ajouterEmploye(Employe employe) {
        if (nbEmployes < 50) {
            employes[nbEmployes++] = employe;
            System.out.println("Employé ajouté avec succès !");
        } else {
            System.out.println("Le tableau est plein !");
        }
    }

    // Modifier un employé
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

    // Supprimer un employé
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

    // Afficher tous les employés
    public static void afficherEmployes() {
        if (nbEmployes == 0) {
            System.out.println("Aucun employé enregistré !");
        } else {
            for (int i = 0; i < nbEmployes; i++) {
                System.out.println(employes[i]);
            }
        }
    }

    // Rechercher un employé
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
                    break;
                case 7:
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
