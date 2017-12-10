/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adatkezeles;

import alaposztalyok.Felhasznalo;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import vezerles.Global;

/**
 *
 * @author varga
 */
public class FajlInput implements AdatInput {

    private String fajlEleres;

    public FajlInput(String fajlEleres) {
        this.fajlEleres = fajlEleres;
    }
    


    @Override
    public List<Felhasznalo> felhasznaloLista() throws Exception {
        List<Felhasznalo> felhasznalok = new ArrayList<>();
        String nev;
        int x, y, csoport;
        Felhasznalo felhasznalo;
        File file=new File(this.getClass().getResource(fajlEleres).toURI());
        try (Scanner scanner = new Scanner(file, "UTF-8")) {

            while (scanner.hasNextLine()) {
                nev = scanner.nextLine();
                x = Integer.parseInt(scanner.nextLine());
                y = Integer.parseInt(scanner.nextLine());
                csoport = new Random().nextInt(3)+1;
                felhasznalo = new Felhasznalo(nev, x, y, csoport);
                felhasznalok.add(felhasznalo);
            }

        }

        return felhasznalok;
    }

}
