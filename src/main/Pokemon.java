package main;

import java.util.List;

import com.opencsv.bean.CsvBindByName;

/**
 *  Mod�le de la classification Pok�mon, d�crit un Pok�mon avec ses attributs et calule l'amplitude de ses caract�ristiques. 
 * 
 * @author arthur.debacq.etu
 * @author bastien.warnier.etu
 * @author pierre.foulon3.etu
 * @author maxime.bimont.etu
 * 
 */

public class Pokemon  {
	/**
	 * Le nom du Pok�mon.
	 */
	@CsvBindByName(column = "name")
	public String name;
	/**
	 * Le nom du Pok�mon.
	 */
	@CsvBindByName(column = "attack")
	public int attack;
	/**
	 * Le nom du Pok�mon.
	 */
	@CsvBindByName(column = "base_egg_steps")
	public int baseEggSteps;
	/**
	 * Le nom du Pok�mon.
	 */
	@CsvBindByName(column = "capture_rate")
	public double captureRate;
	/**
	 * Le nom du Pok�mon.
	 */
	@CsvBindByName(column = "defense")
	public int defense;
	/**
	 * L'experience que gagne le pok�mon.
	 */
	@CsvBindByName(column = "experience_growth")
	public int experienceGrowth;
	/**
	 * Le nombre de points de vie du Pok�mon.
	 */
	@CsvBindByName(column = "hp")
	public int hp;
	/**
	 * Les d�gats de l'attaque sp�ciale du Pok�mon.
	 */
	@CsvBindByName(column = "sp_attack")
	public int spAttack;
	/**
	 * La d�fense sp�ciale du Pok�mon.
	 */
	@CsvBindByName(column = "sp_defense")
	public int spDefense;
	/**
	 * Le type premier du Pok�mon.
	 */
	@CsvBindByName(column = "type1")
	public String type1;
	/**
	 * Le type secondaire du Pok�mon.
	 */
	@CsvBindByName(column = "type2")
	public String type2;
	/**
	 * Le vitesse du Pok�mon.
	 */
	@CsvBindByName(column = "speed")
	public double speed;
	/**
	 * La raret� l�gendaire ou non du Pok�mon.
	 */
	@CsvBindByName(column = "is_legendary")
	public boolean isLegendary;
	/**
	 * Attributs  utile � l'interface graphique.
	 */
	public static final String[] ATTRIBUTSALL = new String[] {"name","attack","baseEggSteps","captureRate","defense","experienceGrowth","hp","spAttack","spDefense","type1","type2","speed"};
	/**
	 * Attributs  utile � l'interface graphique.
	 */
	public static final String[] ATTRIBUTS = new String[] {"attack","baseEggSteps","captureRate","defense","experienceGrowth","hp","spAttack","spDefense","speed"};
	/**
	 * 	l'amplitude de la donn�eBaseEggSteps.
	 */
	public static double amplBaseEggSteps;
	/**
	 * 	l'amplitude de la donn�e CaptureRate.
	 */
	public static double amplCaptureRate;
	/**
	 * 	l'amplitude de la donn�e ExperienceGrowth.
	 */
	public static double amplExperienceGrowth;
	/**
	 * 	l'amplitude de la donn�e Speed.
	 */
	public static double amplSpeed;
	/**
	 * Cr�er un objet Pok�mon accompagn� de toutes ses caract�ristiques.
	 * @see Pokemon#Pokemon()
	 * @param name Le nom du Pok�mon.
	 * @param attack Le nombre de d�g�t qu'inflige une attaque du Pok�mon.
	 * @param baseEggSteps Le nombre de pas qu'il faut effectuer pour �clore l'oeuf du Pok�mon.
	 * @param captureRate Le taux de capture du Pok�mon.
	 * @param defense La d�fense du Pok�mon.
	 * @param experienceGrowth L'experience que gagne le Pok�mon.
	 * @param hp Le nombre de points de vie du Pok�mon.
	 * @param spAttack Le nombre de d�g�t qu'inflige l'attaque sp�ciale du Pok�mon.
	 * @param spDefense Le nombre de d�fense qu'octroie le sp�cial du Pok�mon. 
	 * @param type1 Le type num�ro 1 du Pok�mon.
	 * @param type2 Le type num�ro 2 du Pok�mon.
	 * @param speed La vitesse du Pok�mon.
	 * 	@param isLegendary La raret� legendaire ou non du Pok�mon.
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
	 * Constructeur d'un objet Pok�mon vide.
	 */
	public Pokemon() {
		
	}

	/**
	 * M�thode JAVAFX.
	 * 	R�cup�re l'attribut du Pok�mon par rapport � l'emplacement dans la menuList. 
	 * @param x Num�ro de l'emplacement de l'attribut dans le menulist.
	 * @return la valeur de la caractéristique correspondant � l'emplacement dans� la menuList.
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
	 * Calcule l'amplitude du modele de donn�es pour chaque caract�ristiques en faisant la soustraction du de la valeur maximal de la donn�e parmi tout les Pok�mons � la valeur minimale de la donn�e.  
	 * @param pokedex Une liste contenant tout les Pok�mons (les lignes du CSV Pok�mon).
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
	 * Affichage d'un objet Pok�mon.
	 * @return la chaine de caract�re pr�sentant l'objet Pok�mon ainsi que les valeurs de ses attributs.
	 */
	@Override
	public String toString() {
		return "Pokemon{" + "name='" + name + '\'' + ", attack=" + attack + ", base_egg_steps=" + baseEggSteps
				+ ", capture_rate=" + captureRate + ", defense=" + defense + ", experience_growth=" + experienceGrowth
				+ ", hp=" + hp + ", sp_attack=" + spAttack + ", sp_defense=" + spDefense + ", type1='" + type1 + '\''
				+ ", type2='" + type2 + '\'' + ", speed=" + speed + ", is_legendary=" + isLegendary + "}";
	}

	
}