package com.inforhomex;

import java.util.Properties;

import com.inforhomex.interfaces.ContactoDao;

import static java.lang.System.out;
import static java.lang.System.err;
import org.skife.jdbi.v2.DBI;
import org.skife.jdbi.v2.Handle;
import java.io.FileInputStream;

public class Main{

    public static Properties MyPropiedades = null;
    public static String myUser = null;
    public static String myPassw = null;
    public static String myDriver = null;
    public static String myUrl = null;

    public static DBI dbi = null;
    public static Handle handle = null;


    static{
        try{

            Main.MyPropiedades = new Properties();
            Main.MyPropiedades.load(new FileInputStream("src/main/resources/application.properties"));
            Main.myUser = Main.MyPropiedades.getProperty("data.user");
            Main.myPassw = Main.MyPropiedades.getProperty("data.password");
            Main.myUrl = Main.MyPropiedades.getProperty("data.url");
            Main.myDriver = Main.MyPropiedades.getProperty("data.driver");

            out.println("User: "+Main.myUser);
            out.println("Password: "+Main.myPassw);
            out.println("Url: "+Main.myUrl);
            out.println("Driver: "+Main.myDriver);

            Main.dbi = new DBI(Main.myUrl,Main.myUser,Main.myPassw);
            Main.handle = Main.dbi.open();
            
            if(!Main.dbi.open().isInTransaction()){
                out.println("La conexion esta abierta!!!");
            }
            
        }catch(Exception ex){
            err.println("Ha ocurrido una excepcion al cargar el archivo: "+ex.toString());
        }
    }

   public static void main(String[] args){
       out.println("***** JDBI *****");
       try{
           //crear();
           //insertar();
           String nombre = getNombre();
           out.println("Nombre: "+nombre);
       }catch(Exception ex){
           err.println("Ha ocurrido una excepcion: "+ex.toString());
       }finally{
           Main.handle.close();
           out.println("Conexion cerrada!!!");
       }
   }

   public static String getNombre()throws Exception{
    out.println("Insertando en tabla...");
    ContactoDao contactoDao = null;
    String tuNombre = null;
    contactoDao = Main.dbi.open(ContactoDao.class);
    tuNombre = contactoDao.findNameById(1);
    out.println("Se ha obtenido el nombre!!");
    contactoDao.close();
    out.println("Conexion cerrada!!");
    return tuNombre;
   }

   public static void insertar()throws Exception{
    out.println("Insertando en tabla...");
    ContactoDao contactoDao = null;
    contactoDao = Main.dbi.open(ContactoDao.class);
    contactoDao.insert("Pedro Paramo", "555-432");
    out.println("Se ha insertado los datos!!");
    contactoDao.close();
    out.println("Conexion cerrada!!");
   }

   public static void crear()throws Exception{
       out.println("Creando tabla...");
       ContactoDao contactoDao = null;
       contactoDao = Main.dbi.open(ContactoDao.class);
       contactoDao.createSomethingTable();
       out.println("Tabla creada!!");
       contactoDao.close();
       out.println("Conexion cerrada!!");
   }
   
}
