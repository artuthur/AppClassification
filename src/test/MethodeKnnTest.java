package test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.io.IOException;
import java.util.List;

import org.junit.jupiter.api.Test;

import main.ChargementDonneesUtil;
import main.MethodeKnn;
import main.Pokemon;

class MethodeKnnTest {

	@Test
	void test_constructor_knn() throws IOException {
		List<Pokemon> test = ChargementDonneesUtil.chargerPokemon("ressources/csv/pokemon_train.csv");
		MethodeKnn k = new MethodeKnn(test);
	}
	
	@Test
	void test_is_legendary() throws IOException {
		MethodeKnn mkk = new MethodeKnn("ressources/csv/pokemon_train.csv");
		System.out.println("pokemon1 : " + mkk.datasP.get(12));
		assertTrue(mkk.isLegendary(6, mkk.datasP.get(12)));
		System.out.println("pokemon2 : " + mkk.datasP.get(15));
		assertFalse(mkk.isLegendary(7, mkk.datasP.get(15)));
	}
	
	@Test
	void test_who_survive() throws IOException {
		MethodeKnn mkk = new MethodeKnn("ressources/csv/titanic.csv");
		System.out.println("passenger1 : " + mkk.datasT.get(12));
		
		assertTrue(mkk.whoSurvive(6, mkk.datasT.get(12)));
		System.out.println("passenger2 : " + mkk.datasT.get(1));
		assertFalse(mkk.whoSurvive(7, mkk.datasT.get(1)));
	}
	
	@Test
	void test_what_variety() throws IOException {
		MethodeKnn mkk = new MethodeKnn("ressources/csv/iris.csv");
		System.out.println("iris1 : " + mkk.datasI.get(1));
		assertEquals("Setosa",mkk.whatVariety(6, mkk.datasI.get(1)));
		System.out.println("iris2 : " + mkk.datasI.get(143));
		assertEquals("Virginica",mkk.whatVariety(6, mkk.datasI.get(115)));
	}

}
