package tema2;

import java.util.ArrayList;

public class CtrlMetodos {

    public tblBiseccion Biseccion(double li, double ls, double error, int iteraciones) {
        ArrayList<CsBiseccion> lista = null;
        tblBiseccion tabla;
        double fxi;
        double errorcalculado = 1;
        double fxs;
        int iteracion = 0;
        double xAnterior;
        fxi = this.getFx(li);
        fxs = this.getFx(ls);

        if ((fxi * fxs) < 0) {
            lista = new ArrayList<CsBiseccion>();
            while (errorcalculado > error && iteraciones > 0) {
                CsBiseccion fila = new CsBiseccion();
                fila.setInteracion(iteracion + 1);
                fila.setXi(li);
                fila.setXs(ls);
                fila.setXr((fila.getXi() + fila.getXs()) / 2);
                fila.setFxi(this.getFx(fila.getXi()));
                fila.setFxr(this.getFx(fila.getXr()));
                fila.setProducto(fila.getFxi() * fila.getFxr());

                if (fila.getProducto() > 0) {
                    errorcalculado = this.errorRelativo(li, ls);
                    xAnterior = li;
                    li = fila.getXr();
                } else {
                    xAnterior = ls;
                    ls = fila.getXr();
                }
                fila.setError(errorcalculado);
                fila.toString();
                lista.add(fila);
                iteracion++;
            }
            tabla = new tblBiseccion(lista);
            return tabla;
        } else {
            return null;
        }
    }

    public tblSecante Secante(double xi1, double xi, double error, int iteraciones) {
        ArrayList<CsSecante> lista = null;
        tblSecante tabla;
        double fxi1;
        double errorc = 1;
        double fxi;
        int iteracion = 0;
        fxi1 = getFxi(xi1);
        fxi = getFxi(xi);
        lista = new ArrayList<CsSecante>();
        while (errorc > error && iteraciones > 0) {
            CsSecante fila = new CsSecante();
            fila.setInteracion(iteracion + 1);
            fila.setXi1(xi1);
            fila.setXi(xi);
            fila.setFxi1(this.getFxi(fila.getXi1()));
            fila.setFxi(this.getFxi(fila.getXi()));
            fila.setN(fila.getFxi() * (fila.xi1 - fila.xi));
            fila.setD(fila.getFxi1() - fila.getFxi());
            fila.setXi1r(fila.getXi() - (fila.getN() / fila.getD()));
            if (fila.getError() < 0) {
                errorc = this.errorRelativo(fila.getXi1r(), fila.getXi());

                xi1 = fila.getXi();
                xi = fila.getXi1r();
            } else {
                errorc = this.errorRelativo(fila.getXi1r(), fila.getXi());
                xi1 = fila.getXi();
                xi = fila.getXi1r();
            }
            fila.setError(errorc);
            lista.add(fila);
            iteracion++;
        }
        tabla = new tblSecante(lista);
        return tabla;
    }

    private double getFxi(double x) {
        return (Math.exp(-(x))) - x;
    }

    private double getFx(double x) {
        return ((9.8 * 68.1) / x) * (1 - Math.exp(-(x / 68.1) * 10)) - 40;
    }

    private double errorRelativo(double xActual, double xAnterior) {
        return Math.abs((xActual - xAnterior) / xActual);
    }

    public String Newton(double aprox, double errorDeseado, int iteracionDeseada) {

        ArrayList<Tema2.CsNewton> lista = null;
        int interacion = 0;
        double fi;
        double fix;
        double tim;
        double error = 1;
        lista = new CsNewton<>();

        while (error > errorDeseado && interacion < iteracionDeseada) {

            Tema2.CsNewton fila = new CsNewton();
            fila.setFi(this.getfiN(aprox));
            fila.setFix(this.getfipN(aprox));
            fila.setTim(this.gettimN(aprox, fila.getFi(), fila.getFix()));
            fila.setError(this.geterrorN(aprox, fila.getTim()));
            fila.setInteracion(interacion+1);
            
            fi = this.getfiN(aprox);
            fix = this.getfipN(aprox);
            tim = this.gettimN(aprox, fi, fix);
            error = this.geterrorN(aprox, tim);
            
            lista.add(fila);
            
            interacion++;
        }

        return "";
    }

    public double getfiN(double aprox) {
        return (80 * (Math.exp(-2 * aprox))) - 11;
    }

    public double getfipN(double aprox) {
        return (-160 * (Math.exp(-2 * aprox))) - 11;
    }

    public double gettimN(double aprox, double fi, double fip) {
        return aprox - (fi / fip);
    }

    public double geterrorN(double aprox, double tim) {
        return (tim - aprox) / tim;
    }
}
