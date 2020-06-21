package ispis;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import CRUD.CRUDOperacije;
import enumeracije.marka;
import enumeracije.model;
import model.Automobil;
import model.ServisAutomobila;
import model.ServisnaKnjizica;
import model.ServisniDeo;

public class UcitajServisneDelove {
	
public static ArrayList<ServisniDeo> prikaziServisneDelove() { 
		
		CRUDOperacije crudoperacije = new CRUDOperacije();
	
	ArrayList<ServisniDeo> servisnidelovi = new ArrayList<ServisniDeo>();
	try {
		File file = new File("src/fajlovi/servisnidelovi.txt");
		BufferedReader reader = new BufferedReader(new FileReader(file));
		String line;
		while((line = reader.readLine()) != null){
			String[] lineSplit = (line.split("\\|"));
			int id = Integer.parseInt(lineSplit[0]);
			marka marka = enumeracije.marka.valueOf(lineSplit[1]);
			model model = enumeracije.model.valueOf(lineSplit[2]);
			int cena = Integer.parseInt(lineSplit[3]);
			String naziv = lineSplit[4];
			ServisniDeo servisnideo1 = new ServisniDeo(id, marka, model, cena, naziv);
			servisnidelovi.add(servisnideo1);	
		}
			reader.close();
		} catch(IOException e) {
			System.out.println("Desila se greska!");
		}
		return servisnidelovi;
			
	}	
}
