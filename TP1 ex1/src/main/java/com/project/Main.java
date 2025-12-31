package com.project;
import java.util.Scanner;
// Pourquoi est-il important de tester les valeurs limites (0, valeurs négatives, taux extrêmes) dans une application de conversion de devises ?
/*
Valeurs Négatives : Une conversion avec un montant négatif peut entraîner des erreurs graves, comme la corruption des données financières ou des transactions inversées non souhaitées. Il est donc crucial que l'application gère correctement les montants négatifs en les rejetant ou en les signalant comme des erreurs.

Valeur Zéro (0) : La valeur zéro doit être testée pour éviter les erreurs de calcul, comme les divisions par zéro. Même si une conversion à zéro n'a souvent pas de sens, l'application doit être capable de la traiter sans provoquer de crash ou de comportement indésirable. Il est important de garantir que l'application ne plante pas dans ce cas particulier.

Taux Extrêmes (Très grands/petits) : Tester les taux de conversion très grands ou très petits permet de s'assurer que les types de données (comme `double` ou `BigDecimal`) utilisés sont capables de traiter ces valeurs sans perte de précision. Par exemple, un taux extrêmement faible pourrait être arrondi à zéro, ce qui fausserait les résultats de conversion et entraînerait des erreurs financières.
*/

// Quels types de tests automatiques pourraient être ajoutés pour la performance ou la compatibilité ?
/*
Tests de Performance (Load Testing) : Pour garantir la performance de l'application sous une charge élevée, il est essentiel d'effectuer des tests de charge. L'utilisation d'outils comme **JMeter** ou des tests unitaires **JUnit** avec la configuration `@Timeout` permet de vérifier comment l'application réagit sous une pression extrême, comme lors de l'exécution de 1 million de conversions en moins d'une seconde.

Tests de Compatibilité : Il est important de tester l'application dans différents environnements afin de garantir sa compatibilité. Cela peut être réalisé via des pipelines CI/CD, tels que **GitHub Actions** ou **Jenkins**, qui exécutent les tests sur différentes versions du système d'exploitation (Linux, Windows) et du JDK (Java 17, Java 21). Ce type de test permet de s'assurer que l'application fonctionne correctement quel que soit l'environnement dans lequel elle est déployée.
*/

public class Main {
    public static void main(String[] args) {
        ExchangeRate exchangeRate = new ExchangeRate();
        CurrencyConverter converter = new CurrencyConverter(exchangeRate);
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        System.out.println("=== Application de Conversion de Devises ===");

        while (running) {
            try {

                System.out.println("\nChoisissez une option :");
                System.out.println("1. Convertir MAD vers EUR");
                System.out.println("2. Convertir EUR vers MAD");
                System.out.println("3. Quitter");
                System.out.print("Votre choix : ");

                int choice = Integer.parseInt(scanner.nextLine());

                if (choice == 3) {
                    running = false;
                    System.out.println("Byeee !");
                    continue;
                }
                System.out.print("Entrez le montant : ");
                double amount = Double.parseDouble(scanner.nextLine());
                double result = 0;
                switch (choice) {
                    case 1:
                        result = converter.convertMadToEur(amount);
                        System.out.printf("%.2f MAD = %.2f EUR%n", amount, result);
                        break;
                    case 2:
                        result = converter.convertEurToMad(amount);
                        System.out.printf("%.2f EUR = %.2f MAD%n", amount, result);
                        break;
                    default:
                        System.out.println("Option invalide. Veuillez choisir 1, 2 ou 3.");
                }

            } catch (NumberFormatException e) {
                System.out.println("Erreur : Veuillez entrer un nombre valide.");
            } catch (IllegalArgumentException e) {
                // Catches the "Amount cannot be negative" exception from CurrencyConverter
                System.out.println("Erreur : " + e.getMessage());
            } catch (Exception e) {
                System.out.println("Une erreur inattendue est survenue : " + e.getMessage());
            }
        }

        scanner.close();
    }
}