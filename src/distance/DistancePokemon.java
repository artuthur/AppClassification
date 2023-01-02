package distance;

import main.MethodeKnn;
import main.Pokemon;
/**
 * Calcule la distance entre deux Pok�mon gr�ce � l'impl�mentation de l'interface Distance
 * et donc des deux m�thodes de calcul Manhattan et Euclidienne.
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
	 * @param p1 Un objet Pok�mon.
	 * @param p2 Un deuxi�me objet Pok�mon.
	 * @return La distance Euclidienne (double) entre deux Pok�mon gr�ce � l'amplitude des donn�es et une m�thode de normalisation de donn�es
	 * inclus dans la m�thode k-NN.
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
	 * @param p1 Un objet Pok�mon.
	 * @param p2 Un deuxi�me objet Pok�mon.
	 * @return La distance Manhattan (double) entre deux Pok�mon gr�ce � l'amplitude des donn�es et une m�thode de normalisation de donn�es
	 * inclus dans la classe M�thode k-NN.
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