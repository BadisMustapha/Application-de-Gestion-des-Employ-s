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
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
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
