
# LabXpert - l'API REST via Spring Boot

Le laboratoire médical TechLab a besoin d'une application de gestion, LabXpert, pour optimiser ses opérations en améliorant l'efficacité et la précision dans le traitement des analyses médicales.

## Contexte du projet
Le laboratoire médical TechLab souhaite mettre en place un système de gestion complet pour optimiser ses opérations.
L'objectif principal est d'améliorer l'efficacité et la précision dans le traitement des analyses médicales. Le système doit couvrir divers aspects de la gestion, du suivi des échantillons à la gestion des résultats. La transition vers ce système aidera TechLab à fournir un service plus rapide et plus précis à ses patients.

### Fonctionnalités du Système de Gestion du Laboratoire "LabXpert"

#### 1. Enregistrement des Échantillons :
- Les techniciens peuvent enregistrer de nouveaux échantillons en spécifiant les informations pertinentes telles que le patient, le type d'analyse et la date de prélèvement.

#### 2. Suivi des Analyses en Cours :
  - Une interface conviviale permet aux techniciens et aux responsables de laboratoire de suivre en temps réel l'état d'avancement des analyses en cours, avec des détails spécifiques pour chaque échantillon.

#### 3. Gestion des Résultats :
   - Les résultats des analyses sont consignés de manière systématique, permettant un accès rapide aux informations et la possibilité de partager les résultats avec les professionnels de la santé concernés.

#### 4. Gestion des Patients :
   - Un  module dédié offre la possibilité de gérer les informations relatives aux patients, assurant une centralisation des données et une navigation facilitée.

#### 5. Inventaire des Réactifs et Outils de travail :
   - Intégration d'un suivi des stocks pour garantir la disponibilité des réactifs nécessaires aux différentes analyses.

#### 6. Gestion des Utilisateurs :
  - Une interface d'administration permet de gérer les droits d'accès et les informations des utilisateurs, assurant une sécurité accrue des données.

#### 7. Planification des Analyses :
   - Possibilité de planifier les analyses en fonction de la charge de travail, optimisant ainsi l'utilisation des ressources du laboratoire.

#### 8. Rapports Statistiques :
   - Génération de rapports statistiques pour évaluer les performances du laboratoire, identifier les tendances et prendre des décisions basées sur les données.


### Stack Technique de l'Application "LabXpert" :
​
Langage de Programmation : Java <br/>
Backend : Spring boot API RESTful <br/>
Gestion de Dépendances : Apache Maven <br/>
Base de Données : PostgreSQL <br/>
Serveur d'Application : Apache Tomcat <br/>
Testing : JUnit & Mockito <br/>
CICD : Jenkins <br/>
Gestion des tâches : Trello <br/>
Système de Gestion de Version : Git et Github <br/>
Documentation dl'API : SWAGGER <br/>
Logging : Log4j pour la gestion des journaux <br/>

### Conception UML
#### Diagramme de UseCase:

![diagramm UseCase](https://github.com/mohatala/LabXpert-Rest-API/blob/master/conception/UseCase%20LabXpert.drawio.png)

#### Diagramme de Classes:

![diagramm Classes](https://github.com/mohatala/LabXpert-Rest-API/blob/master/conception/Classe%20LabXpert.drawio.png)

