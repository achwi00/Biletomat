package obsluga.biletomatu;

public class Main {

        public static void main(String[] args)
        {
                Biletomat B001 = new Biletomat("Kr-StareMiasto");
                //tworzenie pieniedzy
                gr10 grosiki10 = new gr10();
                gr20 grosiki20 = new gr20();
                gr50 grosiki50 = new gr50();
                zl1 zlote1 = new zl1();
                zl2 zlote2 = new zl2();
                zl5 zlotych5 = new zl5();

                //System.out.println(grosiki.getNominal());
                System.out.println("****Nowa transakcja****\n");
                B001.nowaTransakcja(1,1,zlote2,zlote2,zlote2);

                System.out.println("*********************");
                //B001.wypiszDaneTransakcji(0);
                System.out.println("\n\n****Nowa transakcja****\n");

                B001.nowaTransakcja(2,1,zlotych5,zlotych5);
                System.out.println("*********************");
                //B001.zobaczHistorie();

                System.out.println("\n\nDane transakcji o id 1: ");
                B001.wypiszDaneTransakcji(1);


        }

}
