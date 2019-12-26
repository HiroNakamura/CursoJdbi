package com.inforhomex.clases;

public class Contacto{
   private int id;
   private String nombre;
   private String telefono;
   
   public Conctacto(){}
   
   public Contacto(int id, String nombre, String telefono){
      super();
      this.id = id;
      this.nombre = nombre;
      this.telefono = telefono;
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
     return "Contacto{id: "+id+",nombre: "+nombre+", telefono: "+telefono+"}";
   }
}
