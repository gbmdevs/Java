package Planilha.Controller;

// Models
import Planilha.Model.Empregados;
import Planilha.Model.Gastos;
import Planilha.Model.Staff;
import Planilha.Model.DespesasFixas; 

// Controllers 
import Planilha.Controller.ProfileController;
import Planilha.Controller.GastosController;
import Planilha.Controller.TipoGastoController;
// JPA 
import Planilha.Controller.JPATipDespesas;

// Bibliotecas a respeito do Spring Framework 
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody; 
 
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.io.JsonEOFException;
import com.fasterxml.jackson.core.util.JsonParserSequence;
import com.fasterxml.jackson.databind.JsonMappingException;
// Jackson
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
// Bibliotecas Padrões
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Arrays;
import java.math.BigDecimal;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.Map;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;
 

//@CrossOrigin(origins = "http://localhost:4200")
@CrossOrigin(origins = "*")
@RestController
//@EntityScan(basePackages = "Planilha")
public class MainController{ 
    private ProfileController profi = new ProfileController();
    private GastosController  gastosCon = new GastosController();
    private ObjectMapper mapper  = new ObjectMapper(); 
    private DespesasFixasController despesasCon = new DespesasFixasController();
    private TipoGastoController tipogasto = new TipoGastoController();

    @RequestMapping(value="/gastos", method = RequestMethod.GET, produces= "application/json")
    public String listagastos() throws SQLException{
        this.profi.buscaGastos(1); 
        this.profi.buscaDespesas();  
        String      jsonRet  = "";
        // Monta JSON de Resposta
        try{
         jsonRet = this.mapper.writeValueAsString(this.profi);
        }catch(IOException e ){
           e.printStackTrace();
        }
        return jsonRet;
    }

    // POST - Gastos
    @RequestMapping(value="/gastos", method = RequestMethod.POST,
                    produces = "application/json",
                    consumes="application/json")
    public String insereGastos(@RequestBody Gastos gastos ){     
        return gastosCon.insertSpent(gastos);
    }

     // GET - Resumo
     @RequestMapping(value="/resumo", method = RequestMethod.GET,
     produces = "application/json")
        public String buscaResumo() throws SQLException{     
            return this.profi.buscaGastosListTipo();
        }

    //@Route - TipoGasto - LIST
    @RequestMapping(value    = "/tipogasto",
                    method   = RequestMethod.GET,
                    produces = "application/json")   
    public String listarTipoGasto(){
        return this.tipogasto.listarTipoGasto();
    }

    // * Despesas Fixas Routes 
    //@ROUTE despesasFixas - LIST
    @RequestMapping(value="/despesasfixas",
                    method = RequestMethod.GET,
                    produces = "application/json")
    public String listarDespesasFixas(){
        return despesasCon.listarDispesasFixas();
    }                


    // * Gráfico para Despesas Fixas
    @RequestMapping(value    ="/despfixgrap",
                    method   = RequestMethod.GET,
                    produces = "application/json")
    public String carregarGraficoDespesasFixas(){
       return despesasCon.carregarGraficoDespesasFixas();
    }                

    //* Lista Despesas Fixas do Mês Referencia
    @RequestMapping(value    = "/lidespfixa",
                    method   = RequestMethod.GET,
                    produces = "application/json")
    public String listarDespesasFixasMes(){
        return despesasCon.listarDespesasFixasMes();
    }                

    // * Listar os Ultimos 12 meses de movimento
    @RequestMapping(value   = "/ultmovidesp",
                   method   = RequestMethod.POST,
                   produces = "application/json")
    public String ultimo12mesDespesaFixas(@RequestBody DespesasFixas despfixa){
        return despesasCon.ultimo12mesDespesaFixas(despfixa);
    }               


    //*-----------------------------------------------------------------*//
    //* ESTUDOS EM JPA
    //*-----------------------------------------------------------------*//
    @RequestMapping(value    = "/testejpa",
                    method   = RequestMethod.GET,
                    produces = "application/json")
    public String testeEmJpa(){
        return new JPATipDespesas().buscaIdTipDespesas(1);
    }
 
}