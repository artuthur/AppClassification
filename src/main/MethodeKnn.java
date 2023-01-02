package main;

import java.io.IOException;
import java.util.List;

import distance.DistanceIrisComparator;
import distance.DistancePokemonComparator;
import distance.DistanceTitanicComparator;
/**
 *  Classifie les instances Pokémon, Iris, Titanic grâce au classifieur k-NN. 
 * 
 * @author arthur.debacq.etu
 * @author bastien.warnier.etu
 * @author pierre.foulon3.etu
 * @author maxime.bimont.etu
 *
 */
public class MethodeKnn {
	/**
	 * Liste des Pokémons.
	 */
	public static List<Pokemon> datasP;
	/**
	 * 	Liste des passagers du Titanic.
	 */
	public static List<Titanic> datasT;
	/**
	 * 	Liste des Iris.
	 */
	public static List<Iris> datasI;
	/**
	 *  Constructeur d'un objet MethodeKnn à partir du chemin du CSV.
	 * @param fileName Chemin d'accès au fichier CSV.
	 * @throws IOException Le fichier n'a pas été trouve par la méthode de chargement.
	 */
	@SuppressWarnings("static-access")
	public MethodeKnn(String fileName) throws IOException {
		MethodeKnn.datasP = ChargementDonneesUtil.chargerPokemon(fileName);
		MethodeKnn.datasT = ChargementDonneesUtil.chargerTitanic(fileName);
		MethodeKnn.datasI = ChargementDonneesUtil.chargerIris(fileName);
	}
	/**
	 * Constructeur d'un objet MethodeKnn à partir d'une liste de type Générique.
	 * @param data une liste de type générique.
	 * @throws IOException le type de la liste data ne correspond a aucun des type Iris, Pokémon, Titanic.
	 */
	@SuppressWarnings("unchecked")
	public MethodeKnn(List<?> data) throws IOException {
		MethodeKnn.datasP = (List<Pokemon>) data;
		MethodeKnn.datasT = (List<Titanic>) data;
		MethodeKnn.datasI = (List<Iris>) data;
	}
	/**
	 * La méthode des k voisins les plus proches. 
	 * @param k le nombre de voisins que l'on désire prendre pour le calcul de k-NN.
	 * @param pokemon Un pokémon que l'on va utiliser pour comparer la distance entre deux Pokémons afin de les trier avec la méthode sort.
	 * @return Une sous liste de la taille du nombre de voisins voulu contenant les Pokémons avec la distance les plus proches de l'instance à classifier. 
	 */
	public static List<Pokemon> calculKnnPokemon(int k, Pokemon pokemon) {
		List<Pokemon> datasSorted = datasP;
		datasSorted.sort(new DistancePokemonComparator(pokemon));
		return datasSorted.subList(0, k);
		
	}
	/**
	 * La méthode des k voisins les plus proches. 
	 * @param k le nombre de voisins que l'on désire prendre pour le calcul de k-NN.
	 * @param iris Un iris que l'on va utiliser pour comparer la distance entre deux Iris afin de les trier avec la méthode sort.
	 * @return Une sous liste de la taille du nombre de voisins voulu contenant les Iris avec la distance les plus proches de l'instance à classifier. 
	 */
	public static List<Iris> calculKnnIris(int k, Iris iris) {
		List<Iris> datasSorted = datasI;
		datasSorted.sort(new DistanceIrisComparator(iris));
		return datasSorted.subList(0, k);
	}
	/**
	 * La méthode des k voisins les plus proches. 
	 * @param k le nombre de voisins que l'on désire prendre pour le calcul de k-NN.
	 * @param titanic Un passager du Titanic que l'on va utiliser pour comparer la distance entre deux passagers afin de les trier avec la méthode sort.
	 * @return Une sous liste de la taille du nombre de voisins voulu contenant les passagers du Titanic avec la distance les plus proches de l'instance à classifier. 
	 */
	public static List<Titanic> calculKnnTitanic(int k, Titanic titanic) {
		List<Titanic> datasSorted = datasT;
		datasSorted.sort(new DistanceTitanicComparator(titanic));
		return datasSorted.subList(0, k);
	}
	/**
	 * Méthode de classification des Pokémons selon leur rareté légendaire ou non.
	 * @param k le nombre de voisins que l'on désire prendre pour la classification.
	 * @param pokemon Un pokémon qui servira à la méthode des plus proches voisins.
	 * @return la classification de l'instance Pokémon c'est à dire si il est ou non un Pokémon de rareté légendaire.
	 */
	public boolean isLegendary(int k, Pokemon pokemon) {
		List<Pokemon> kPokePlusProches = calculKnnPokemon(k, pokemon);
		int legendary = 0;
		int regular = 0;
		for (Pokemon p : kPokePlusProches) {
			if (p.isLegendary) {
				legendary++;
			} else {
				regular++;
			}
		}
		return legendary >= regular;
	}
	/**
	 * Méthode de classification des passagers du Titanic selon la surive de ceux-ci ou non.
	 * @param k le nombre de voisins que l'on désire prendre pour la classification.
	 * @param titanic Un passager du Titanic qui servira à la méthode des plus proches voisins.
	 * @return la classification de l'instance du passager du Titanic c'est à dire si il a survécu ou non..
	 */
	public boolean whoSurvive(int k, Titanic titanic) {
		List<Titanic> kPokePlusProches = calculKnnTitanic(k, titanic);
		int alive = 0;
		int dead = 0;
		for (Titanic t : kPokePlusProches) {
			if (t.survived) {
				dead++;
			} else {
				alive++;
			}
		}
		return dead >= alive;
	}
	/**
	 * Méthode de classification des Iris selon leur variété.
	 * @param k le nombre de voisins que l'on désire prendre pour la classification.
	 * @param iris Un Iris qui servira à la méthode des plus proches voisins.
	 * @return la classification de l'instance Iris c'est à dire sa variété.
	 */
	public String whatVariety(int k, Iris iris) {
		List<Iris> kPokePlusProches = calculKnnIris(k, iris);
		String res = "";
		int setosa = 0;
		int virginica = 0;
		int versicolor = 0;
		for (Iris i : kPokePlusProches)
			if (i.getVariety().equals("Setosa"))
				setosa++;
			else if (i.getVariety().equals("Virginica"))
				virginica++;
			else
				versicolor++;

		if (compareVariety(setosa, virginica, versicolor) == -1)
			res = "Setosa";
		else if (compareVariety(setosa, virginica, versicolor) == 0)
			res = "Virginica";
		else
			res = "Versicolor";
		
		return res;
	}
	/**
	 * Méthode qui compare le nombre de variété trouvé entre tout les voisins de la méthode de classification afin de trancher sur la classification..
	 * @param a un entier correspondant au nombre d'une variété. trouvé parmi tout les voisins.
	 * @param b un entier correspondant au nombre d'une variété trouvé parmi tout les voisins.
	 * @param c un entier correspondant au nombre d'une variété trouvé parmi tout les voisins.
	 * @return un entier correspondant à la variété.
	 */
	public int compareVariety(int a, int b, int c) {
		int res;
		if (a >= b && a >= c) {
			res = -1;
		} else if (b >= a && b >= c) {
			res = 0;
		} else {
			res = 1;
		}
		return res;
	}
	/**
	 * Méthode de normalisation des données.
	 * @param val1 la donnée à normaliser appartenant à l'Objet 1.
	 * @param val2 la donnée à normaliser appartenant à l'Objet 2.
	 * @param ampl l'amplitude de la donnée c'est à dire le résultat de la différence entre la valeur maximal et la minimal de cette meme donnée parmi tout les objets.
	 * @return un double correspondant à la valeur de la données normaliser.
	 */
	public static double normaliser_0_1(double val1, double val2, double ampl) {
		return (val1 - val2) / ampl;
	}
}
