package pkg0513;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.ParseException;
import java.util.List;

public class Main {

    private List<String> sorok;

    public Main() throws IOException {
        this.sorok = Files.readAllLines(Path.of("fuvar.csv"));
        assert !sorok.isEmpty() : "üres a fájl";
        //project properties > run > VM: -enableassertions vagy -ea
    }

    public static void main(String[] args) throws IOException, ParseException {
        new Main().feladatok();

    }

    private void feladatok() throws IOException, ParseException {
        feladat1();
        feladat2();
        feladat3();
        feladat4();
    }

    private void feladat1() throws IOException {
        //sorok = Files.readAllLines(Path.of("fuvar.csv"));
        System.out.println("1. feladat: sorok száma");
        System.out.printf("fájl, fejléccel együtt, %d sort tartalmaz\n", sorok.size()); //sorok száma
    }

    private void feladat2() throws IOException, ParseException {
        System.out.println("2. feladat: 1. fuvar adatai");
        String sor = "5240;2016-12-15 23:45:00;900;2,5;10,75;2,45;bankkártya";
        Fuvar fuvar = new Fuvar(sor);
        System.out.println(fuvar);
    }

    private void feladat3() throws ParseException {
        System.out.println("3. feladat: 1 véletlen fuvar adatai");
        int sorszam = (int) ((Math.random() * (sorok.size() - 1)) + 1);
        //sorszam = sorszam == 0 ? ++sorszam : sorszam;
        String sor = sorok.get(sorszam);
        Fuvar fuvar = new Fuvar(sor);
        System.out.println(fuvar);
    }

    private void feladat4() {
        System.out.println("4. feladat: készpénzes fizetések száma");
    }

}
