package obsluga.biletomatu;

abstract class Bilet {
    protected String rodzajBiletu;
    protected double cena;

    public String toString()
    {
        return getRodzajBiletu() + " : " + getCena();
    };

    protected String getRodzajBiletu() {
        return rodzajBiletu;
    }

    protected void setRodzajBiletu(String rodzajBiletu) {
        this.rodzajBiletu = rodzajBiletu;
    }
    protected double getCena() {
        return cena;
    }
    protected void setCena(int cena) {
        this.cena = cena;
    }
}

class BiletUlgowy extends Bilet {
    public BiletUlgowy()
    {
        this.setCena(2);
        this.setRodzajBiletu("ulgowy");
    }
}
class BiletNormalny extends Bilet{

    public BiletNormalny()
    {
        this.setCena(4);
        this.setRodzajBiletu("normalny");
    }
}