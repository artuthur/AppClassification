package main;

import java.util.List;

import com.opencsv.bean.CsvBindByName;

/**
 *  Modèle de la classification Pokémon, décrit un Pokémon avec ses attributs et calule l'amplitude de ses caractéristiques. 
 * 
 * @author arthur.debacq.etu
 * @author bastien.warnier.etu
 * @author pierre.foulon3.etu
 * @author maxime.bimont.etu
 * 
 */

public class Pokemon  {
	/**
	 * Le nom du Pokémon.
	 */
	@CsvBindByName(column = "name")
	public String name;
	/**
	 * Le nom du Pokémon.
	 */
	@CsvBindByName(column = "attack")
	public int attack;
	/**
	 * Le nom du Pokémon.
	 */
	@CsvBindByName(column = "base_egg_steps")
	public int baseEggSteps;
	/**
	 * Le nom du Pokémon.
	 */
	@CsvBindByName(column = "capture_rate")
	public double captureRate;
	/**
	 * Le nom du Pokémon.
	 */
	@CsvBindByName(column = "defense")
	public int defense;
	/**
	 * L'experience que gagne le pokémon.
	 */
	@CsvBindByName(column = "experience_growth")
	public int experienceGrowth;
	/**
	 * Le nombre de points de vie du Pokémon.
	 */
	@CsvBindByName(column = "hp")
	public int hp;
	/**
	 * Les dégats de l'attaque spéciale du Pokémon.
	 */
	@CsvBindByName(column = "sp_attack")
	public int spAttack;
	/**
	 * La défense spéciale du Pokémon.
	 */
	@CsvBindByName(column = "sp_defense")
	public int spDefense;
	/**
	 * Le type premier du Pokémon.
	 */
	@CsvBindByName(column = "type1")
	public String type1;
	/**
	 * Le type secondaire du Pokémon.
	 */
	@CsvBindByName(column = "type2")
	public String type2;
	/**
	 * Le vitesse du Pokémon.
	 */
	@CsvBindByName(column = "speed")
	public double speed;
	/**
	 * La rareté légendaire ou non du Pokémon.
	 */
	@CsvBindByName(column = "is_legendary")
	public boolean isLegendary;
	/**
	 * Attributs  utile à l'interface graphique.
	 */
	public static final String[] ATTRIBUTSALL = new String[] {"name","attack","baseEggSteps","captureRate","defense","experienceGrowth","hp","spAttack","spDefense","type1","type2","speed"};
	/**
	 * Attributs  utile à l'interface graphique.
	 */
	public static final String[] ATTRIBUTS = new String[] {"attack","baseEggSteps","captureRate","defense","experienceGrowth","hp","spAttack","spDefense","speed"};
	/**
	 * 	l'amplitude de la donnéeBaseEggSteps.
	 */
	public static double amplBaseEggSteps;
	/**
	 * 	l'amplitude de la donnée CaptureRate.
	 */
	public static double amplCaptureRate;
	/**
	 * 	l'amplitude de la donnée ExperienceGrowth.
	 */
	public static double amplExperienceGrowth;
	/**
	 * 	l'amplitude de la donnée Speed.
	 */
	public static double amplSpeed;
	/**
	 * Créer un objet Pokémon accompagné de toutes ses caractèristiques.
	 * @see Pokemon#Pokemon()
	 * @param name Le nom du Pokémon.
	 * @param attack Le nombre de dégât qu'inflige une attaque du Pokémon.
	 * @param baseEggSteps Le nombre de pas qu'il faut effectuer pour éclore l'oeuf du Pokémon.
	 * @param captureRate Le taux de capture du Pokémon.
	 * @param defense La défense du Pokémon.
	 * @param experienceGrowth L'experience que gagne le Pokémon.
	 * @param hp Le nombre de points de vie du Pokémon.
	 * @param spAttack Le nombre de dégât qu'inflige l'attaque spéciale du Pokémon.
	 * @param spDefense Le nombre de défense qu'octroie le spécial du Pokémon. 
	 * @param type1 Le type numéro 1 du Pokémon.
	 * @param type2 Le type numéro 2 du Pokémon.
	 * @param speed La vitesse du Pokémon.
	 * 	@param isLegendary La rareté legendaire ou non du Pokémon.
	 */
	public Pokemon(String name, int attack, int baseEggSteps, double captureRate, int defense, int experienceGrowth,
			int hp, int spAttack, int spDefense, String type1, String type2, double speed, boolean isLegendary) {
		this.name = name;
		this.attack = attack;
		this.baseEggSteps = baseEggSteps;
		this.captureRate = captureRate;
		this.defense = defense;
		this.experienceGrowth = experienceGrowth;
		this.hp = hp;
		this.spAttack = spAttack;
		this.spDefense = spDefense;
		this.type1 = type1;
		this.type2 = type2;
		this.speed = speed;
		this.isLegendary = isLegendary;
	}
	/**
	 * Constructeur d'un objet Pokémon vide.
	 */
	public Pokemon() {
		
	}

