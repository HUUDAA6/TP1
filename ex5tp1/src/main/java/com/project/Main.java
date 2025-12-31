package com.project;
/*
3. Pourquoi est-il important de gérer les exceptions dans une application qui interagit avec des fichiers ?
L'interaction avec le système de fichiers est intrinsèquement imprévisible. Le programme n'a pas le contrôle total sur l'environnement externe.

Le fichier peut être supprimé par un autre utilisateur.

Le disque peut être plein.

L'application peut ne pas avoir les permissions de lecture. Si ces cas ne sont pas gérés (via try-catch ou propagation), l'application plantera brutalement, ce qui offre une mauvaise expérience utilisateur et peut entraîner des pertes de données.

4. Différence entre exception vérifiée et non vérifiée ? Pourquoi IOException est vérifiée ?
Exception vérifiée (Checked Exception) : Ce sont des exceptions que le compilateur vous oblige à traiter (soit via try-catch, soit en déclarant throws). Elles représentent des conditions d'erreur externes et récupérables.

Exception non vérifiée (Unchecked Exception) : Ce sont des erreurs de programmation (comme NullPointerException). Le compilateur n'oblige pas à les traiter.

Pourquoi IOException est vérifiée ? Parce que l'existence ou l'accessibilité d'un fichier dépend de facteurs externes au code. Le compilateur oblige le développeur à prévoir le cas où "le monde extérieur ne répond pas comme prévu" pour garantir la robustesse du programme.

5. Avantages de l’intégration des tests avec Maven ?
Automatisation : Maven exécute automatiquement tous les tests avec la commande mvn test. On ne risque pas d'oublier d'en lancer un.

Standardisation : Maven impose une structure standard (src/test/java). N'importe quel développeur Java sait où trouver les tests.

Intégration Continue (CI) : Les outils comme Jenkins ou GitHub Actions utilisent Maven pour lancer les tests automatiquement à chaque modification du code, empêchant les régressions.

6. Méthode pour tester la lecture de fichiers volumineux ou corrompus ?
Pour ces cas limites, il est déconseillé d'utiliser de vrais fichiers de 10 Go dans le dossier du projet. On utilise plutôt des techniques de Mocking (simulation) :

Fichiers volumineux : Au lieu de créer un vrai gros fichier, on peut mocker la classe InputStream ou utiliser un framework comme Mockito pour simuler un flux de données infini ou très long sans occuper d'espace disque. On vérifie que la méthode lit par blocs (buffer) et ne charge pas tout en mémoire (pour éviter OutOfMemoryError).

Fichiers corrompus/Illisibles :

On peut créer un fichier temporaire et modifier ses permissions système (ex: file.setReadable(false)) avant d'appeler la méthode de lecture pour vérifier que l'exception AccessDeniedException est bien gérée.

On peut écrire des octets binaires aléatoires dans un fichier texte et vérifier comment le Charset (encodage) gère les caractères invalides
 */
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello, World!");
    }
}