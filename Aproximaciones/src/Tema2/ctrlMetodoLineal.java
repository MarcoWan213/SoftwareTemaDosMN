package tema2;

import java.util.ArrayList;
import java.util.Arrays;

public class ctrlMetodoLineal {

    public tblJacobi Jacobi(double[][] ecua, int iteraMaxima, double errorDesea) {

        ArrayList<CsJacobi> lista = null;
        tblJacobi tabla;
        double[][] M;
        int iteraccion = 0;
        double error = errorDesea;
        int n = ecua.length;
        double[] X = new double[n]; // Approximations
        double[] P = new double[n]; // Prev

        Arrays.fill(X, 0);
        Arrays.fill(P, 0);

        lista = new ArrayList<CsJacobi>();

        while (true) {
            CsJacobi fila = new CsJacobi();
            for (int i = 0; i < n; i++) {
                double sum = ecua[i][n]; // b_n
                for (int j = 0; j < n; j++) {
                    if (j != i) {
                        sum -= ecua[i][j] * P[j];
                    }
                }
                X[i] = 1 / ecua[i][i] * sum;
            }

            fila.setResultados(X);
            
            for (int i = 0; i < n; i++) {
                System.out.print(X[i] + " ");

            }
            System.out.println("}");

            

            iteraccion++;
            if (iteraccion == 1) {
                continue;
            }

            boolean stop = true;
            for (int i = 0; i < n && stop; i++) {
                if (Math.abs(X[i] - P[i]) > error) {
                    stop = false;
                }
            }

            if (stop || iteraccion == iteraMaxima) {
                break;
            }

            P = (double[]) X.clone();

            tabla = new tblJacobi(lista);
            return tabla;
        }

        return null;
    }

    public static void main(String[] args) {
        ctrlMetodoLineal prueba = new ctrlMetodoLineal();

        double[][] x = new double[4][5];

        x[0][0] = 10;
        x[0][1] = -1;
        x[0][2] = 2;
        x[0][3] = 0;
        x[0][4] = 6;

        x[1][0] = -1;
        x[1][1] = +11;
        x[1][2] = -1;
        x[1][3] = 3;
        x[1][4] = 25;

        x[2][0] = 2;
        x[2][1] = -1;
        x[2][2] = 10;
        x[2][3] = -1;
        x[2][4] = -11;

        x[3][0] = 0;
        x[3][1] = -3;
        x[3][2] = -1;
        x[3][3] = 8;
        x[3][4] = 15;

        prueba.Jacobi(x, 50, 1e-15);

    }

}
