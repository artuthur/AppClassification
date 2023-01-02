package distance;

import java.util.Comparator;

import main.Iris;
/**
 * Compare la distance entre deux objets Iris par rapport � un troisi�me objet Iris (l'attribut origine).
 * 
 * @author arthur.debacq.etu
 * @author bastien.warnier.etu
 * @author pierre.foulon3.etu
 * @author maxime.bimont.etu
 * 
 */
public class DistanceIrisComparator implements Comparator<Iris> {

	Iris origine;
	/**
	 * Constructeur du Comparateur.
	 * @param origine Un objet Iris qui va servir de comparateur entre deux objet Iris.
	 */
	public DistanceIrisComparator(Iris origine){
		this.origine = origine;
	}
	/**
	 * @param i1 Un objet Iris que l'on d�sire comparer la distance avec l'Iris comparateur (origine).
	 * @param i2 Un deuxi�me Iris que l'on d�sire comparer la distance avec l'Iris comparateur (origine). 
	 * @return un entier 0,-1 ou 1 selon si la distance entre l'iris1 ou l'iris2 par rapport au comparateur
	 * est �gale(0), inf�rieur(-1) ou sup�rieur(1). 
	 */
	@Override
	public int compare(Iris i1, Iris i2) {
		return Double.compare(DistanceIris.distanceEuclidienne(i1, origine),DistanceIris.distanceEuclidienne(i2, origine));
	}
	
}
