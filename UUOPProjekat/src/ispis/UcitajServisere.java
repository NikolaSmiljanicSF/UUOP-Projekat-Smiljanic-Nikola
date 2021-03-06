package ispis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import enumeracije.Pol;
import enumeracije.specijalizacija;
import model.Serviser;

public class UcitajServisere {
	
	public static ArrayList<Serviser> prikaziServisere() { 
		
		
		ArrayList<Serviser> serviseri = new ArrayList<Serviser>();
		
		try {
				
		File file = new File("src/fajlovi/serviseri.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line;
		while((line = reader.readLine()) != null) {
			String[] lineSplit = (line.split("\\|"));
			int id = Integer.parseInt(lineSplit[0]);
			String ime = lineSplit[1];
			String prezime = lineSplit[2];
			String jmbg = lineSplit[3];
			Pol pol = enumeracije.Pol.valueOf(lineSplit[4]);
			String adresa = lineSplit[5];
			String brojTelefona = lineSplit[6];
			String korisnickoIme = lineSplit[7];
			String lozinka = lineSplit[8];
			double plata = Double.parseDouble(lineSplit[9]);
			specijalizacija specijalizacija = enumeracije.specijalizacija.valueOf(lineSplit[10]);
			int isDeleted = Integer.parseInt(lineSplit[11]);
			Serviser serviser1 = new Serviser(id, ime, prezime, jmbg, pol, adresa, brojTelefona, korisnickoIme, lozinka, plata, specijalizacija, isDeleted);
			serviseri.add(serviser1);
		}
		reader.close(); 
	} catch(IOException e) {
		System.out.println("Greska!");
	}
		return serviseri;
	}
}

