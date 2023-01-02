package test;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

import distance.DistanceIris;
import distance.DistancePokemon;
import distance.DistanceTitanic;
import main.ChargementDonneesUtil;
import main.Iris;
import main.Pokemon;
import main.Titanic;

class CalculDistanceTest {

	@Test
	void test_calcul_distance_pokemon() throws IOException {
		List<Pokemon> pokedex = ChargementDonneesUtil.chargerPokemon("ressources/csv/pokemon_test.csv");
		Pokemon.calculAmpl(pokedex);
		assertEquals(0.75, DistancePokemon.distanceEuclidienne(pokedex.get(0),pokedex.get(1)));
		assertEquals(1.1, DistancePokemon.distanceManhattan(pokedex.get(0),pokedex.get(1)));
	}
	
	@Test
	void test_calcul_distance_iris() throws IOException {
		List<Iris> bouquet = ChargementDonneesUtil.chargerIris("ressources/csv/iris.csv");
		Iris.calculAmpl(bouquet);
		assertEquals(0.21, DistanceIris.distanceEuclidienne(bouquet.get(0),bouquet.get(1)));
		assertEquals(0.21, DistanceIris.distanceManhattan(bouquet.get(0),bouquet.get(1)));
	}
	
	@Test
	void test_calcul_distance_titanic() throws IOException {
		List<Titanic> cimetiere = ChargementDonneesUtil.chargerTitanic("ressources/csv/titanic.csv");
		Titanic.calculAmpl(cimetiere);
		assertEquals(1.03, DistanceTitanic.distanceEuclidienne(cimetiere.get(0),cimetiere.get(1)));
		assertEquals(1.32, DistanceTitanic.distanceManhattan(cimetiere.get(0),cimetiere.get(1)));
	}

}
