package Planilha.Model;

public class TipoGasto {
    
    private Integer idtypespent;
    private String  titletypespent;
    private String  desctypespent;

    public TipoGasto(){
        
    }

    public TipoGasto(Integer idtypespent,
                     String  titletypespent,
                     String  desctypespent){
       this.idtypespent    = idtypespent;
       this.desctypespent  = desctypespent;
       this.titletypespent = titletypespent;
    }
    
    public void setIdTypeSpent(Integer idtypespent){
        this.idtypespent = idtypespent;
    }
    
    public Integer getIdTypeSpent(){
        return this.idtypespent;
    }
    
    public void setTitleTypeSpent(String titletypespent){
        this.titletypespent = titletypespent;
    }

    public String getTitleTypeSpent(){
        return this.titletypespent;
    }
    
    public void setDescTypeSpent(String desctypespent){
        this.desctypespent = desctypespent;
    }
    
    public String getDescTypeSpent(){
        return this.desctypespent;
    }
}
