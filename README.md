# TPResto
API REST JAVA RESTLET

# D�couverte

Pour g�n�rer le JAR de l'application, allez � la racine du projet (o� se trouve le fichier 'pom.xml') et entrez la commande mvn package

Vous pouvez maintenant lancer le serveur avec la commande java -jar uber-TP5Resto-0.0.1.jar lanc� depuis l'int�rieur du r�pertoire 'target'.

## Recaputilons :
#### racine> mvn package
#### target> java -jar uber-TP5Resto-0.0.1.jar

Le serveur doit maintenant tourner, et �tre pr�t � recevoir vos requ�tes. Vous pouvez essayez les requ�tes suivantes, que vous pouvez lancer depuis un autre terminal pour afficher l'�tat du buffet et l'�tat des clients


#### $ curl http://localhost:8124/buffet : //lister la qt� restantes dans chaque buffet
#### $ curl http://localhost:8124/client/2  : //affiche l'�tat d'un client
 