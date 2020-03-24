package com.inforhomex;

import java.util.Properties;
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

       }catch(Exception ex){
           err.println("Ha ocurrido una excepcion: "+ex.toString());
       }finally{
           Main.handle.close();
           out.println("Conexion cerrada!!!");
       }
   }

   public static void crear(){

   }
   
}
