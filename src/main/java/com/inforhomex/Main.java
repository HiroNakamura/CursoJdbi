package com.inforhomex;

import java.util.Properties;
import static java.lang.System.out;
import static java.lang.System.err;

import java.io.FileInputStream;

public class Main{

    public static Properties MyPropiedades = null;
    public static String myUser = null;
    public static String myPassw = null;
    public static String myDriver = null;
    public static String myUrl = null;

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
            

        }catch(Exception ex){
            err.println("Ha ocurrido una excepcion al cargar el archivo: "+ex.toString());
        }
    }

   public static void main(String[] args){
       out.println("***** JDBI *****");
   }

   public static void crear(){

   }
   
}
