
public class Fecha
{
    int dia, mes, anyo;
    
    public Fecha(int dia, int mes, int anyo){
        this.dia = dia;
        this.mes = mes;
        this.anyo = anyo;
    }
    
    public int dia(){
        return dia;
    }
    
    public int mes(){
        return mes;
    }
    
    public int anyo(){
        return anyo;
    }
    
    public boolean equals(Fecha date){
        if ( date.toString().equals(this.toString()) ){
            return true;
        }
        return false;
    }
        
    public int comparelo(Fecha date){
        if ( date.anyo > this.anyo ){
            return 1;
        }
        else if ( date.anyo < this.anyo ){
            return -1;
        }
        else {
            if ( date.mes > this.mes ){
                return 1;
            }
            else if ( date.mes < this.mes ){
                return -1;
            }
            else {
                if ( date.dia > this.dia ){
                return 1;
                }
                else if ( date.dia < this.dia ){
                    return -1;
                }
            }
        }
        return 0;
    }
    
    public String toString()
    {
        return dia + "-" + mes + "-" + anyo;
    }
}
