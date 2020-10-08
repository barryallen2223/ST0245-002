import java.util.Hashtable;

public class Empresas
{
    Hashtable<String, String> clientes;
    
    public void HashTable(){
        clientes = new Hashtable<String, String>();
    }
        
    public String getLocation(String nombre){
        return clientes.get(nombre);
    }
    
    public void newEmpresa(String nombre, String ubicacion){
        clientes.put(nombre, ubicacion);
    }
}
