package distance;

import java.util.Comparator;

import main.Pokemon;
/**
 * Compare la distance entre deux objet Pok�mon par rapport � un troisi�me objet Pok�mon (l'attribut origine).
 * 
 * @author arthur.debacq.etu
 * @author bastien.warnier.etu
 * @author pierre.foulon3.etu
 * @author maxime.bimont.etu
 *
 */
public class DistancePokemonComparator implements Comparator<Pokemon> {

	Pokemon origine;
	/**
	 * Constructeur du comparateur.
	 * @param origine Un objet Pok�mon qui va servir de comparateur entre deux objet Pok�mon.
	 */
	public DistancePokemonComparator(Pokemon origine){
		this.origine = origine;
	}
	/**
	 * @param p1 Un objet Pok�mon que l'on d�sire comparer la distance avec le Pok�mon comparateur (origine).
	 * @param p2 Un deuxi�me Pok�mon que l'on d�sire comparer la distance avec le Pok�mon comparateur (origine).
	 * @return un entier 0,-1 ou 1 selon si la distance entre le pok�mon1 et le pok�mon2 par rapport au comparateur
	 * est �gale(0), inf�rieur(-1) ou sup�rieur(1).
	 */
	@Override
	public int compare(Pokemon p1, Pokemon p2) {
		return Double.compare(DistancePokemon.distanceEuclidienne(p1, origine),DistancePokemon.distanceEuclidienne(p2, origine));
	}
	
}
