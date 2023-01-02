package distance;

import java.util.Comparator;

import main.Pokemon;
/**
 * Compare la distance entre deux objet Pokémon par rapport à un troisième objet Pokémon (l'attribut origine).
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
	 * @param origine Un objet Pokémon qui va servir de comparateur entre deux objet Pokémon.
	 */
	public DistancePokemonComparator(Pokemon origine){
		this.origine = origine;
	}
	/**
	 * @param p1 Un objet Pokémon que l'on désire comparer la distance avec le Pokémon comparateur (origine).
	 * @param p2 Un deuxième Pokémon que l'on désire comparer la distance avec le Pokémon comparateur (origine).
	 * @return un entier 0,-1 ou 1 selon si la distance entre le pokémon1 et le pokémon2 par rapport au comparateur
	 * est égale(0), inférieur(-1) ou supérieur(1).
	 */
	@Override
	public int compare(Pokemon p1, Pokemon p2) {
		return Double.compare(DistancePokemon.distanceEuclidienne(p1, origine),DistancePokemon.distanceEuclidienne(p2, origine));
	}
	
}
