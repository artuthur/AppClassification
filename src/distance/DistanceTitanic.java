package distance;

import main.MethodeKnn;
import main.Titanic;
/**
 * Calcule la distance entre deux objet Titanic grâce à  l'implémentation de l'interface Distance
 * et donc des deux méthodes de calcul Manhattan et Euclidienne.
 * 
 * @author arthur.debacq.etu
 * @author bastien.warnier.etu
 * @author pierre.foulon3.etu
 * @author maxime.bimont.etu
 * 
 */
public class DistanceTitanic implements Distance {

	/**
	 * 
	 * @param p1 Un objet Titanic.
	 * @param p2 Un deuxième objet Titanic.
	 * @return La distance Euclidienne (double) entre deux Titanic grâce à l'amplitude des données et une métgode de normalisation de données
	 * inclus dans la classe Méthode k-NN.
	 * 
	 */
	public static double distanceEuclidienne(Titanic p1, Titanic p2) {
		double res = 0.0;
		res += Math.pow(MethodeKnn.normaliser_0_1(p2.pClass, p1.pClass, Titanic.amplPClass), 2);
		res += Math.pow(MethodeKnn.normaliser_0_1(p2.age, p1.age, Titanic.amplAge), 2);
		res += Math.pow(MethodeKnn.normaliser_0_1(p2.sibSp, p1.sibSp, Titanic.amplSibSp), 2);
		res += Math.pow(MethodeKnn.normaliser_0_1(p2.parch, p1.parch, Titanic.amplParch), 2);
		res += Math.pow(MethodeKnn.normaliser_0_1(p2.fare, p1.fare, Titanic.amplFare), 2);
		return Math.round(Math.sqrt(res)*100.0)/100.0;

	}

	/**
	 * 
	 * @param p1 Un objet Titanic.
	 * @param p2 Un deuxième objet Titanic.
	 * @return La distance Manhattan (double) entre deux Titanic grâce à l'amplitude des données et une méthode de normalisation de données
	 * inclus dans la classe Méthode k-NN.
	 * 
	 */
	public static Double distanceManhattan(Titanic p1, Titanic p2) {
		double res = 0.0;
		res += Math.abs(MethodeKnn.normaliser_0_1(p2.pClass, p1.pClass, Titanic.amplPClass));
		res += Math.abs(MethodeKnn.normaliser_0_1(p2.age, p1.age, Titanic.amplAge));
		res += Math.abs(MethodeKnn.normaliser_0_1(p2.sibSp, p1.sibSp, Titanic.amplSibSp));
		res += Math.abs(MethodeKnn.normaliser_0_1(p2.parch, p1.parch, Titanic.amplParch));
		res += Math.abs(MethodeKnn.normaliser_0_1(p2.fare, p1.fare, Titanic.amplFare));
		return Math.round(res*100.0)/100.0;
	}

}