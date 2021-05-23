public class Klient {

    private String nazwisko = "";
    private Koszyk koszyk = null;

    public void setKoszyk(Koszyk koszyk) {
        this.koszyk = koszyk;
    }

    public void setNazwisko(String nazwisko) {
        this.nazwisko = nazwisko;
    }

    public String getNazwisko() {
        return nazwisko;
    }

    public Koszyk getKoszyk() {
        return koszyk;
    }

    @Override
    public String toString() {
        return "Nazwisko: " + getNazwisko() + ", Koszyk: " + getKoszyk() ;
    }

    public Klient() {

    }
    public Klient(String nazwisko) {
        setNazwisko(nazwisko);
    }
}
