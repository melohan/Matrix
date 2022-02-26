/** *******************************************************************************************
 * Laboratoire 5
 * Fichier          Main.java
 * Auteur(s)        Canton Dylan, Ohan Mélodie
 * Date             16/10/2020
 *
 * Description      Programme de test de l'application
 *
 * Remarques        La plupart des exceptions sont commentées afin de permettre une bonne
 *                  execution du programme, il est nécessaire de les décommenter pour les
 *                  vérifier.
 *
 * *******************************************************************************************/

public class Main {

    public static void main(String[] argsja) {

        System.out.println("Tests avec matrice pre-cree");
        System.out.println("--------------------------------------------------------------\n");

        // ************************************** Test 1  ********************************** //

        System.out.println("Test 1 - Reprise de la demo.");
        System.out.println("--------------------------");

        int[][] arr1  = {{1,3,1,1},{3,2,4,2},{1,0,1,0}};
        int[][] arr2  = {{1,4,2,3,2},{0,1,0,4,2},{0,0,2,0,2}};
        int     mod12 = 5;

        Matrix m1 = new Matrix(arr1, mod12);
        Matrix m2 = new Matrix(arr2, mod12);

        System.out.print("Matrice: m1 de modulo ");
        System.out.print(m1.getModulo());
        System.out.print("\n");

        System.out.println(m1.toString());

        System.out.print("Matrice: m2 de modulo ");
        System.out.print(m2.getModulo());
        System.out.print("\n");

        System.out.println(m2.toString());

        System.out.println("Matrice: m1+m2");
        System.out.println(m1.operation(m2,new Add()).toString());

        System.out.println("Matrice: m1-m2");
        System.out.println(m1.operation(m2,new Sub()).toString());

        System.out.println("Matrice: m1*m2");
        System.out.println(m1.operation(m2,new Mult()).toString());

        // ************************************** Test 2  ********************************** //

        System.out.println("Test 2 - base binaire");
        System.out.println("--------------------------");

        int[][] arr3 = {{1,0},{0,1},{1,0},{0,1}, {1,0}};
        int[][] arr4 = {{1,0,0,1,0,0}};
        int mod34 = 2;

        Matrix m3 = new Matrix(arr3, mod34);
        Matrix m4 = new Matrix(arr4, mod34);

        System.out.print("Matrice: m3 de modulo ");
        System.out.print(m3.getModulo());
        System.out.print("\n");

        System.out.println(m3.toString());

        System.out.print("Matrice: m4 de modulo ");
        System.out.print(m4.getModulo());
        System.out.print("\n");

        System.out.println(m4.toString());

        System.out.println("Matrice: m3+m4");
        System.out.println(m3.operation(m4,new Add()).toString());

        System.out.println("Matrice: m3-m4");
        System.out.println(m3.operation(m4,new Sub()).toString());

        System.out.println("Matrice: m3*m4");
        System.out.println(m3.operation(m4,new Mult()).toString());

        System.out.print("\n");

        // ************************************** Test 3  ********************************** //

        System.out.println("Test 3: Operations sur matrices de module different");
        System.out.println("--------------------------");

        int[][] arr5 = {{1,0}};
        int[][] arr6 = {{9,0,5,1,0,3}};

        int mod5 = 2;
        int mod6 = 10;

        Matrix m5 = new Matrix(arr5, mod5);
        Matrix m6 = new Matrix(arr6, mod6);

        System.out.print("Matrice: 5 de modulo ");
        System.out.print(m5.getModulo());
        System.out.print("\n");

        System.out.println(m5.toString());

        System.out.print("Matrice: 6 de modulo ");
        System.out.print(m6.getModulo());
        System.out.print("\n");

        System.out.println(m6.toString());

        System.out.println("Matrice: m5+m6");
        // System.out.println(m5.operation(m6,new Add()).toString());

        System.out.println("Matrice: m5-m6");
        // System.out.println(m5.operation(m6,new Sub()).toString());

        System.out.println("Matrice: m5*m6");
        // System.out.println(m5.operation(m6,new Mult()).toString());

        System.out.print("\n");

        // ************************************** Test 4  ********************************** //

        System.out.println("Test 4: Generation de matrice aleatoire et operations");
        System.out.println("--------------------------");

        int mod78 = 10;

        Matrix m7 = new Matrix(2,3, mod78);
        Matrix m8 = new Matrix(3,2, mod78);

        System.out.print("Matrice: 7 de modulo ");
        System.out.print(m7.getModulo());
        System.out.print("\n");

        System.out.println(m7.toString());

        System.out.print("Matrice: 8 de modulo ");
        System.out.print(m8.getModulo());
        System.out.print("\n");

        System.out.println(m8.toString());

        System.out.println("Matrice: m7+m8");
        System.out.println(m7.operation(m8,new Add()).toString());

        System.out.println("Matrice: m7-m8");
        System.out.println(m7.operation(m8,new Sub()).toString());

        System.out.println("Matrice: m7*m8");
        System.out.println(m7.operation(m8,new Mult()).toString());


        // ************************************** Test 5  ********************************** //

        System.out.println("Tests sur des matrices aux dimensions et/ou modulo interdits");
        System.out.println("--------------------------------------------------------------\n");


        System.out.println("Test 5: new Matrix(0,0,0)");
        System.out.println("--------------------------");

        // Matrix m9 = new Matrix(0,0,0);

        // ************************************** Test 6  ********************************** //

        System.out.println("Test 6: new Matrix(0,1, 7)");
        System.out.println("--------------------------");

        // Matrix m10 = new Matrix(0,1, 7);

        // ************************************** Test 7  ********************************** //

        System.out.println("Test 7: new Matrix(1,0, 3)");
        System.out.println("--------------------------");

        // Matrix m11 = new Matrix(1,0, 3);

        // ************************************** Test 8  ********************************** //

        System.out.println("Test 8: new Matrix(1,1, 0)");
        System.out.println("--------------------------");;

        // Matrix m12 = new Matrix(1,1, 0);


        // ************************************** Test 9  ********************************** //

        System.out.println("\nTests sur une matrice definies vide");
        System.out.println("--------------------------------------------------------------\n");

        System.out.println("Test 9:   int[][] arr13 = {{}}, new Matrix(arr13 ,1)");
        System.out.println("--------------------------");;

        int[][] arr13 = {{}};
        Matrix m13 = new Matrix(arr13 ,1);

        // ************************************** Test 10  ********************************* //

        System.out.println("Test 10:  int[][] arr14 = {}, new Matrix(arr14 ,1)");
        System.out.println("--------------------------");;

        int[][] arr14 = {};
        // Matrix m14= new Matrix(arr14 ,1);

        // ************************************** Test 11  ********************************* //

        System.out.println("Test 11:  int[][] arr15 = {}, new Matrix(arr15 ,0))");
        System.out.println("--------------------------");;

        int[][] arr15 = {};
        // Matrix  m15= new Matrix(arr15 ,0);

        // ************************************** Test 12  ********************************* //

        System.out.println("\nTests sur des valeurs hors range");
        System.out.println("--------------------------------------------------------------\n");

        System.out.println("Test 12 : valeurs negatives ");
        System.out.println("--------------------------");;

        int[][] arr16 = {{-1,-15,1}};
        // Matrix m16= new Matrix(arr16 ,16);

        // ************************************** Test 13  ********************************* //

        System.out.println("Test 13 : valeurs supperieur au modulus ");
        System.out.println("--------------------------");;

        int[][] arr17 = {{1,0,1}, {150, 1500, 40}};
        // Matrix m17= new Matrix(arr17 ,20);

        // ************************************** Test 14  ********************************* //

        System.out.println("Test 14 : Matrice irreguliere ");
        System.out.println("--------------------------");;

        int[][] arr18 = {{1,0}, {1, 2, 2}};
        // Matrix  m18   = new Matrix(arr18 ,3);
    }
}