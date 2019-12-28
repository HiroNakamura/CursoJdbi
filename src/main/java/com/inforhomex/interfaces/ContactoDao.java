package com.inforhomex.interfaces;

import com.inforhomex.clases.Contacto;
import java.util.List;
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;


public interface ContactoDao{
   @SqlUpdate("CREATE TABLE contactos (id INTEGER PRIMARY KEY, nombre VARCHAR, telefono VARCHAR)")
   void createTable();

   @SqlUpdate("INSERT INTO contactos(id, nombre, telefono) VALUES (?, ?,?)")
   void insertPositional(int id, String nombre. String telefono);

   @SqlUpdate("INSERT INTO contactos(id, nombre,telefono) VALUES (:id, :nombre,:telefono)")
   void insertNamed(@Bind("id") int id, @Bind("nombre") String nombre, @Bind("telefono") String telefono);

   @SqlUpdate("INSERT INTO contactos(id, nombre,telefono) VALUES (:id, :nombre,:telefono)")
   void insertBean(@BindBean Contacto contacto);

   @SqlQuery("SELECT * FROM contactos ORDER BY nombre")
   @RegisterBeanMapper(Contacto.class)
   List<Contacto> listContactos();
}
