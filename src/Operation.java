
import java.lang.Math; //Math.floorMod

/**
 * Classe abstraite operation, permet de définir la méthode calculate pour les classes qui en
 * héritent
 *
 * @author  Canton Dylan, Ohan Mélodie
 * @version 1.0
 */
public abstract class Operation {

    /**
     * Prototype de méthode de calcule.
     *
     * @since         1.0
     * @param a       Operande gauche
     * @param b       Operande droite
     * @param mod     Modulo de la matrice
     * @return        Resultat de l'opération entre a et b en base mod
     */
    public abstract int calculate(int a, int b, int mod);
}

/**
 * Classe Add, permet d'effectuer une addition.
 *
 * @see     Operation
 * @author  Canton Dylan, Ohan Mélodie
 * @version 1.0
 */
class Add extends Operation{

    /**
     * Effectue la somme de a et b et n'excède pas la base mod.
     *
     * @since         1.0
     * @param a       Operande gauche
     * @param b       Operande droite
     * @param mod     Modulo de la matrice
     * @return        Resultat de la somme entre a et b en base mod
     */
    public int calculate(int a, int b, int mod){
        return (a + b) % mod;
    }
}

/**
 * Classe Sub, permet d'effectuer une soustraction.
 *
 * @see     Operation
 * @author  Canton Dylan, Ohan Mélodie
 * @version 1.0
 */
class Sub extends Operation{

    /**
     * Effectue la soustraction entre a et b en base mod.
     *
     * @since         1.0
     * @param a       Operande gauche
     * @param b       Operande droite
     * @param mod     Modulo de la matrice
     * @return        Resultat de la différence entre a et b en base mod mathématique
     */
    public int calculate(int a, int b, int mod){
        if(a - b < 0){
            return Math.floorMod( ((a - b) % mod), mod);
        }
        return (a - b) % mod;
    }
}

/**
 * Classe Mult, permet d'effectuer une multiplication.
 *
 * @see     Operation
 * @author  Canton Dylan, Ohan Mélodie
 * @version 1.0
 */
class Mult extends Operation{

    /**
     * Effectue la multiplication entre a et b en base mod.
     *
     * @since         1.0
     * @param a       Operande gauche
     * @param b       Operande droite
     * @param mod     Modulo de la matrice
     * @return        Resultat du produit entre a et b en base mod.
     */
    public int calculate(int a, int b, int mod){
        return (a * b) % mod;
    }
}