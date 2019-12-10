# TPResto
API REST JAVA RESTLET

# Découverte

Pour générer le JAR de l'application, allez à la racine du projet (où se trouve le fichier 'pom.xml') et entrez la commande mvn package

Vous pouvez maintenant lancer le serveur avec la commande java -jar uber-TP5Resto-0.0.1.jar lancé depuis l'intérieur du répertoire 'target'.

## Recaputilons :
#### racine> mvn package
#### target> java -jar uber-TP5Resto-0.0.1.jar

Le serveur doit maintenant tourner, et être prêt à recevoir vos requêtes. Vous pouvez essayez les requêtes suivantes, que vous pouvez lancer depuis un autre terminal pour afficher l'état du buffet et l'état des clients


#### $ curl http://localhost:8124/buffet : //lister la qté restantes dans chaque buffet
#### $ curl http://localhost:8124/client/2  : //affiche l'état d'un client
 