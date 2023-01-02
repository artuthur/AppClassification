package main;

import java.io.IOException;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import com.opencsv.bean.CsvToBeanBuilder;

/**
 * Charge les données contenues dans un fichier CSV, une méthode par Objet (Pokémon/Iris/Titanic).
 * 
 * @author arthur.debacq.etu
 * @author bastien.warnier.etu
 * @author pierre.foulon3.etu
 * @author maxime.bimont.etu * 
 * 
 */

public class ChargementDonneesUtil {
	/**
	 * Méthode générique de chargement des données qui renvoie le bon type de chargement de données en fonction de la premiere ligne du CSV. 
	 * @param fileName Le chaine de caractère contenant le chemin du fichier CSV.
	 * @throws IOException Le fichier CSV n'a pas été trouvé par le BuffuredReader.
	 * @return Retourne la liste correspondant au type de données contenues dans le CSV
	 * @deprecated
	 */
	/*public static List<?> checkWhatType(String fileName) throws IOException {
		BufferedReader firstLineOfCsv = new BufferedReader(Files.newBufferedReader(Paths.get(fileName)));
		String firstLineOfPokemon = "name,attack,base_egg_steps,capture_rate,defense,experience_growth,hp,sp_attack,sp_defense,type1,type2,speed,is_legendary";
		String firstLineOfIris = "\"sepal.length\",\"sepal.width\",\"petal.length\",\"petal.width\",\"variety\"";
		String firstLineOfTitanic = "PassengerId,Survived,Pclass,Name,Sex,Age,SibSp,Parch,Ticket,Fare,Cabin,Embarked";
		String firstLine = firstLineOfCsv.readLine();
		if (firstLine.equals(firstLineOfTitanic)) {
			return chargerTitanic(fileName);
		} else if (firstLine.equals(firstLineOfIris)) {
			return chargerIris(fileName);
		} else if (firstLine.equals(firstLineOfPokemon)) {
			return chargerPokemon(fileName);
		}
		else return null;
	}
*/
	/**
	 * Renvoie une liste de Pokémon via la méthode de Chargement de données Pokémon à partir du CSV.
	 * @param fileName Le chemin d'accès au fichier CSV Pokémon.
	 * @return Renvoie vers la méthode de chargement correspondante de la librairie OpenCSV
	 * @throws IOException Le fichier CSV Pokémon n'a pas été trouvé par le BuffuredReader.
	 */
	public static List<Pokemon> chargerPokemon(String fileName) throws IOException {
		return chargerPokemon(Files.newBufferedReader(Paths.get(fileName)));
	}
	/**
	 *  Renvoie une liste de Iris via la méthode de Chargement de données Iris à partir du CSV.
	 * @param fileName Le chemin d'accès au fichier CSV Iris.
	 * @return Renvoie vers la méthode de chargement correspondante de la librairie OpenCSV
	 * @throws IOException Le fichier CSV Iris n'a pas été trouvé par le BuffuredReader.
	 */
	public static List<Iris> chargerIris(String fileName) throws IOException {
		return chargerIris(Files.newBufferedReader(Paths.get(fileName)));
	}
	/**
	 *  Renvoie une liste de passager TItanic via la méthode de Chargement de données Titanic à partir du CSV.
	 * @param fileName Le chemin d'accès au fichier CSV Titanic.
	 * @return Renvoie vers la méthode de chargement correspondante de la librairie OpenCSV
	 * @throws IOException Le fichier CSV Titanic  n'a pas été trouvé par le BuffuredReader.
	 */
	public static List<Titanic> chargerTitanic(String fileName) throws IOException {

		return chargerTitanic(Files.newBufferedReader(Paths.get(fileName)));
	}
	/**
	 * 	Construit une liste de Pokémon avec la libraire openCSV à partir du reader.
	 * @param reader Un objet Reader qui contient les lignes du fichier CSV Pokémon.
	 * @return La liste contenant toutes les données Pokémon du fichier CSV.
	 */
	public static List<Pokemon> chargerPokemon(Reader reader) {
		return new CsvToBeanBuilder<Pokemon>(reader).withSeparator(',').withType(Pokemon.class).build().parse();
	}
	/**
	 * Construit une liste de Titanic avec la libraire openCSV à partir du reader.
	 * @param reader Un objet Reader qui contient les lignes du fichier CSV Titanic.
	 * @return La liste contenant toutes les données Titanic du fichier CSV
	 */
	public static List<Titanic> chargerTitanic(Reader reader) {
		return new CsvToBeanBuilder<Titanic>(reader).withSeparator(',').withType(Titanic.class).build().parse();
	}
	/**
	 * Construit une liste de Iris avec la libraire openCSV à partir du reader.
	 * @param reader  Un objet Reader qui contient les lignes du fichier CSV Iris.
	 * @return La liste contenant toutes les données Irisdu fichier CSV
	 */
	public static List<Iris> chargerIris(Reader reader) {
		return new CsvToBeanBuilder<Iris>(reader).withSeparator(',').withType(Iris.class).build().parse();
	}

}