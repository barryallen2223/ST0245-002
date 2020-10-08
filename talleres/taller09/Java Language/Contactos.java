import java.util.Hashtable;

public class Contactos
{
    Hashtable<String, Integer> contactos;
    
    public void HashTable(){
        contactos = new Hashtable<String, Integer>();
    }
        
    public int getNumero(String nombre){
        return contactos.get(nombre);
    }
    
    public void newContacto(String nombre, int phoneNumber){
        contactos.put(nombre, new Integer(phoneNumber));
    }
}
