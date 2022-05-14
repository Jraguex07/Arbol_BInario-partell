/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uspg;
    
public class Arboles_binarios {
    Nodo_Arbol raiz;
   
    public Arboles_binarios(){
        this.raiz = null;
    }
   
    //insertar un nodo
    public void addNodo(int dato){
        Nodo_Arbol nuevo = new Nodo_Arbol(dato);
        if(raiz == null){
            raiz = nuevo;
        }else{
            Nodo_Arbol aux = raiz;
            Nodo_Arbol padre;
            while(true){
                padre=aux;
                if(dato<aux.dato){
                    //va a la izquierda
                    aux= aux.hijoIzquierdo;
                    if(aux==null){
                        padre.hijoIzquierdo = nuevo;
                        return;
                    }
                }else{
                    //va a la derecha
                    aux = aux.hijoDerecho;
                    if(aux == null){
                        padre.hijoDerecho = nuevo;
                        return;
                    }
                }
            }
        }
    }
    public boolean estavacia(){
        return raiz==null;
    }
    
    public void inOrden(Nodo_Arbol num ){
        if (num!=null){

        inOrden(num.hijoIzquierdo);
        System.out.print(num.dato + ", ");
        inOrden(num.hijoDerecho);
    }
  }
    public void preOrden(Nodo_Arbol num ){
        if (num!=null){
        System.out.print(num.dato + " , ");
        inOrden(num.hijoIzquierdo);
        inOrden(num.hijoDerecho);
    }   
 }

    public void postorden(Nodo_Arbol num ){
         if (num!=null){

        postorden(num.hijoIzquierdo);
       
        postorden(num.hijoDerecho);
        System.out.print(num.dato + ",");
    }
   }
    public Nodo_Arbol buscarNodo(int dato){
    Nodo_Arbol aux =raiz;
    while (aux.dato!=dato){
        if (dato<aux.dato){
           aux=aux.hijoIzquierdo;
        }else{
           aux=aux.hijoDerecho;
             }
        if (aux==null){
           
        return null;
        }    
    }
        return aux;


    }  
    public boolean eliminar(int dato){
         //necesitamos dos punteros
         //de tipo nodo árbol
         Nodo_Arbol aux = raiz;
         Nodo_Arbol padre = raiz;
         boolean esHijoIzquierdo = true;
         while (aux.dato!= dato){
             padre=aux;
             if(dato < aux.dato){
                 //tomar izquierda
                 esHijoIzquierdo = true;
                 aux = aux.hijoIzquierdo;
             }else{
                 esHijoIzquierdo = false;
                 aux = aux.hijoDerecho;
             }
             if(aux == null){
                 return false;
             }
         }//fin while
         if(aux.hijoIzquierdo == null
                 && aux.hijoDerecho == null){
             //es hoja
             if(aux == raiz){
                 raiz = null;
             }else if(esHijoIzquierdo){
                 padre.hijoIzquierdo = null;
             }else{
                 padre.hijoDerecho = null;
             }
         }else if(aux.hijoDerecho == null){
             if(aux == raiz){
                 raiz = aux.hijoIzquierdo;
             }else if(esHijoIzquierdo){
                 padre.hijoIzquierdo = aux.hijoIzquierdo;
             }else{
                 padre.hijoDerecho = aux.hijoIzquierdo;
             }
         }else if(aux.hijoIzquierdo == null){
             if(aux == raiz){
                 raiz = aux.hijoDerecho;
             }else if(esHijoIzquierdo){
                 padre.hijoIzquierdo = aux.hijoDerecho;
             }else{
                 padre.hijoDerecho = aux.hijoIzquierdo;
             }
         }else{
             Nodo_Arbol reemplazo = obtenerNodoReemplazo(aux);
             if(aux == raiz){
                 raiz=reemplazo;
             }else if(esHijoIzquierdo){
                 padre.hijoIzquierdo = reemplazo;
             }else{
                 padre.hijoDerecho = reemplazo;
             }
             reemplazo.hijoIzquierdo = aux.hijoIzquierdo;
         }
         return true;
     }
    public Nodo_Arbol obtenerNodoReemplazo(Nodo_Arbol nodoReemplazo){
         Nodo_Arbol reemplazarPadre = nodoReemplazo;
         Nodo_Arbol reemplazo = nodoReemplazo;
         
         Nodo_Arbol aux = nodoReemplazo.hijoDerecho;
         
         while(aux!= null){
             reemplazarPadre = reemplazo;
             reemplazo = aux;
             aux = aux.hijoIzquierdo;
         }
         if(reemplazo!= nodoReemplazo.hijoDerecho){
             reemplazarPadre.hijoIzquierdo = reemplazo.hijoDerecho;
             reemplazo.hijoDerecho = nodoReemplazo.hijoDerecho;
         }  
         System.out.println("El nodo reemplazo es " + reemplazo);
         return reemplazo;   
     
   }
    public  boolean isSameTree(Nodo_Arbol tree1,Nodo_Arbol tree2){
            if (tree1 == null && tree2 == null) {// Si ambos árboles están vacíos
                        return true;
                    }
            else if (tree1 == null || tree2 == null) {// Si uno de los dos árboles está vacío
                        return false;
                    }
                     if(tree1!=null&&tree2!=null){
                        if(tree1.dato!=tree2.dato){
                            return false;
                        }
                        else {
                            return isSameTree(tree1.hijoIzquierdo,tree2.hijoIzquierdo)&&isSameTree(tree1.hijoDerecho,tree2.hijoDerecho);
                        }
                    }
                 return false;   
                }
}

