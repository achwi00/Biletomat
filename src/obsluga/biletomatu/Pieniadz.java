package obsluga.biletomatu;

abstract class Pieniadz {
    protected double nominal;
    public double getNominal() {
        return nominal;
    }

    public void setNominal(double nominal) {
        this.nominal = nominal;
    }
}

class gr10 extends Pieniadz{
    public gr10(){
        this.setNominal(0.1);
    }
    public double get()
    {
        return nominal;
    }
}
class gr20 extends Pieniadz{
    public gr20() {
        this.setNominal(0.2);
    }
}
class gr50 extends Pieniadz{
    public gr50() {
        this.setNominal(0.5);
    }

}
class zl1 extends Pieniadz{
    public zl1() {
        this.setNominal(1.0);
    }
}
class zl2 extends Pieniadz{
    public zl2() {
        this.setNominal(2.0);
    }
}
class zl5 extends Pieniadz{
    public zl5() {
        this.setNominal(5.0);
    }

}