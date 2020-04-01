
package tema2;


public class CsNewton {
    int interacion;
    double aprox,fi,fix,tim,error;

    public double getTim() {
        return tim;
    }

    public void setTim(double tim) {
        this.tim = tim;
    }
    

    public int getInteracion() {
        return interacion;
    }

    public void setInteracion(int interacion) {
        this.interacion = interacion;
    }

    public double getAprox() {
        return aprox;
    }

    public void setAprox(double aprox) {
        this.aprox = aprox;
    }

    public double getFi() {
        return fi;
    }

    public void setFi(double fi) {
        this.fi = fi;
    }

    public double getFix() {
        return fix;
    }

    public void setFix(double fix) {
        this.fix = fix;
    }

    public double getError() {
        return error;
    }

    public void setError(double error) {
        this.error = error;
    }

    @Override
    public String toString() {
        return "CsNewton{" + "interacion=" + interacion + ", aprox=" + aprox + ", fi=" + fi + ", fix=" + fix + ", error=" + error + '}';
    }
    
    

}
