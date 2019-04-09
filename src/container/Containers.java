
package container;


public class Containers {
    
    double liquid, capasity;
    
    // Konstruktor przypisujacy wartosc pojemnosci do butelki
    Containers(double liquid, double capasity){
        this.liquid = liquid;
        this.capasity = capasity;
    }
    
    // Metoda zwracajaca pojemnosc 
    double getLiquid(){
        
    return liquid;
    }
    
    // Metoda wlewa podana liczbe wody do pojemnika
    boolean pour(double howMuch){
           
        if(this.capasity >= howMuch + this.liquid){
            this.liquid += howMuch ;
        return true;    
        }else{
            System.out.println("Bottle is to small.");
        return false;    
        }
        
    }
    
    // Metoda wylewa wode z pojemnika 
    boolean outPour(double howMuch){
    
        if(this.liquid >= howMuch){ 
            this.liquid -= howMuch;
        return true;    
        }else{
            System.out.println("There is not enough water to outpour. You can only outpour " + this.liquid + " liter's.");
        return false;
        }
    }
    // Metoda przelewajaca wode z jednego pojemnika do drugiego jesli to mozliwe
    void transfer(double howMuch, Containers where){
    
        if((this.outPour(howMuch) == true) && (where.pour(howMuch)) == true){
            
            where.pour(howMuch);        
            this.outPour(howMuch);           
        }
    }
     
    public static void main(String[] args) {
                  
        Containers[] con = new Containers[3];
        
        con[0] = new Containers(23,50);
        con[1] = new Containers(53,60);
        con[2] = new Containers(12,50);
        
       // Sprawdz co tu sie odpierdala. Tak jakby w ifie przy sprawdzaniu sie juz wykonuje działanie. 
        con[1].transfer(20, con[0]);
        System.out.println(con[0].getLiquid() + ", " + con[1].getLiquid() + ", " + con[2].getLiquid());
    }    
    
   
}
