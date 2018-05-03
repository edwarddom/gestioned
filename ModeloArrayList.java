
/**
 * Implementa la parte de Modelo de Datow
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.*;
public class ModeloArrayList extends ModeloAbs{
Scanner teclado=new Scanner (System.in);

    private ArrayList <Producto> listProducto;
    
    public ModeloArrayList()
    {
       listProducto=new ArrayList <Producto>();
    }

    // Implementar los metodos abstractos de ModeloAbs
    public boolean insertarProducto ( Producto p){
    	listProducto.add(p);
      return false;    
    }
 
    public boolean borrarProducto ( int codigo ){
      for(int i=0;i<listProducto.size();i++) {
    	  if (codigo==listProducto.get(i).getCodigo()) 
    		  {
      			listProducto.remove(i);
      			System.out.println("Producto borrado");
    		  }
      	
      }
      return false;
    }
    
    public Producto buscarProducto ( int codigo) {
    	for(int i=0;i<listProducto.size();i++) {
    		if(codigo==listProducto.get(i).getCodigo()) {
    			System.out.println("Producto encontrado");
    			return listProducto.get(i);
    		}
    	}
    	
        return null;
    }
    
    public void listarProductos (){
    	System.out.println("ID "+" Nombre "+" Stock "+" Precio ");
    	for (int i=0;i<listProducto.size();i++) {
    		System.out.println(listProducto.get(i).toString());
    	}
        
    }
    public void listarPmin () {
    	System.out.println("ID "+ " Nombre "+" Stock "+" Precio ");
    	for(int i=0;i<listProducto.size();i++) {
    		if(listProducto.get(i).getStock()<=listProducto.get(i).getStock_min()) {
    			System.out.println(listProducto.get(i).toString());
    		}
    	}
    }
    
    public boolean modificarProducto (Producto nuevo){
    	return true;
    }

		
    
    
}    

