/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package serviciosEnsayo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedHashMap;
import java.util.List;

import javax.ws.rs.Consumes;
import javax.ws.rs.GET;

import javax.ws.rs.POST;
import javax.ws.rs.Path;

import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Jonathan
 */
@Path("/Ensayo")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class Ensayo {

    @GET
    public Integer getTodosLosMuebles() {
        return 1;

    }

//    @POST
//    @Path("/metodo")
//    public String metodo(List lista) {
//
//        LinkedHashMap l1 = (LinkedHashMap) lista.get(0);
//
//        System.out.println(l1.toString());
//        LinkedHashMap l2 = (LinkedHashMap) lista.get(1);
//
//        System.out.println(l2.toString());
//
//        Clase1 c1 = new Clase1();
//        c1.setNombre(l1.get("nombre").toString());
//        c1.setNumero((int) l1.get("numero"));
//
//        Clase2 c2 = new Clase2();
//        c2.setPalabra(l2.get("palabra").toString());
//        c2.setNum((int) l2.get("num"));
//        return c1.toString() + " - " + c2.toString();
//    }
//
//    @POST
//    @Path("/metodo2")
//    public String metodo2(Clase1 c1) {
//
//        System.out.println(c1.toString());
//        return c1.getNombre();
//    }

    @GET
    @Path("/metodo3")
    public String metodo3() {

        try {
            Connection con = null;
            Class.forName("oracle.jdbc.driver.OracleDriver");
            con = DriverManager.getConnection("jdbc:oracle:thin:@157.253.238.224:1531:prod", "ISIS2304271510", "rproxyquark");
            
            String sql = "select * from PRUEBA";
                //System.out.println(sql);
            Statement st = con.createStatement();
            
            ResultSet rs = st.executeQuery(sql);
            String resps = "";
            while (rs.next()){   
                
                resps+=rs.getString("COLUMN1")+" , "+rs.getString("COLUMN2")+"\n";
            }
            
            return resps;
            
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        return "Error";
    }
}
