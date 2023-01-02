package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.io.StringReader;

import org.junit.jupiter.api.Test;

import main.MethodeKnn;

class LecturePokemonTest {

	@Test
	void LectureCsvTest() throws IOException {
		MethodeKnn knn = new MethodeKnn("ressources/csv/pokemon_train.csv");
		assertEquals("Dialga", knn.datasP.get(12).name);
		assertEquals(145, knn.datasP.get(11).spDefense);
	}

}
