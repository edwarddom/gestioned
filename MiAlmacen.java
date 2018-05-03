import java.util.*;


// Crear la clase Producto y completar los mÃ©todos

public class MiAlmacen
{
    static private ModeloAbs almacen;
    static Scanner teclado;
    
    public static void main(String[] args){
        almacen=new ModeloArrayList();
        teclado = new Scanner(System.in);
        int opcion=0;
        do{
		mostrarMenu();
                opcion=leerOpcion(1,9);
                switch(opcion){
                    case 1: crear();break;
                    case 2: consultar();break;
                    case 3: borrar();break;
                    case 4: modificarPrecio();break;
                    case 5: comprar();break;
                    case 6: vender();break;
                    case 7: listar();break;
                    case 8: listarPocoStock();break;
                }
                System.out.println("\n---------------------------- ");
                System.out.print("Pulse enter para continuar");
                teclado.nextLine();
        }while(opcion!=9);
        teclado.close();
        
    }
    
    
    private static void mostrarMenu(){
        System.out.println("\n\n    MENU");
        System.out.println("1. Nuevo producto ");
        System.out.println("2. Consulta producto ");
        System.out.println("3. Borrar producto ");
        System.out.println("4. Modificar precio ");
        System.out.println("5. Compra de productos ");
        System.out.println("6. Venta de productos ");
        System.out.println("7. Listado completo de productos ");
        System.out.println("8. Listado de productos con stock inferior al minimo");
        System.out.println("9. Terminar ");
        System.out.print("Elige una opción (1-9)");        
    }
    
    // Lee un entero del System.in que este comprendido entre primero y ultimo
    private static int leerOpcion(int primero, int ultimo){
        int valor = leerEntero();
        while ( valor <primero || valor > ultimo){
            valor = leerEntero();
        }
        return valor;
    }
      
    
    // Metodos Auxiliares leerFloat y LeerEntero, 
    // Lee de la System.in con el scanner sc y controlan la excepcion de NumberFormatException
    static private float leerFloat(){
        
        boolean error = false;
        float valor =0;
        String cadena;
        do {
        error = false;  
          try {
             // Intento leer directamente un entero  
             cadena = teclado.nextLine();
             valor = Float.parseFloat(cadena);
             
            } catch(Exception e){
              System.out.println("Error en formato.");
              error = true;
            }
        }
       while ( error);
       return valor;
    }
    
    static private int leerEntero(){
    	 boolean error = false;
         int valor =0;
         int cadena;
         do {
         error = false;  
           try {
              // Intento leer directamente un entero  
              cadena = teclado.nextInt();
              valor = cadena;
              
             } catch(Exception e) {
               System.out.println("Error en formato.");
               error = true;
             }
             }
         
        while ( error);
        return valor;
     
    	 // Implementar
    }
   
    // Muestra los datos de un producto a partir de su codigo
    
    private static void consultar(){        
       System.out.println("<CONSULTA>");
       System.out.print("Introduzca codigo:");
       int codigo = leerEntero();
       Producto p = almacen.buscarProducto(codigo);
       if ( p == null){
           System.out.println("El producto no se encuentra en almacen");
        }
       else {
           System.out.println("PRODUCTO "+p);
        }
       
    }
    
   
    // Borrar un producto a partir de su codigo
    
    private static void borrar(){       
      System.out.println("<ELIMINAR>");
      System.out.println("Introduzca el codigo del producto a eliminar");
  	  int id = leerEntero();
  	  almacen.borrarProducto(id);
      // IMPLEMENTAR
    }
    
    // Cambia el precio de un producto a partir de su codigo
    private static void modificarPrecio (){
       System.out.println("<MODIFICAR PRECIO>");
       System.out.println("Introduzca el codigo del producto" );
       int id =leerEntero();
       Producto p =almacen.buscarProducto(id);
       System.out.println("Introduzca el nuevo precio del producto");
       int nuevop=leerEntero();
       p.setPrecio(nuevop);
       
       // IMPLEMENTAR
    }
    
    
    
    // Incrementa el stock
    private static void comprar(){     
       System.out.println("<COMPRAR>");
       System.out.println("Introduzca el codigo del producto a comprar");
   	   int id =leerEntero();
   	   System.out.println("Introduzca el número de unidades que quiere");
   	   int udAComprar=leerEntero();
   	   Producto p = almacen.buscarProducto(id);
   	   p.setStock(p.stock+udAComprar);
   	}
   		
	
   	
              // IMPLEMENTAR 
    
    
    // Decrementa el stock
    private static void vender(){
        System.out.println("<VENDER>");
        System.out.println("Introduzca el código del producto a vender");
        int id=leerEntero();
        System.out.println("Introduzca el número de unidades que quiere");
        int udAVender=leerEntero();
        Producto p = almacen.buscarProducto(id);
        p.setStock(p.stock-udAVender);
        
       // IMPLEMENTAR
       
    }
    
    // Listado de todos los productos
    private static void listar(){  
    	 System.out.println("<LISTAR>");
         almacen.listarProductos(); 
    }
    
    // Listado de todos los productos con stock inferior a stock minimo
    private static void listarPocoStock(){
        System.out.println("<LISTAR STOCK BAJO MINIMOS>");
        almacen.listarPmin();
    
    }
    
    // Solicita datos al usuario para dar de alta un nuevo producto 
    // El codigo no se puede repetir
    private static void crear(){
    	
    	System.out.println("<NUEVO PRODUCTO>");
    	System.out.println("Inserta codigo del producto");
    	int codigo = teclado.nextInt();
    	almacen.buscarProducto(codigo);
    	System.out.println("Inserta stock disponible del producto");
    	int stock = teclado.nextInt();
    	System.out.println("Inserta stock minimo del producto");
    	int stock_minimo = teclado.nextInt();
    	System.out.println("Inserta precio del producto");
    	float precio = teclado.nextFloat();
    	System.out.println("Inserta nombre del producto");
    	String nombre = teclado.next();
    	Producto nuevo= new Producto(codigo,nombre);
    	nuevo.setPrecio(precio);
    	nuevo.setStock(stock);
    	nuevo.setStock_min(stock_minimo);
    	almacen.insertarProducto(nuevo);
    	
       

       // IMPLEMENTAR
    }
       
  
}

