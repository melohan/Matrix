# Matrix
HEIG Project 2020 POO1

Ce programme met en œuvre l'application d'opérations arithmétiques( termes à termes) entre 2 matrices.

Le programme donne la possibilité de créer des matrices de dimensions quelconques (NxM) de contenu modulo n.

Le programme permet :
- la création de matrice, soit d'après un tableau de valeurs déjà existant, soit en spécifiant ses dimensions. Auquel cas, la matrice sera remplie de valeurs aléatoires entre 0 et n-1.
- l’affichage de la matrice.
- d’effectuer les opérations arithmétiques suivantes : addition, soustraction et multiplication entre 2 matrices.  Le résultat d'une opération est sous la forme d'une nouvelle matrice.

Remarque : 

Les opérations ne sont pas à proprement parler matricielles car elles s'effectuent terme par terme et s’affranchissent des contraintes de dimensions mathématiques.
Si l’on effectue une des 3 opérations sur une matrice A et B non vide de dimension arbitraires, les dimensions de la matrice résultante sera le maximum de ligne et de colonne soit max(Na, Nb) x max(Ma, Mb). Les valeurs manquantes seront remplacées quant à elles par 0.
Des exceptions de type RuntimeException sont levées en cas d'erreur ou si le modulo n des 2 matrices ne correspondent pas.

## Auteurs

- Dylan Canton
- Mélodie Ohan


## Classes

### Main.java

Contient le fichier de présentation des résultats. Lorsque le programme est lancé on dispose d'un ensemble d'exemples d'opérations entre deux matrices ainsi que leurs résultats.


### Matrix.java

La classe Matrix permet de gérer la création et l'affichage de matrices ainsi que d'effectuer des opérations arithmétiques entre 2 matrices.


### Oeration.java

La classe Operation est une classe abstraite, elle permet de définir une méthode calculate pour les différentes opérations (Addition, Soustraction, Multiplication).
Il a été décidé de représenter chaque opération sous forme d'une classe, permettant ainsi une meilleure évolutivité pour rajouter des opérations dans le futur.
Toutes les opérations s'effectuent modulo n.

###	Add
La classe Add permet d'additionner 2 matrices.

###	Sub
La classe Sub permet de soustraire terme à terme la valeur de 2 matrices. 	Les cas de résultat négatif sont gérés.

###	Mult
La classe Mult permet de multiplier 2 matrices. La multiplication s'effectue composante par composante donc C(i,j) = A(i,j)  * B(i,j) où C défini la matrice de résultat et A,B les matrices à multiplier. 
