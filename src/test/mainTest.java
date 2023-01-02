package test;

import java.io.IOException;
import java.util.List;

import main.ChargementDonneesUtil;
import main.Iris;
import main.Pokemon;
import main.Titanic;

public class mainTest {
	
	public static void main(String[] args) throws IOException {
		List<Titanic> cimetiere = ChargementDonneesUtil.chargerTitanic("ressources/csv/titanic.csv");
		List<Iris> bouquet = ChargementDonneesUtil.chargerIris("ressources/csv/iris.csv");
		List<Pokemon> pokedex = ChargementDonneesUtil.chargerPokemon("ressources/csv/pokemon_test.csv");
		
		System.out.println("Titanic : " + cimetiere.get(0).toString());
		System.out.println("Iris : " + bouquet.get(0).toString());
		System.out.println("Pokemon : " + pokedex.get(0).toString());
	}

}