	/**
	 * Méthode JAVAFX.
	 * 	Récupère l'attribut du Pokémon par rapport à l'emplacement dans la menuList. 
	 * @param x Numéro de l'emplacement de l'attribut dans le menulist.
	 * @return la valeur de la caractÃ©ristique correspondant à l'emplacement dans  la menuList.
	 */
	public double getAttributs(int x) {
		double res = 0;
		if(x == 1) res = this.attack;
		if(x == 2) res = this.baseEggSteps;
		if(x == 3) res = this.captureRate;
		if(x == 4) res = this.defense;
		if(x == 5) res = this.experienceGrowth;
		if(x == 6) res = this.hp;
		if(x == 7) res = this.spAttack;
		if(x == 8) res = this.spDefense;
		if(x == 9) res = this.speed;
		return res;
	}
	
	/**
	 * Calcule l'amplitude du modele de données pour chaque caractéristiques en faisant la soustraction du de la valeur maximal de la donnée parmi tout les Pokémons à la valeur minimale de la donnée.  
	 * @param pokedex Une liste contenant tout les Pokémons (les lignes du CSV Pokémon).
	 */
	public static void calculAmpl(List<Pokemon> pokedex) {
		List<Pokemon> data = pokedex;
		Pokemon p1 = data.get(0); 
		int eggMin = p1.baseEggSteps;
		int eggMax = p1.baseEggSteps;
		double captureMin = p1.captureRate;
		double captureMax = p1.captureRate;
		int experienceMin = p1.experienceGrowth;
		int experienceMax = p1.experienceGrowth;
		double speedMin = p1.speed;
		double speedMax = p1.speed;

		for (Pokemon p : data) {
			if (eggMin > p.baseEggSteps)
				eggMin = p.baseEggSteps;
			if (eggMax < p.baseEggSteps)
				eggMax = p.baseEggSteps;

			if (captureMin > p.captureRate)
				captureMin = p.captureRate;
			if (captureMax < p.captureRate)
				captureMax = p.captureRate;

			if (experienceMin > p.experienceGrowth)
				experienceMin = p.experienceGrowth;
			if (experienceMax < p.experienceGrowth)
				experienceMax = p.experienceGrowth;

			if (speedMin > p.speed)
				speedMin = p.speed;
			if (speedMax < p.speed)
				speedMax = p.speed;
		}

		amplBaseEggSteps = eggMax - eggMin;
		amplCaptureRate = captureMax - captureMin;
		amplExperienceGrowth = experienceMax - experienceMin;
		amplSpeed = speedMax - speedMin;

	}
	/**
	 * Affichage d'un objet Pokémon.
	 * @return la chaine de caractère présentant l'objet Pokémon ainsi que les valeurs de ses attributs.
	 */
	@Override
	public String toString() {
		return "Pokemon{" + "name='" + name + '\'' + ", attack=" + attack + ", base_egg_steps=" + baseEggSteps
				+ ", capture_rate=" + captureRate + ", defense=" + defense + ", experience_growth=" + experienceGrowth
				+ ", hp=" + hp + ", sp_attack=" + spAttack + ", sp_defense=" + spDefense + ", type1='" + type1 + '\''
				+ ", type2='" + type2 + '\'' + ", speed=" + speed + ", is_legendary=" + isLegendary + "}";
	}

	
}