import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;
import java.util.LinkedList;

public class Koszyk {

    public Stack<ProduktWKoszyku> stos = new Stack<>();
    public double suma = 0.0;

    public void dodajProdukt(Produkt pr, int liczba) {
        ProduktWKoszyku prk = new ProduktWKoszyku (pr);
        prk.setLiczbaSztukProduktu(liczba);
        suma += prk.getCena() * liczba;
        stos.push(prk);
    }

    public double getSuma() {
        return suma;
    }
    public void setSuma() {
    	this.suma = suma;
    }

    
    public Koszyk(){
    }
    
    public String toString() {
    	return stos + "\n" + "- ³¹czna cena: " + getSuma();             
    }
   
}