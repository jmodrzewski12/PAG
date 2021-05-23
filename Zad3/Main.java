

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;

public class Main {
	 public static void main(String[] args) {

        // lista produktów
        Produkt pomidor = new Produkt("pomidor", 2.5);
        Produkt marchewka = new Produkt("marchewka", 5);
        Produkt rower = new Produkt("rower", 900);
        Produkt buty = new Produkt("buty", 200);
        Produkt bluza = new Produkt("bluza", 200);
        Produkt spodnie = new Produkt("spodnie", 200);
        Produkt narty = new Produkt("narty", 400);
        Produkt czapka = new Produkt("czapka", 50);
        Produkt skarpety = new Produkt("skarpety", 20);
        Produkt kalosze = new Produkt("kalosze", 85.5);
        Produkt makaron = new Produkt("makaron", 7);
        Produkt telewizor = new Produkt("telewizor", 1580);
        Produkt ksiazka = new Produkt("ksiazka", 35.8);
        Produkt portfel = new Produkt("portfel", 123);
        Produkt kredki = new Produkt("kredki", 9.2);
        
        ArrayList<Produkt> listaProduktow = new ArrayList<>(Arrays.asList(pomidor, marchewka, rower, buty, bluza, spodnie, narty, czapka, skarpety, kalosze, makaron, telewizor, ksiazka, portfel, kredki));
        //System.out.println(listaProduktow);

        // lista klientów
        Klient lewy = new Klient("Lewandowski");
        Koszyk k1 = new Koszyk();
        k1.dodajProdukt(pomidor, 5);
        k1.dodajProdukt(bluza, 2);
        lewy.setKoszyk(k1);
        //System.out.println(k1.stos);
        //System.out.println(k1.getSuma());

        Klient zielu = new Klient("Zielinski");
        Koszyk k2 = new Koszyk();
        k2.dodajProdukt(rower, 1);
        k2.dodajProdukt(narty, 1);
        zielu.setKoszyk(k2);

        Klient grosik = new Klient("Grosicki");
        Koszyk k3 = new Koszyk();
        k3.dodajProdukt(czapka, 11);
        k3.dodajProdukt(skarpety, 6);
        grosik.setKoszyk(k3);

        Klient piszczu = new Klient("Piszczek");
        Klient ryba = new Klient("Rybus");
        Klient fabian = new Klient("Fabianski");
        
        Klient szczesny = new Klient("Szczesny");
        Koszyk k4 = new Koszyk();
        k4.dodajProdukt(kredki, 10);
        k4.dodajProdukt(kalosze, 1);
        k4.dodajProdukt(makaron, 3);
        k4.dodajProdukt(bluza, 1);
        szczesny.setKoszyk(k4);
        
        Klient klich = new Klient("Klich");
        Koszyk k5 = new Koszyk();
        k5.dodajProdukt(telewizor, 1);
        k5.dodajProdukt(pomidor, 7);
        klich.setKoszyk(k5);
        
        Klient glik = new Klient("Glik");
        Koszyk k6 = new Koszyk();
        k6.dodajProdukt(ksiazka, 2);
        k6.dodajProdukt(portfel, 1);
        k6.dodajProdukt(czapka, 1);
        k6.dodajProdukt(narty, 1);
        glik.setKoszyk(k6);
        
        Klient krycha = new Klient("Krychowiak");
        Koszyk k7 = new Koszyk();
        k7.dodajProdukt(buty, 2);
        k7.dodajProdukt(portfel, 1);
        k7.dodajProdukt(czapka, 3);
        k7.dodajProdukt(spodnie, 2);
        k7.dodajProdukt(bluza, 2);
        k7.dodajProdukt(skarpety, 6);
        krycha.setKoszyk(k7);

        ArrayList<Klient> listaKlientow = new ArrayList<>(Arrays.asList(lewy, zielu, grosik, piszczu, ryba, fabian, szczesny, klich, glik, krycha));
        //System.out.println(listaKlientow);


        // Kolejka
        LinkedList<Klient> kolejka = new LinkedList<>();
        kolejka.addAll(listaKlientow);

        // Obsługa klientów
        while (!kolejka.isEmpty()) {	        	
            Klient k = kolejka.getFirst();
            if(k.getKoszyk() == null) {
            	kolejka.removeFirst();
            }            	
            else {
	            System.out.println(k);
	            kolejka.removeFirst();
            }

        }

    }

}
