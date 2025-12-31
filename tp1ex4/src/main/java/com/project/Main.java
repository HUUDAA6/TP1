package com.project;
/*
IV. Analyse des Rapports JaCoCo
7. Quelles informations spécifiques sur la couverture de code pouvez-vous extraire des rapports ? Le rapport fournit plusieurs métriques, telles que :

Instructions (C0) : Représente le pourcentage de bytecode Java exécuté lors des tests.

Branches (C1) : Indique le pourcentage de chemins décisionnels (comme les conditions `if` ou `switch`) pris pendant les tests.

Complexité Cyclomatique : Mesure la complexité du code en termes de nombre de chemins distincts dans les méthodes couvertes.

Lignes : Montre les lignes de code source qui ont été exécutées pendant les tests.

Méthodes : Nombre de méthodes appelées au moins une fois pendant les tests.

8. Comment identifiez-vous les parties du code qui ne sont pas couvertes par les tests unitaires ? Visuellement, dans le rapport HTML :

Rouge : Indique que la ligne de code n'a pas été exécutée pendant les tests.

Jaune : Indique qu'une exécution partielle a eu lieu (par exemple, une condition `if` vraie a été testée, mais le cas `else` ne l'a pas été).

Vert : La ligne a été complètement exécutée pendant les tests.

V. Objectifs de Couverture de Code
9. Quels sont les objectifs de couverture de code que vous avez définis pour votre projet ? Pour un projet de bibliothèque, un objectif raisonnable est de viser 80% de couverture des instructions et 90% de couverture des branches pour la classe `Livre`.

10. Comment ajusteriez-vous ces objectifs en fonction des besoins du projet ?

Pour des modules critiques (par exemple, des calculs financiers ou la validation de sécurité), l'objectif de couverture pourrait être porté à 95-100%.

Pour les classes générées automatiquement ou les classes comportant uniquement des getters/setters, la couverture pourrait être réduite, voire exclue du rapport.

La balise `<check>` de JaCoCo permet de faire échouer le build (BUILD FAILURE) si les seuils de couverture ne sont pas atteints.

VI. Scénarios de Tests pour Améliorer la Couverture
11. Proposez des scénarios de tests spécifiques pour améliorer la couverture. Dans la classe `Livre`, pour atteindre une couverture de 100%, il est nécessaire de tester :

Les limites : Tester l'année 1000 et l'année en cours pour couvrir les conditions `>=` et `<=`.

Les exceptions : Tester les années antérieures à 1000, les années futures et le cas où la date est `null`.

Les méthodes annexes : Tester des méthodes comme `toString()`, `getAuteur()`, etc.

12. Comment JaCoCo peut vous aider à identifier les parties du code nécessitant des tests supplémentaires ? En observant la colonne "Missed Branches", JaCoCo permet d'identifier les branches de code non couvertes. Par exemple, si l'on voit "1 of 2 branches missed" dans un bloc `if (date == null)`, cela signifie que le test a couvert le cas où la date est nulle, mais n'a pas testé le cas où la date est valide (ou inversement).

VII. Exemples de Rapports JaCoCo
13. Présentez un exemple de rapport et expliquez l'interprétation. Un rapport typique montre un tableau avec des couleurs représentant la couverture du code. Par exemple, si la ligne de la classe `Livre` affiche une barre rouge à 50% sous "Instructions", cela signifie que la moitié du code de cette classe n'a pas été exécutée par les tests.

14. Quelles sont les sections clés d'un rapport JaCoCo ?

- **Session Info** : Indique quand et sur quelle machine les tests ont été exécutés.
- **Package View** : Vue d'ensemble de la couverture par dossier.
- **Class View** : Vue des métriques de couverture par classe.
- **Source View** : Code source coloré, utile pour identifier les lignes non couvertes et déboguer.

VIII. Intégration avec un Système d'Intégration Continue (CI)
15. Comment intégreriez-vous JaCoCo dans un système CI (par exemple, Jenkins) ? Dans un pipeline Jenkins ou GitHub Actions, voici les étapes :

- Le serveur CI récupère le code source (`git checkout`).
- Il exécute la commande `mvn clean test` (JaCoCo génère alors un rapport XML/HTML).
- Un plugin JaCoCo (ex: JaCoCo Plugin pour Jenkins) lit le rapport XML généré.
- Le serveur CI affiche un graphique de tendance de la couverture. Si la couverture chute de manière significative par rapport au commit précédent, le build peut être marqué comme "Instable" ou la mise en production peut être bloquée.

IX. Réflexion sur la Couverture de Code
16. Comment la couverture de code vous aide-t-elle à garantir la qualité de votre code ? La couverture de code quantifie la "confiance" que l'on peut avoir dans l'application. Bien qu'elle ne prouve pas que le code est exempt de bugs, elle garantit que le code a été testé au moins une fois, ce qui réduit le risque d'erreurs. Elle permet aussi d'éviter le déploiement de code "mort" ou de logique non testée.

17. Quels types de bugs ou lacunes pensez-vous identifier en examinant les rapports ?

- **Conditions inatteignables** : Si un bloc de code reste rouge malgré de nombreux tests, cela pourrait indiquer que cette partie du code est logiquement inaccessible (code mort).
- **Oubli de gestion d'erreurs** : Les blocs `catch` peuvent rester rouges si les erreurs ne sont pas simulées pendant les tests (oubli de tests d'exception).

X. Récapitulatif et Améliorations
18. Proposez des idées d'amélioration de l'utilisation de JaCoCo.

- **Règles de validation automatiques** : Configurer le fichier `pom.xml` pour empêcher l'exécution de `mvn install` si la couverture descend en dessous de 80%.
- **Exclusions intelligentes** : Exclure les classes de test elles-mêmes ou les configurations spécifiques (par exemple, Spring Boot) de la couverture.
- **Mutation Testing** : Intégrer JaCoCo avec un outil comme **Pitest**. Tandis que JaCoCo vérifie que le code est exécuté, Pitest s'assure que les tests peuvent détecter un bug en introduisant volontairement des erreurs dans le code.
*/
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}