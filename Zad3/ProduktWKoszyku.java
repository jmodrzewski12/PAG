
public class ProduktWKoszyku extends Produkt {
    
	private int liczbaSztukProduktu = 0;

    public void setLiczbaSztukProduktu(int liczbaSztukProduktu) {
        this.liczbaSztukProduktu = liczbaSztukProduktu;
    }
    public int getLiczbaSztukProduktu(){
        return liczbaSztukProduktu;
    }

    @Override
    public String toString() {
        return "(" + super.toString() + ", Liczba sztuk w koszyku:" + getLiczbaSztukProduktu() + ")";
    }

    public ProduktWKoszyku(Produkt p) {
        super(p.getNazwa(), p.getCena());
    }

}
