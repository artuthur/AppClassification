package distance;

import main.MethodeKnn;
import main.Pokemon;
/**
 * Calcule la distance entre deux Pokémon grâce à l'implémentation de l'interface Distance
 * et donc des deux méthodes de calcul Manhattan et Euclidienne.
 * 
 * @author arthur.debacq.etu
 * @author bastien.warnier.etu
 * @author pierre.foulon3.etu
 * @author maxime.bimont.etu
 *
 */
public class DistancePokemon implements Distance {

	/**
	 * 
	 * @param p1 Un objet Pokémon.
	 * @param p2 Un deuxième objet Pokémon.
	 * @return La distance Euclidienne (double) entre deux Pokémon grâce à l'amplitude des données et une méthode de normalisation de données
	 * inclus dans la méthode k-NN.
	 */
	
	public static double distanceEuclidienne(Pokemon p1, Pokemon p2) {
		double res = 0.0;
		res += Math.pow(MethodeKnn.normaliser_0_1(p2.baseEggSteps, p1.baseEggSteps, Pokemon.amplBaseEggSteps), 2);
		res += Math.pow(MethodeKnn.normaliser_0_1(p2.captureRate, p1.captureRate, Pokemon.amplCaptureRate), 2);
		res += Math.pow(MethodeKnn.normaliser_0_1(p2.experienceGrowth, p1.experienceGrowth, Pokemon.amplExperienceGrowth), 2);
		res += Math.pow(MethodeKnn.normaliser_0_1(p2.speed, p1.speed, Pokemon.amplSpeed), 2);
		return Math.round(Math.sqrt(res)*100.0)/100.0;

	}

	/**
	 * 
	 * @param p1 Un objet Pokémon.
	 * @param p2 Un deuxième objet Pokémon.
	 * @return La distance Manhattan (double) entre deux Pokémon grâce à  l'amplitude des données et une méthode de normalisation de données
	 * inclus dans la classe Méthode k-NN.
	 */
	public static Double distanceManhattan(Pokemon p1, Pokemon p2) {
		double res = 0.0;
		res += Math.abs(MethodeKnn.normaliser_0_1(p2.baseEggSteps, p1.baseEggSteps, Pokemon.amplBaseEggSteps));
		res += Math.abs(MethodeKnn.normaliser_0_1(p2.captureRate, p1.captureRate, Pokemon.amplCaptureRate));
		res += Math.abs(MethodeKnn.normaliser_0_1(p2.experienceGrowth, p1.experienceGrowth, Pokemon.amplExperienceGrowth));
		res += Math.abs(MethodeKnn.normaliser_0_1(p2.speed, p1.speed, Pokemon.amplSpeed));
		return Math.round(res*100.0)/100.0;
	}

}