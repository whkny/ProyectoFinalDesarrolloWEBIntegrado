package modelo;
public class Notas {
 private String codc;
 private String nomcur;
 private int exp;
 private int exf;
 public double prom(){
     return (exp+exf)/2.0;
 }
 public String Obser(){
     return prom()>=11.5?"Aprobado":"Desaprobado";
 }

    public String getCodc() {
        return codc;
    }

    public void setCodc(String codc) {
        this.codc = codc;
    }

    public String getNomcur() {
        return nomcur;
    }

    public void setNomcur(String nomcur) {
        this.nomcur = nomcur;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getExf() {
        return exf;
    }

    public void setExf(int exf) {
        this.exf = exf;
    }
 
}
