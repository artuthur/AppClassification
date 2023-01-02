package test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import org.junit.jupiter.api.Test;

public class LectureCSVTest {

	@Test
	public void check_lectureIrisTest() throws IOException {
		BufferedReader firstLineIris = new BufferedReader(Files.newBufferedReader(Paths.get("ressources/csv/iris.csv")));
		assertEquals(firstLineIris.readLine() , "\"sepal.length\",\"sepal.width\",\"petal.length\",\"petal.width\",\"variety\"");
	}
	
	@Test
	void check_lecturePokemonTest() throws IOException {
		BufferedReader firstLinePokemon = new BufferedReader(Files.newBufferedReader(Paths.get("ressources/csv/pokemon_train.csv")));
		assertEquals(firstLinePokemon.readLine(), "name,attack,base_egg_steps,capture_rate,defense,experience_growth,hp,sp_attack,sp_defense,type1,type2,speed,is_legendary");
	}
	
	
	@Test
	public void check_lectureTitanicTest() throws IOException {
		BufferedReader firstLineTitanic = new BufferedReader(Files.newBufferedReader(Paths.get("ressources/csv/titanic.csv")));
		assertEquals(firstLineTitanic.readLine(), "PassengerId,Survived,Pclass,Name,Sex,Age,SibSp,Parch,Ticket,Fare,Cabin,Embarked");
	}
}