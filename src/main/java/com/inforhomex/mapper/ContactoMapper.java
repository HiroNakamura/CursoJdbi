package com.inforhomex.mapper;

import com.inforhomex.clases.Contacto;
import org.skife.jdbi.v2.tweak.ResultSetMapper;
import java.sql.SQLException;
import java.sql.ResultSet;
import org.skife.jdbi.v2.StatementContext;

public class ContactoMapper implements ResultSetMapper<Contacto>{
  private int id;
  private String nombre;
  private String telefono;
   
  public ContactoMapper(){}
   
   public ContactoMapper(int id, String nombre, String telefono){
      super();
      this.id = id;
      this.nombre = nombre;
      this.telefono = telefono;
   }

   @Override
    public Contacto map(int arg0, ResultSet r, StatementContext arg2) throws SQLException {
        Contacto mcontacto =new Contacto();
        mcontacto.setNombre(r.getString("nombre"));
        mcontacto.setTelefono(r.getString("telefono"));
        return null;
    }
   
   public int getId(){
     return id;
   }
   public void setId(int id){
     this.id = id;
   }
   
   public String getNombre(){
     return nombre;
   }
   public void setNombre(String nombre){
     this.nombre = nombre;
   }
   
   public String getTelefono(){
     return telefono;
   }
   public void setTelefono(String telefono){
     this.telefono = telefono;
   }
   
   @Override
   public String toString(){
     return "ContactoMapper{id: "+id+",nombre: "+nombre+", telefono: "+telefono+"}";
   }
}
