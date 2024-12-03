
package manegbean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import modelo.*;
import dao.Negocio;
import java.util.*;
import javax.annotation.PostConstruct;
import javax.faces.model.SelectItem;
@ManagedBean
@SessionScoped
public class control2 implements Serializable {
   private Notas curso;
   private List<SelectItem> liscurso;
   private List<Alumno> lisalu;
   private int cap;
   private int cds;
   
   @PostConstruct
   public void init(){
       liscurso=new ArrayList<SelectItem>();
       for(Notas x:new Negocio().LisCurso()){
           SelectItem item=new SelectItem(x.getCodc(),x.getNomcur());
           liscurso.add(item);
       }
   }
   public void alunota(){
       lisalu=new Negocio().LisAluCurso(curso.getCodc());
       cap=0; cds=0;
       for(Alumno x:lisalu){
          if(x.prom()>=11.5)cap++; else cds++; 
       }
   }
   
   
   
    public control2() {
        curso=new Notas();
    }

    public Notas getCurso() {
        return curso;
    }

    public void setCurso(Notas curso) {
        this.curso = curso;
    }

    public List<SelectItem> getLiscurso() {
        return liscurso;
    }

    public void setLiscurso(List<SelectItem> liscurso) {
        this.liscurso = liscurso;
    }

    public List<Alumno> getLisalu() {
        return lisalu;
    }

    public void setLisalu(List<Alumno> lisalu) {
        this.lisalu = lisalu;
    }

    public int getCap() {
        return cap;
    }

    public void setCap(int cap) {
        this.cap = cap;
    }

    public int getCds() {
        return cds;
    }

    public void setCds(int cds) {
        this.cds = cds;
    }
    
}
