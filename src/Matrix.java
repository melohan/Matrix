
import java.lang.Math; //Math.random

/**
 * Classe Matrix, faisant office d'interface permettant des opérations arithmétiques entre 2
 * matrices.
 *
 * @author  Canton Dylan, Ohan Mélodie
 * @see     Operation
 * @version 1.0
 */
public class Matrix {

    private int [][] values;        // la matrice manipulée (tableau 2D)
    private int      mod;           // modulo / base n de la matrice
    private int      row;
    private int      col;

    private static final String
      EXCEPT_MODULO        = "Modulo must be > 0 !",
      EXCEPT_DIMENSION     = "Matrix dimension can't  be null !",
      EXCEPT_DEVIANT       = "This matrix is degenerate !",
      EXCEPT_MATRIX_VALUES = "Matrix values must be lower than the modulo and higher than 0 !",
      EXCEPT_DIFFERENT_MOD = "The modulos are different !";

    /**
     * Retourne le modulo, la base de la matrice
     *
     * @since     1.0
     * @return    mod
     */
    public int getModulo() {
        return this.mod;
    }

    /**
     * Initialisation de la taille d'une matrice
     *
     * @throws    RuntimeException si n et m < 0 ou si mod <= 0
     * @since     1.0
     * @param n   nombre de lignes
     * @param m   nombre de colonnes
     * @param mod modulo / base de la matrice
     */
    private void init(int n, int m, int mod) throws RuntimeException{

        if(n <= 0 || m <= 0)
            throw new RuntimeException(EXCEPT_DIMENSION);

        if(mod <= 0)
            throw new RuntimeException(EXCEPT_MODULO);

        this.row    = n;
        this.col    = m;
        this.mod    = mod;
        this.values = new int[n][m];
    }

    /**
     * Constructeur avec nombres aléatoires
     *
     * @see       init
     * @throws    RuntimeException par l'intermédiaire de init
     * @since     1.0
     * @param n   nombre de lignes
     * @param m   nombre de colonnes
     * @param mod modulo de la matrice
     */
    Matrix(int n, int m, int mod) throws RuntimeException{

        init(n, m, mod);

        int max     = mod - 1;
        int min     = 0;
        int range   = max - min + 1;

        for(int i = 0; i < this.row; ++i)
            for(int j = 0; j < this.col; ++j)
                values[i][j] = (int)(Math.random() * range) + min;
    }

    /**
     * Constructeur avec tableau
     *
     * @see       init
     * @throws    RuntimeException par l'intermédiaire de init
     * @since     1.0
     * @param tab matrice
     * @param mod modulo
     */
    Matrix(int [][] tab, int mod) throws RuntimeException{

        int n = tab.length;
        int m = (n != 0) ? tab[0].length : 0;     // Cas des matrices 2D déclarées 1d

        init(n, m, mod);

        for(int i = 0; i < values.length; ++i){

            // Si la matrice est dégénérée
            if(tab[i].length != values[0].length)
                throw new RuntimeException(EXCEPT_DEVIANT);

            for(int j = 0; j < values[0].length; ++j){

                // Si les valeurs ne sont pas entre 0 et mod-1
                if(tab[i][j] < 0 || tab[i][j] >= mod)
                    throw new RuntimeException(EXCEPT_MATRIX_VALUES);

                values[i][j] = tab[i][j];
            }
        }
    }

    /**
     * Formate le contenu de la matrice en string
     *
     * @since     1.0
     * @return    string de la matrice
     */
    public String toString(){

        String result = "";

        for(int i = 0; i < this.row; ++i){
            for(int j = 0; j < this.col ; ++j){
                result += values[i][j];
                result += " ";
            }
            result += "\n";
        }

        return result;
    }

    /**
     * Retourne la valeur de la matrice à la case (x,y) ou zéro si cette case n'existe pas.
     *
     * @since     1.0
     * @param x   ligne no
     * @param y   colonne no
     * @return    la valeur à cette case où zéro si rien ne s'y trouve
     */
    private int getValueAt(int x, int y){
        return ( x > this.row-1 || y > this.col-1 ) ? 0 : this.values[x][y];
    }

    /**
     * Applique l'opération op entre les cases de la matrice courante (this) et other.
     *
     * @since        1.0
     * @throws       RuntimeException si les mod des matrices sont différents
     * @param  other l'autre matrice
     * @param  op    opération à appliquer
     * @return       matrice des résultats
     *
     * - Si une case n'existe pas sur l'une des deux matrices, l'opérations sera effectué sur
     *   la valeur 0.
     * - La matrice des résultats est aux dimensions
     *   max(nbre col1,nbre col2) × max(nbre ligne1, nbre ligne2)
     */
    public Matrix operation(Matrix other, Operation op) throws RuntimeException{

        if(this.mod != other.mod)
            throw new RuntimeException(EXCEPT_DIFFERENT_MOD);

        int nMax = Math.max(this.row, other.row);
        int mMax = Math.max(this.col, other.col);

        Matrix result = new Matrix(nMax,mMax,mod);

        for(int i = 0; i < result.row; ++i)
            for(int j = 0; j < result.col; ++j)
                result.values[i][j] = op.calculate(this.getValueAt(i,j),
                                       other.getValueAt(i,j), this.mod);

        return result;
    }
}