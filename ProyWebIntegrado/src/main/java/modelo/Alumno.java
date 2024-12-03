
package modelo;

public class Alumno extends Notas{
    private String coda;
    private String noma;
    private String ape;
    private String code;
    private String pro;

    public Alumno() {
    }

    public Alumno(String coda, String noma, String ape, String code, String pro) {
        this.coda = coda;
        this.noma = noma;
        this.ape = ape;
        this.code = code;
        this.pro = pro;
    }
    
    
    public String getCoda() {
        return coda;
    }

    public void setCoda(String coda) {
        this.coda = coda;
    }

    public String getNoma() {
        return noma;
    }

    public void setNoma(String noma) {
        this.noma = noma;
    }

    public String getApe() {
        return ape;
    }

    public void setApe(String ape) {
        this.ape = ape;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getPro() {
        return pro;
    }

    public void setPro(String pro) {
        this.pro = pro;
    }
    
}
