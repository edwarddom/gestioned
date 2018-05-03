
/**
 * Write a description of class ModeloHaspMap here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;


public class ModeloHashMap extends ModeloAbs
{
    private HashMap <Integer,Producto> lista;
    
    public ModeloHashMap()
    {
       lista=new HashMap  <Integer,Producto>();
    }
    public boolean insertarProducto ( Producto p){
    	lista.put(1,p);
        return false;    
      }
   
      public boolean borrarProducto ( int codigo ){
    	  for(int i=0;i<lista.size();i++) {
        	  if (codigo==lista.get(i).getCodigo()) 
        		  {
          			lista.remove(i);
          			System.out.println("Producto borrado");
        		  }
          		else 
          		  {
          			System.out.println("No se encuentra en el almacen");
        	      }
          }
        
        return false;
      }
      
      public Producto buscarProducto ( int codigo) {
    		for(int i=0;i<lista.size();i++) {
        		if(codigo==lista.get(i).getCodigo()) {
        			System.out.println("Producto encontrado");
        			return lista.get(i);
        		}
        	}
        	
          return null;
      }
      
      public void listarProductos (){
    	  System.out.println("Codigo "+"  Nombre "+"  Stock "+" Precio ");
      	for (int i=0;i<lista.size();i++) {
      		System.out.println(lista.get(i).toString());
      	}
      }
      	 public void listarPmin () {
         	System.out.println("ID "+ " Nombre "+" Stock "+" Precio ");
         	for(int i=0;i<lista.size();i++) {
         		if(lista.get(i).getStock()<=lista.get(i).getStock_min()) {
         			System.out.println(lista.get(i).toString());
         		}
         	}
         }
      		
      	
          
      
      
      public boolean modificarProducto (Producto nuevo){
         return true;
      }
}
