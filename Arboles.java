/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uspg;

import java.util.Scanner;


public class Arboles {
    Scanner in = new Scanner(System.in);
    Arboles_binarios lista = new Arboles_binarios();
    
    public static void main(String[] args) {
        
        Arboles list = new Arboles();
        list.menu();
    }
        public void menu(){
        boolean  exit = false;
        int opcion;        
        
        while(!exit) {
            System.out.println("------------Bienvenido a Univerdidad San Pablo Guatemala-------------");
            System.out.println("Que desea realizar: \n"
                    + "1.add Nodo\n"
                    + "2.recorrer inOrden\n"
                    + "3.recorrer preOrden\n"
                    + "4.recorrer postorden\n"
                    + "5.Buscar Nodo\n" 
                    + "6.eliminar\n" 
                    + "7.obtenerNodoReemplazo\n"                     
                    + "8.Es el mismo\n"                 
                    + "9.Exit\n");
                              
            System.out.println("Please select an option");

            opcion = in.nextInt();
            switch(opcion) {

                case 1:  
                    add();
                    break;   

                case 2: 
                    if(!lista.estavacia()){
                    lista.inOrden(lista.raiz);  
                    }
                    
                    else{
                        System.out.println("La pila esta vacia");
                    }                   
                    break;  
                    
                case 3: 
                    if(!lista.estavacia()){
                    lista.preOrden(lista.raiz);  
                    }
                    
                    else{
                        System.out.println("La pila esta vacia");
                    }                   
                    break;
                case 4:  
                    if(!lista.estavacia()){
                    lista.postorden(lista.raiz);  
                    }
                    
                    else{
                        System.out.println("La pila esta vacia");
                    }                   
                    break;
                   
                case 5:
                    if(!lista.estavacia()){
                    lista.buscarNodo(in.nextInt());
                    }
                    
                    else{
                        System.out.println("El dato no aparece en el Arbol binario");
                    }                   
                    break;
                    
                    
                case 6:   
                    if (!lista.estavacia()) {
                        lista.eliminar(in.nextInt());
                        System.out.println("La pila se ha vaciado");  
                    } else {
                    }
                    System.out.println("La cola esta vacia");        
                    break;                  
                case 7:
                    if (!lista.estavacia()) {
                        lista.obtenerNodoReemplazo(lista.raiz);
                        System.out.println("La pila se ha vaciado");  
                    } else {
                    }
                    System.out.println("La pila esta vacia");        
                    
                    break;
                case 8:
                    lista.isSameTree(tree1.raiz, tree2.raiz);
                    
                    
                
                    
                case 9:
                    exit= true;
                    break;
                default: 
                    System.out.println("----------------Please select the correct option----------------");
                break;        
            } 
          }
    }
        
    public void add(){
        int dato;
        System.out.println("Ingresar un elemento a la pila");
        dato=in.nextInt();
        
    }
    
   
}