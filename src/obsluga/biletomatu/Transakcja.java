package obsluga.biletomatu;

import java.time.LocalDate;

public class Transakcja
{
    private int idTransakcji;
    private double reszta;
    private double kwota;
    private double naleznosc;
    private String status;
    private LocalDate date;

    public Transakcja(int ileTransakcji)
    {
        setIdTransakcji(ileTransakcji);
        setDate(LocalDate.now());
    }

    public String Wynik()
    {
        if(getKwota() >= getNaleznosc()) setStatus("Oplacono");
        if(getKwota() < getNaleznosc()) setStatus("Transakcja niezakonczona");

        return getStatus();
    }
    public String zwrocDaneTransakcji()
    {
        return "id: " + idTransakcji + ", data: " + date + ", kwota: " + kwota + ", naleznosc: " + naleznosc + ", reszta: " + reszta + ", status: " + status;
    }

    public int getIdTransakcji()
    {
        return idTransakcji;
    }

    public void setIdTransakcji(int idTransakcji)
    {
        this.idTransakcji = idTransakcji;
    }

    public double getReszta()
    {
        return reszta;
    }

    public void setReszta(double reszta)
    {
        this.reszta = reszta;
    }

    public double getKwota()
    {
        return kwota;
    }

    public void setKwota(double kwota)
    {
        this.kwota = kwota;
    }

    public double getNaleznosc()
    {
        return naleznosc;
    }

    public void setNaleznosc(double naleznosc)
    {
        this.naleznosc = naleznosc;
    }

    public String getStatus()
    {
        return status;
    }

    public void setStatus(String status)
    {
        this.status = status;
    }

    public LocalDate getDate()
    {
        return date;
    }

    public void setDate(LocalDate date)
    {
        this.date = date;
    }
}