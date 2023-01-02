package main;

import java.io.IOException;
import java.util.List;
/**
 * Calcule la robustesse de chacune des m�thodes de classification de chaque instance (Pok�mon,Iris,Titanic).
 * 
 * @author arthur.debacq.etu
 * @author bastien.warnier.etu
 * @author pierre.foulon3.etu
 * @author maxim.bimont.etu
 * 
 */
public class ValidationKnn {
	/**
	 *  Calcule la robustesse de la m�thode de classification des Pok�mon via un ensemble de test.
	 * @param m Un objet MethodeKnn qui va nous permettre d'utiliser les m�thode de classification.
	 * @param ensembleTest La liste de test contenant l'enti�ret� des Pok�mons.
	 * @param k Le nombre de voisins que l'on d�sire pour la m�thode de classification.
	 * @return un double repr�sentant le pourcentage de r�ussite de classification par rapport a un ensemble de test. 
	 * @throws IOException Le fichier CSV de donn�es de test n'a pas �t� trouv� par la m�thode de charghement de donn�es (contenu dans la classe MethodeKnn et les m�thodes de classifications)
	 */
	public static double pourcentageReussitePokemon(MethodeKnn m, List<Pokemon> ensembleTest, int k)
			throws IOException {
		int resultatsValides = 0;
		for (Pokemon p : ensembleTest) {
			if (m.isLegendary(k, p) == p.isLegendary) {
				resultatsValides++;
			}
		}
		return (resultatsValides * 1.0 / ensembleTest.size() * 1.0) * 100.0;
	}
	/**
	 * Calcule la robustesse de la m�thode de classification des passagers du Titanic  via un ensemble de test.
	 * @param m Un objet MethodeKnn qui va nous permettre d'utiliser les m�thode de classification.
	 * @param ensembleTest La liste de test contenant l'enti�ret� des passagers du Titanic.
	 * @param k Le nombre de voisins que l'on d�sire pour la m�thode de classification.
	 * @return un double repr�sentant le pourcentage de r�ussite de classification par rapport a un ensemble de test. 
	 * @throws IOException Le fichier CSV de donn�es de test n'a pas �t� trouv� par la m�thode de charghement de donn�es (contenu dans la classe MethodeKnn et les m�thodes de classifications).
	 */
	public static double pourcentageReussiteTitanic(MethodeKnn m, List<Titanic> ensembleTest, int k)
			throws IOException {
		int resultatsValides = 0;
		for (Titanic p : ensembleTest) {
			if (m.whoSurvive(k, p) == p.survived) {
				resultatsValides++;
			}
		}
		return (resultatsValides * 1.0 / ensembleTest.size() * 1.0) * 100.0;
	}
	/**
	 * Calcule la robustesse de la m�thode de classification des Iris via un ensemble de test.
	 * @param m Un objet MethodeKnn qui va nous permettre d'utiliser les m�thode de classification.
	 * @param ensembleTest La liste de test contenant l'enti�ret� des Iris.
	 * @param k Le nombre de voisins que l'on d�sire pour la m�thode de classification.
	 * @return un double repr�sentant le pourcentage de r�ussite de classification par rapport a un ensemble de test. 
	 * @throws IOException Le fichier CSV de donn�es de test n'a pas �t� trouv� par la m�thode de charghement de donn�es (contenu dans la classe MethodeKnn et les m�thodes de classifications).
	 */
	public static double pourcentageReussiteIris(MethodeKnn m, List<Iris> ensembleTest, int k) throws IOException {
		int resultatsValides = 0;
		for (Iris p : ensembleTest) {
			if (m.whatVariety(k, p).equals(p.variety)) {
				resultatsValides++;
			}
		}
		return (resultatsValides * 1.0 / ensembleTest.size() * 1.0) * 100.0;
	}
	/**
	 * Calcule le nombre de voisins n�cessaires pour atteindre un pourcentage de reussite maximale. 
	 * @return un entier repr�sentant le nombre de voisins o� le pourcentage de reussit� de la m�thode de classification est � son paroxysme.
	 * @throws IOException Le fichier CSV de donn�es de test n'a pas �t� trouv� par la m�thode de charghement de donn�es (contenu dans la classe MethodeKnn et les m�thodes de classifications).
	 */
	public static int robustePokemon() throws IOException {
		MethodeKnn m = new MethodeKnn("ressources/csv/pokemon_train.csv");
		List<Pokemon> ensembleTest = ChargementDonneesUtil.chargerPokemon("ressources/csv/pokemon_test.csv");
		double precisionMax = 0;
		int kMax = 0;
		for (int i = 0; i < ensembleTest.size(); i++) {
			double currentPrctReussite = pourcentageReussitePokemon(m, ensembleTest, i);
			if (currentPrctReussite > precisionMax) {
				precisionMax = currentPrctReussite;
				kMax = i;
			}
		}
		return kMax;
	}
	/**
	 * Calcule le nombre de voisins n�cessaires pour atteindre un pourcentage de reussite maximale. 
	 * @return un entier repr�sentant le nombre de voisins o� le pourcentage de reussit� de la m�thode de classification est � son paroxysme.
	 * @throws IOException Le fichier CSV de donn�es de test n'a pas �t� trouv� par la m�thode de charghement de donn�es (contenu dans la classe MethodeKnn et les m�thodes de classifications).
	 */
	public static int robusteTitanic() throws IOException {
		MethodeKnn m = new MethodeKnn("ressources/csv/titanic.csv");
		List<Titanic> ensembleTest = ChargementDonneesUtil.chargerTitanic("ressources/csv/titanic.csv");
		double precisionMax = 0;
		int kMax = 0;
		for (int i = 0; i < ensembleTest.size(); i++) {
			double currentPrctReussite = pourcentageReussiteTitanic(m, ensembleTest, i);
			if (currentPrctReussite > precisionMax) {
				precisionMax = currentPrctReussite;
				kMax = i;
			}
		}
		return kMax;
	}
	/**
	 * Calcule le nombre de voisins n�cessaires pour atteindre un pourcentage de reussite maximale. 
	 * @return un entier repr�sentant le nombre de voisins o� le pourcentage de reussit� de la m�thode de classification est � son paroxysme.
	 * @throws IOException Le fichier CSV de donn�es de test n'a pas �t� trouv� par la m�thode de charghement de donn�es (contenu dans la classe MethodeKnn et les m�thodes de classifications).
	 */
	public static int robusteIris() throws IOException {
		MethodeKnn m = new MethodeKnn("ressources/csv/iris.csv");
		List<Iris> ensembleTest = ChargementDonneesUtil.chargerIris("ressources/csv/iris.csv");
		double precisionMax = 0;
		int kMax = 0;
		for (int i = 0; i < ensembleTest.size(); i++) {
			double currentPrctReussite = pourcentageReussiteIris(m, ensembleTest, i);
			if (currentPrctReussite > precisionMax) {
				precisionMax = currentPrctReussite;
				kMax = i;
			}
		}
		return kMax;
	}
	/**
	 * Permet d'�xecuter les m�thodes de robustesse.
	 * @param args
	 * @throws IOException Le fichier CSV de donn�es d'apprentissage ou de test n'a pas �t� trouv�.
	 */
	public static void main(String[] args) throws IOException {
		MethodeKnn mkk = new MethodeKnn("ressources/csv/pokemon_train.csv");
		List<Pokemon> data = ChargementDonneesUtil.chargerPokemon("ressources/csv/pokemon_train.csv");
		int rp = robustePokemon();
		System.out.println("[Pokemon] k : " + rp + " avec un % de : " + pourcentageReussitePokemon(mkk, data, rp));

		MethodeKnn mkkT = new MethodeKnn("ressources/csv/titanic.csv");
		List<Titanic> dataT = ChargementDonneesUtil.chargerTitanic("ressources/csv/titanic.csv");
		int rt = robusteTitanic();
		System.out.println("[Titanic] k : " + rt + " avec un % de : " + pourcentageReussiteTitanic(mkkT, dataT, rt));

		MethodeKnn mkkI = new MethodeKnn("ressources/csv/iris.csv");
		List<Iris> dataI = ChargementDonneesUtil.chargerIris("ressources/csv/iris.csv");
		int ri = robusteIris();
		System.out.println("[Iris] k : " + ri + " avec un % de : " + pourcentageReussiteIris(mkkI, dataI, ri));
	}

}
