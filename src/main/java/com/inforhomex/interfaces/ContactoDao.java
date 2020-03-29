package com.inforhomex.interfaces;

import com.inforhomex.clases.Contacto;
import java.util.List;

import org.skife.jdbi.v2.sqlobject.SqlUpdate; 
import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapper;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
import org.skife.jdbi.v2.tweak.*;
import org.skife.jdbi.v2.*;
import org.skife.jdbi.v2.sqlobject.BindBean;
import com.inforhomex.mapper.ContactoMapper;
import org.skife.jdbi.v2.sqlobject.Bind;


@RegisterMapper(ContactoMapper.class)
public interface ContactoDao{
   @SqlUpdate("create table contacto (id int auto_increment primary key, nombre varchar(100), telefono varchar(12) )")
   void createSomethingTable();
   
   @SqlUpdate("insert into contacto (nombre,telefono) values (:nombre, :telefono)")
   void insert(@Bind("nombre") String nombre, @Bind("telefono") String telefono);
   
   @SqlUpdate("update contacto set nombre = :nombre ,telefono = :telefono where id = :id")
   void update(@Bind("id") int id, @Bind("nombre") String nombre, @Bind("telefono") String telefono);
   
   @SqlUpdate("delete contacto where id = :id")
   void delete(@Bind("id") int id);
   
   @SqlQuery("select nombre from contacto where id = :id")
   String findNameById(@Bind("id") int id);
   
   void close();
   
}
