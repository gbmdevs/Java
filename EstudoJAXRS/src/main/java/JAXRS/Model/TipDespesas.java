package JAXRS.Model;

import javax.persistence.Entity;
import javax.persistence.Table;
import javax.persistence.Id;
import javax.persistence.Column;

@Entity
@Table(name = "tipdespesas")
public class TipDespesas{
    
    @Id
    @Column(name = "idtipexpenses")
    private Integer idtipexpenses;   

    @Column(name = "titleexpenses")
    private String titleexpenses;

    @Column(name = "descexpenses")
    private String descexpenses;

    public TipDespesas(){
        
    }

    // Get and Setters das variaveis
    public Integer getIdTipExpenses(){
        return this.idtipexpenses;
    }

    public void setIdTipExpenses(Integer idtipexpenses ){
        this.idtipexpenses = idtipexpenses;
    }
 
    public String getTitleExpenses(){
        return this.titleexpenses;
    } 

    public void setTitleExpenses(String titleexpenses){
        this.titleexpenses = titleexpenses;
    }

    public void setDescExpenses(String descexpenses){
        this.descexpenses = descexpenses;
    }

    public String getDescExpenses(){
        return this.descexpenses;
    }

}