package obsluga.biletomatu;
import java.time.LocalDate;
import java.util.ArrayList;

class Biletomat
{
    private final String lokalizacja;
    public int iloscTransakcji;
    public ArrayList<Transakcja> historia = new ArrayList<>();//historia ale na tablicy dynamicznej
    public int getIloscTransakcji()
    {
        return iloscTransakcji;
    }
    public String toString() {
        return lokalizacja;
    };
    public Biletomat(String lokalizacja)
    {
        this.lokalizacja = lokalizacja;
        iloscTransakcji = 0;
    }

    public double nowaTransakcja(int ileUlgowych, int ileNormalnych, Pieniadz ... bilon)
    {
        Transakcja nowaTr = new Transakcja(getIloscTransakcji());
        iloscTransakcji++;
        double naleznosc = ileNormalnych * 4.0 + ileUlgowych * 2.0;
        double kwota = 0;//ile klient wrzucil do biletomatu
        double reszta=0;

        int size = bilon.length;

        for (int j = 0; j<size; j++)
        {
            kwota = kwota + bilon[j].getNominal();
        }
        kwota = Math.round(kwota * 100.0) / 100.0;
        System.out.println("Kwota: " + kwota);
        if(kwota>=naleznosc)//jesli kwota rowna naleznosci, stworz bilet, wynik transakcji jako pomyslny
        {
            nowaTr.setStatus("Oplacono");
            reszta = Math.round((kwota - naleznosc)*100.0) / 100.0; //policz reszte i zaokraglij do 2 miejsc po przecinku

            for(int j = 0;j<ileUlgowych;j++)
            {
                BiletUlgowy nowyBilet = new BiletUlgowy();//stworz nowy bilet i go wydrukuj
                drukujBilet(true,nowaTr.getDate());
                System.out.println();
            }
            for(int j = 0; j<ileNormalnych;j++)
            {
                BiletNormalny nowyBilet = new BiletNormalny();
                drukujBilet(false,nowaTr.getDate());
            }
        }
        else if(kwota<naleznosc)//wyrzuc blad, jestli wplacono zbyt niska kwote
        {
            System.out.println("Nie wplacono calej naleznosci, sprobuj ponownie, zwrocono: " + kwota + " zl");
            nowaTr.setStatus("Transakcja niezakonczona");
            return kwota;
        }

        //dodanie danych do transakcji
        nowaTr.setKwota(kwota);
        nowaTr.setNaleznosc(naleznosc);
        nowaTr.setReszta(reszta);

        historia.add(nowaTr);

        System.out.println("Reszta: " + reszta);
        return reszta;
    }
    public void drukujBilet(boolean czyUlgowy, LocalDate data)
    {
        if(czyUlgowy)
        {
            System.out.println("---Bilet ulgowy---");
            System.out.println("Cena: 2 zl");
        }
        else
        {
            System.out.println("---Bilet normalny---");
            System.out.println("Cena: 4 zl");
        }
        System.out.println("Data: " + data);
        System.out.println("--------------------");
    }

    public void zobaczHistorie()
    {
        System.out.println("Historia transakcji z biletomatu " + getLokalizacja() + ": ");
        for (Transakcja element : historia)
        {
            System.out.println(element.zwrocDaneTransakcji());
        }
    }
    public boolean wypiszDaneTransakcji(int id)
    {
        for (Transakcja element : historia)
        {
            if(element.getIdTransakcji() == id)
            {
                System.out.println(element.zwrocDaneTransakcji());
                return true;
            }
        }
        System.out.println("Nie znaleziono transakcji o podanym id");
        return false;

    }
    public String getLokalizacja()
    {
        return lokalizacja;
    }

}