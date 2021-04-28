package Planilha.Model;

// Libs do JPA - Persistencia
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Column;
import javax.persistence.Table;

@Entity
@Table(name = "tipdespesas")
public class Tipdespesas {

   @Id
   @Column(name = "idtipexpenses")
   private Integer idtipexpenses;

   @Column(name = "titleexpenses")
   private String titleexpenses;

   @Column(name = "descexpenses")
   private String descexpenses;

   // Get e Setters
   public void setIdTipExpenses(Integer idtipexpenses){
       this.idtipexpenses = idtipexpenses;
   }

   public Integer getIdTipExpenses(){
       return this.idtipexpenses;
   }

   // titleexpenses - Titulo da Despesa
   public void setTitleExpenses(String titleexpenses){
       this.titleexpenses = titleexpenses;
   }

   public String getTitleExpenses(){
       return this.titleexpenses;
   }

   // descexpenses - Descrição da Despesa
   public void setDescExpenses(String descexpenses){
       this.descexpenses = descexpenses;
   }

   public String getDescExpenses(){
       return this.descexpenses;
   }
    
}