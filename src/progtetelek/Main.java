package progtetelek;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;

public class Main {

    private List<String> sorok;
    private Fuvar[] fuvarok;

    public static void main(String[] args) throws IOException {
        new Main().feladatok();
    }

    public Main() throws IOException {
        this.sorok = Files.readAllLines(Path.of("fuvar.csv"));
        assert !sorok.isEmpty() : "üres a fájl";

        fuvarok = new Fuvar[sorok.size() - 1];
        for (int i = 0; i < sorok.size() - 1; i++) {
            String sor = sorok.get(i + 1);
            Fuvar fuvar = new Fuvar(sor);
            fuvarok[i] = fuvar;
            //fuvarok[i] = new Fuvar(sorok.get(i+1));
        }
        assert sorok.size() - 1 == fuvarok.length : "nincs meg minden fuvar!";
        assert fuvarok[0] != null : "első fuvar hibás";
        assert fuvarok[fuvarok.length - 1] != null : "utolsó fuvar hibás";
        //project properties > run > VM: -enableassertions vagy -ea
    }

    private void feladatok() throws IOException {
        feladat1();
        feladat2();
        feladat3();
        feladat4();
        feladat5();
        feladat6();
        feladat7();
        feladat8();
    }

    private void feladat1() throws IOException {
        //sorok = Files.readAllLines(Path.of("fuvar.csv"));
        System.out.println("1. feladat: sorok száma");
        System.out.printf("fájl, fejléccel együtt, %d sort tartalmaz\n", sorok.size()); //sorok száma
    }

    private void feladat2() throws IOException {
        System.out.println("2. feladat: 1. fuvar adatai");
        String sor = "5240;2016-12-15 23:45:00;900;2,5;10,75;2,45;bankkártya";
        Fuvar fuvar = new Fuvar(sor);
        System.out.println(fuvar);
    }

    private void feladat3() {
        System.out.println("3. feladat: 1 véletlen fuvar adatai");
        int sorszam = (int) ((Math.random() * (sorok.size() - 1)) + 1);
        //sorszam = sorszam == 0 ? ++sorszam : sorszam;
        String sor = sorok.get(sorszam);
        Fuvar fuvar = new Fuvar(sor);
        System.out.println(fuvar);
    }

    private void feladat4() {
        System.out.println("4. feladat: milyen dátumú a legnagyobb távolságú fuvar:");
        //maximum kiválasztás tétele
        int max = 0;
        for (int i = 1; i < fuvarok.length; i++) {
            if (fuvarok[i].getTavolsag() > fuvarok[max].getTavolsag()) {
                max = i;
            }
        }
        System.out.println("távolság: " + fuvarok[max].getTavolsag());
        System.out.println("dátum: " + fuvarok[max].getIndulas());
    }

    private void feladat5() {
        System.out.println("5. feladat: borravalók átlaga: ");
        //összegzés tétele
        double osszeg = 0;
        for (int i = 0; i < fuvarok.length; i++) {
            osszeg += fuvarok[i].getBorravalo();
        }
        Locale loc = Locale.ENGLISH;
        System.out.printf(loc, "%.2f \n", osszeg / fuvarok.length);
    }

    private void feladat6() {
        System.out.println("6. feladat: minden fizetés bankkártyás-e: ");
        //eldöntés tétele
        int i = 0;
        while (i < fuvarok.length && "bankkártya".equals(fuvarok[i].getFizetes_modja())) {
            i++;
        }
        System.out.println(i >= fuvarok.length ? "igen" : "nem");
    }

    private void feladat7() {
        System.out.println("7. feladat: minden készpénzes fizetésnél 0 borravaló?");
        //eldöntés tétele
    }

    private void feladat8() throws IOException {
        System.out.println("8/1. feladat: készpénzes fuvarok listája, konzolon és fájlban?");
        List<Fuvar> kpFuvarok = new ArrayList<>();
        for (Fuvar fuvar : fuvarok) {
            if (fuvar.getFizetes_modja().equals("készpénz")) {
                kpFuvarok.add(fuvar);
            }
        }

        assert kpFuvarok.size() > 0 : "üres a lista";
        String kimenet = "";
        //System.out.println(kpFuvarok);
        for (Fuvar fuvar : kpFuvarok) {
            //System.out.println(fuvar);
            kimenet += fuvar + "\n";
        }
        //System.out.println(kimenet);
        Files.writeString(Path.of("kpFuvarok.txt"), kimenet);
        System.out.println("fájba kiírva!");

        System.out.println("8/2. feladat: milyen fiz mód vannak rögzítve?");
        //hashset azonos elemeket nem tárolja
        HashSet<String> fizModok = new HashSet<>();
        for (Fuvar fuvar : fuvarok) {
            fizModok.add(fuvar.getFizetes_modja());
        }
        
        for (String fizMod : fizModok) {
            System.out.println(fizMod);
        }
        
        System.out.println("8/3. feladat: különböző fizetési módokból mennyi van?");
        String[] fizMod = new String[fuvarok.length - 1];
        int[] db = new int[fuvarok.length - 1];
        for (int i = 0; i < fuvarok.length; i++) {

        }
    }

}
