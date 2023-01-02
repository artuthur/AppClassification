package distance;

import main.Iris;
import main.MethodeKnn;
/**
 *  Calcule la distance entre deux Iris grâce à l'implémentation de l'interface Distance
 * et donc des deux méthodes de calcul Manhattan et Euclidienne.
 * 
 * @author arthur.debacq.etu
 * @author bastien.warnier.etu
 * @author pierre.foulon3.etu
 * @author maxime.bimont.etu
 * 
 */
public class DistanceIris implements Distance {
	/**
	 * 
	 * @param p1 Un objet Iris.
	 * @param p2 Un deuxième objet Iris.  
	 * @return La distance Euclidienne (double) entre deux Iris grâce à  l'amplitude des donnéees et une méthode de normalisation de donnéees 
	 * inclus dans la classe Méthode k-NN.
	 * 
	 */
	public static double distanceEuclidienne(Iris p1, Iris p2) {
		double res = 0.0;
		res += Math.pow(MethodeKnn.normaliser_0_1(p2.amplPetalLength, p1.amplPetalLength, Iris.amplPetalLength), 2);
		res += Math.pow(MethodeKnn.normaliser_0_1(p2.sepalWidth, p1.sepalWidth, Iris.amplPetalWidth), 2);
		res += Math.pow(MethodeKnn.normaliser_0_1(p2.petalLength, p1.petalLength, Iris.amplPetalLength), 2);
		res += Math.pow(MethodeKnn.normaliser_0_1(p2.petalWidth, p1.petalWidth, Iris.amplPetalWidth), 2);
		return Math.round(Math.sqrt(res)*100.0)/100.0;

	}
	/**
	 * 
	 * @param p1 Un objet Iris.
	 * @param p2 Un deuxième objet Iris.
	 * @return La distance Manhattan (double) entre deux Iris grâce à  l'amplitude des données et une méthode de normalisation de données 
	 * inclus dans la classe Méthode k-NN.
	 */
	public static Double distanceManhattan(Iris p1, Iris p2) {
		double res = 0.0;
		res += Math.abs(MethodeKnn.normaliser_0_1(p2.amplPetalLength, p1.amplPetalLength, Iris.amplPetalLength));
		res += Math.abs(MethodeKnn.normaliser_0_1(p2.sepalWidth, p1.sepalWidth, Iris.amplPetalWidth));
		res += Math.abs(MethodeKnn.normaliser_0_1(p2.petalLength, p1.petalLength, Iris.amplPetalLength));
		res += Math.abs(MethodeKnn.normaliser_0_1(p2.petalWidth, p1.petalWidth, Iris.amplPetalWidth));
		return Math.round(res*100.0)/100.0;
	}

}