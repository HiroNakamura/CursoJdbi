package com.inforhomex.interfaces;

import com.inforhomex.clases.Contacto;
import java.util.List;

public interface ContactoDao{
   @SqlUpdate("CREATE TABLE contactos (id INTEGER PRIMARY KEY, nombre VARCHAR)")
   void createTable();

   @SqlUpdate("INSERT INTO contactos(id, nombre) VALUES (?, ?)")
   void insertPositional(int id, String nombre);

   @SqlUpdate("INSERT INTO contactos(id, nombre) VALUES (:id, :nombre)")
   void insertNamed(@Bind("id") int id, @Bind("nombre") String nombre);

   @SqlUpdate("INSERT INTO contactos(id, nombre) VALUES (:id, :nombre)")
   void insertBean(@BindBean Contacto contacto);

   @SqlQuery("SELECT * FROM contactos ORDER BY nombre")
   @RegisterBeanMapper(Contacto.class)
   List<Contacto> listContactos();
}
