
package manegbean;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import modelo.*;
import dao.Negocio;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;
@ManagedBean
@ViewScoped
public class control1 implements Serializable {
private Alumno alu;
private List<Alumno> lisalu;
private List<Pagos> lispago;
private String nombre;
private double total;
private String texto;
private Especial  esp;
private List<SelectItem> lisesp;
    public control1() {
        texto="";
        alu=new Alumno();
        lisalu=new ArrayList();
        esp=new Especial();
    }
 
 //al moneto de cargar una pagina este metodo se activara
 @PostConstruct 
 public void init(){
     lisalu=new Negocio().LisAlumno();
     lisesp=new ArrayList<SelectItem>();
     //para cargar un combo
     for(Especial x:new Negocio().LisEsp()){
         SelectItem item= new SelectItem(x.getCode(), x.getNomesp());
         lisesp.add(item);
     }
 }
 public void adicion(){
     alu.setCode(esp.getCode());
     new Negocio().adicion(alu);
     lisalu=new Negocio().LisAlumno();//actualiza la lista
     alu=new Alumno();//limpiar los campos
     
 }
 
 public void filtra(){
     lisalu=new Negocio().filtrar(texto);
 }
 
 
 public void verpago(Alumno a){
     nombre=a.getApe()+","+a.getNoma();
     lispago=new Negocio().select_pago(a.getCoda());
     total=0;
     for(Pagos x:lispago) total=total+x.getMonto();
 }

    public Alumno getAlu() {
        return alu;
    }

    public void setAlu(Alumno alu) {
        this.alu = alu;
    }

    public List<Alumno> getLisalu() {
        return lisalu;
    }

    public void setLisalu(List<Alumno> lisalu) {
        this.lisalu = lisalu;
    }

    public List<Pagos> getLispago() {
        return lispago;
    }

    public void setLispago(List<Pagos> lispago) {
        this.lispago = lispago;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public String getTexto() {
        return texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public Especial getEsp() {
        return esp;
    }

    public void setEsp(Especial esp) {
        this.esp = esp;
    }

    public List<SelectItem> getLisesp() {
        return lisesp;
    }

    public void setLisesp(List<SelectItem> lisesp) {
        this.lisesp = lisesp;
    }
 
}
