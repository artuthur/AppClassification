package distance;

import java.util.Comparator;

import main.Titanic;
/**
 * Compare la distance entre deux objets Titanic par rapport à un troisième objet Titanic (l'attribut origine).
 * 
 * @author arthur.debacq.etu
 * @author bastien.warnier.etu
 * @author pierre.foulon3.etu
 * @author maxime.bimont.etu
 * 
 */
public class DistanceTitanicComparator implements Comparator<Titanic> {

	Titanic origine;
	/**
	 * Constructeur du Comparateur.
	 * @param origine Un objet Titanic qui va servir de comparateur entre deux objets Titanic.
	 */
	public DistanceTitanicComparator(Titanic origine){
		this.origine = origine;
	}
	/**
	 * @param t1 Un objet Titanic que l'on désire comparer la distance avec le Titanic comparateur (origine).
	 * @param t2 Un deuxième objet Titanic que l'on désire comparer la distance avec le Titanic comparateur (origine).
	 * @return un entier 0,-1 ou 1 selon si la distance entre l'objet titanic1 ou titanic2 par rapport au comparateur
	 * est égale(0), inférieur(-1) ou supérieur(1).
	 */
	@Override
	public int compare(Titanic t1, Titanic t2) {
		return Double.compare(DistanceTitanic.distanceEuclidienne(t1, origine),DistanceTitanic.distanceEuclidienne(t2, origine));
	}
	
}
