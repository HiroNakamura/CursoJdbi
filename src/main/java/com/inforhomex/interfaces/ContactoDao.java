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

public interface ContactoDao{
   @SqlUpdate("create table contacto (id int primary key, name varchar(100))")
   void createSomethingTable();
   
   @SqlUpdate("insert into contacto (id, name) values (:id, :name)")
   void insert(@Bind("id") int id, @Bind("name") String name);
   
   @SqlQuery("select name from contacto where id = :id")
   String findNameById(@Bind("id") int id);
   void close();
   
}
