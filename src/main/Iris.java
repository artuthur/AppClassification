package main;

import java.util.List;

import com.opencsv.bean.CsvBindByName;

/**
 *  Modèle de la classification Iris, décrit un iris avec ses attributs  et calule l'amplitude de ses caractéristiques. 
 * 
 * @author arthur.debacq.etu
 * @author bastien.warnier.etu
 * @author pierre.foulon3.etu
 * @author maxime.bimont.etu
 * 
 */

public class Iris {
	/**
	 * Longueur du sépale.
	 */
	@CsvBindByName(column = "sepal.length")
	public double sepalLength;
	/**
	 * Largeur du sépale.
	 */
	@CsvBindByName(column = "sepal.width")
	public double sepalWidth;
	/**
	 * Longueur de la pétale.
	 */
	@CsvBindByName(column = "petal.length")
	public double petalLength;
	/**
	 * Largeur de la pétale.
	 */
	@CsvBindByName(column = "petal.width")
	public double petalWidth;
	/**
	 * La variété de l'Iris.
	 */
	@CsvBindByName(column = "variety")
	public String variety;
	/**
	 * Attributs  utile à l'interface graphique.
	 */
	public static final String[] ATTRIBUTS = new String[] { "sepal_length", "sepal_width", "petal_length",
			"petal_width", "", "", "", "", "" };
	/**
	 * 	l'amplitude de la donnée SepalLength.
	 */
	public static double amplSepalLength;
	/**
	 * 	l'amplitude de la donnée SepalWidth.
	 */
	public static double amplSepalWidth;
	/**
	 * 	l'amplitude de la donnée PetalLength.
	 */
	public static double amplPetalLength;
	/**
	 * 	l'amplitude de la donnée PetalWidth.
	 */
	public static double amplPetalWidth;
	/**
	 * Créer un objet Iris accompagné de toutes ses caractèristiques.
	 * @see Iris#Iris()
	 * @param sepalLength La longueur de type double du sépale.
	 * @param sepalWidth La largeur de type double du sépale.
	 * @param petalLength La longueur de type double de la pétale.
	 * @param petalWidth La largeur de type double de la pétale.
	 * @param variety La variété de l'Iris contenue dans une chaîne de caractères.
	 */
	public Iris(double sepalLength, double sepalWidth, double petalLength, double petalWidth, String variety) {
		super();
		this.sepalLength = sepalLength;
		this.sepalWidth = sepalWidth;
		this.petalLength = petalLength;
		this.petalWidth = petalWidth;
		this.variety = variety;
	}
	/**
	 * Constructeur d'un objet Iris vide.
	 */
	public Iris() {

	}

	/**
	 * Méthode JAVAFX.
	 * 	Récupère l'attribut de l'Iris par rapport à l'emplacement dans la menuList. 
	 * @param x Numéro de l'emplacement de l'attribut dans le menulist.
	 * @return la valeur de la caractéristique correspodante au numéro de l'emplacement dans la menuList.
	 */
	public double getAttributs(int x) {
		double res = 0;
		if (x == 1)
			res = this.sepalLength;
		if (x == 2)
			res = this.sepalWidth;
		if (x == 3)
			res = this.petalLength;
		if (x == 4)
			res = this.petalWidth;
		return res;
	}

	/**
	 * Calcule l'amplitude du modele de données pour chaque caractéristiques en faisant la soustraction du de la valeur maximal de la donnée parmi toutes les iris à la valeur minimale de la donnée.  
	 * @param bouquet Une liste contenant tout les Iris (les lignes du CSV Iris).
	 */
	public static void calculAmpl(List<Iris> bouquet) {
		List<Iris> data = bouquet;
		Iris i1 = data.get(0);
		double sepalLengthMin = i1.sepalLength;
		double sepalLengthMax = i1.sepalLength;
		double sepalWidthMin = i1.sepalWidth;
		double sepalWidthMax = i1.sepalWidth;
		double petalLengthMin = i1.petalLength;
		double petalLengthMax = i1.petalLength;
		double petalWidthMin = i1.petalWidth;
		double petalWidthMax = i1.petalWidth;

		for (Iris i : data) {
			if (sepalLengthMin > i.sepalLength)
				sepalLengthMin = i.sepalLength;
			if (sepalLengthMax < i.sepalLength)
				sepalLengthMax = i.sepalLength;

			if (sepalWidthMin > i.sepalWidth)
				sepalWidthMin = i.sepalWidth;
			if (sepalWidthMax < i.sepalWidth)
				sepalWidthMax = i.sepalWidth;

			if (petalLengthMin > i.petalLength)
				petalLengthMin = i.petalLength;
			if (petalLengthMax < i.petalLength)
				petalLengthMax = i.petalLength;

			if (petalWidthMin > i.petalWidth)
				petalWidthMin = i.petalWidth;
			if (petalWidthMax < i.petalWidth)
				petalWidthMax = i.petalWidth;
		}

		amplSepalLength = sepalLengthMax - sepalLengthMin;
		amplSepalWidth = sepalWidthMax - sepalWidthMin;
		amplPetalLength = petalLengthMax - petalLengthMin;
		amplPetalWidth = petalWidthMax - petalWidthMin;

	}
	/**
	 * Affichage d'un objet Iris.
	 * @return la chaine de caractère présentant l'objet Iris ainsi que les valeurs de ses attributs.
	 */
	@Override
	public String toString() {
		return "Iris [sepal_length=" + sepalLength + ", sepal_width=" + sepalWidth + ", petal_length=" + petalLength
				+ ", petal_width=" + petalWidth + ", variety=" + variety + "]";
	}
	/**
	 * Accesseur de l'attribut SepalWidth de l'objet Iris.
	 * @return un double représentant l'attribut SepalLength de l'Iris c'est à dire la largeur de la sépale.
	 */
	public double getSepalLength() {
		return sepalLength;
	}
	/**
	 * Accesseur de l'attribut SepalWidth de l'objet Iris.
	 * @return un double représentant l'attribut SepalWidth de l'Iris c'est à dire la largeur du  sépale.
	 */
	public double getSepalWidth() {
		return sepalWidth;
	}
	/**
	 * Accesseur de l'attribut PetalLength de l'objet Iris.
	 * @return un double représentant l'attribut PetalLength de l'Iris c'est à dire la longueur de la pétale.
	 */
	public double getPetalLength() {
		return petalLength;
	}
	/**
	 * Accesseur de l'attribut PetalWidth de l'objet Iris.
	 * @return un double représentant l'attribut PetalWidth de l'Iris c'est à dire la largeur de la pétale.
	 */
	public double getPetalWidth() {
		return petalWidth;
	}
	/**
	 * Accesseur de l'attribut variety de l'objet Iris.
	 * @return la chaine de caratères contenant la varieté de l'Iris.
	 */
	public String getVariety() {
		return variety;
	}

}