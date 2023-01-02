package main;

import java.util.List;

import com.opencsv.bean.CsvBindByName;

/**
 *  Mod�le de la classification Titanic, d�crit un passager du Titanic avec ses attributs et calule l'amplitude de ses caract�ristiques. 
 * 
 * @author arthur.debacq.etu
 * @author bastien.warnier.etu
 * @author pierre.foulon3.etu
 * @author maxime.bimont.etu
 * 
 */

public class Titanic {
	/**
	 * L'identifiant du passager.
	 */
	@CsvBindByName(column = "PassengerId")
	public int passengerId;
	/**
	 * L'identifiant du passager.
	 */
	@CsvBindByName(column = "Survived")
	public boolean survived;
	/**
	 * L'identifiant du passager.
	 */
	@CsvBindByName(column = "Pclass")
	public int pClass;
	/**
	 * Le nom du passager.
	 */
	@CsvBindByName(column = "Name")
	public String name;
	/**
	 * Le sexe du passager.
	 */
	@CsvBindByName(column = "Sex")
	public String sex;
	/**
	 * L'�ge du passager.
	 */
	@CsvBindByName(column = "Age")
	public double age;
	/**
	 * Le nombre de fr�res et s�urs/conjoints � bord.
	 */
	@CsvBindByName(column = "SibSp")
	public int sibSp;
	/**
	 * Le nombre de parents et enfants � bord.
	 */
	@CsvBindByName(column = "Parch")
	public int parch;
	/**
	 * L'identifiant du ticket du passager.
	 */
	@CsvBindByName(column = "Ticket")
	public String ticket;
	/**
	 * Le tarif du ticket.
	 */
	@CsvBindByName(column = "Fare")
	public double fare;
	/**
	 * Le num�ro de cabine du passager.
	 */
	@CsvBindByName(column = "Cabin")
	public String cabin;
	/**
	 * Le port d'embarquation du passager.
	 */
	@CsvBindByName(column = "Embarked")
	public char embarked;
	/**
	 * Attributs  utile � l'interface graphique.
	 */
	public static final String[] ATTRIBUTSALL = new String[] {"passengerId","pClass","name","sex","age","sibSp","parch","ticket","fare","cabin","embarked"};
	/**
	 * Attributs  utile � l'interface graphique.
	 */
	public static final String[] ATTRIBUTS = new String[] {"passengerId","pClass","age","sibSp","parch","fare","","",""};
	/**
	 * 	l'amplitude de la donn�e PClass.
	 */
	public static double amplPClass;
	/**
	 * 	l'amplitude de la donn�e Age.
	 */
	public static double amplAge;
	/**
	 * 	l'amplitude de la donn�e SibSp.
	 */
	public static double amplSibSp;
	/**
	 * 	l'amplitude de la donn�e Parch.
	 */
	public static double amplParch;
	/**
	 * 	l'amplitude de la donn�e Fare.
	 */
	public static double amplFare;
	/**
	 * Cr�er un passager du Titanic accompagn� de toutes ses caract�ristiques.
	 * @see Titanic#Titanic()
	 * @param passengerId L'identifiant du passager.
	 * @param survived	L'indicateur de survie du passager.
	 * @param pClass La classe du passager.
	 * @param name Le nom du passager.
	 * @param sex Le sexe du passager.
	 * @param age L'�ge du passager.
	 * @param sibSp Le nombre de fr�res et soeurs et �poux � bord.
	 * @param parch Le nombre de parents et enfants � bord.
	 * @param ticket Le num�ro de tickets du passager.
	 * @param fare Le prix de l'embarquation.
	 * @param cabin Le num�ro de cabine du passager.
	 * @param embarked Le port d'embarquation du passager. 
	 */
	public Titanic(int passengerId, boolean survived, int pClass, String name, String sex, double age, int sibSp, int parch, String ticket, double fare, String cabin, char embarked) {
		this.passengerId = passengerId;
		this.survived = survived;
		this.pClass = pClass;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.sibSp = sibSp;
		this.parch = parch;
		this.ticket = ticket;
		this.fare = fare;
		this.cabin = cabin;
		this.embarked = embarked;
	}
	/**
	 * Constructeur d'un passager Titanic vide.
	 */
	public Titanic() {
		
	}
	/**
	 * M�thode JAVAFX.
	 * 	R�cup�re l'attribut du passager du Titanic par rapport � l'emplacement dans la menuList. 
	 * @param x Num�ro de l'emplacement de l'attribut dans le menulist.
	 * @return la valeur de la caractéristique correspondant � l'emplacement dans� la menuList.
	 */
	public double getAttributs(int x) {
		double res = 0;
		if(x == 1) res = this.passengerId;
		if(x == 2) res = this.pClass;
		if(x == 3) res = this.age;
		if(x == 4) res = this.sibSp;
		if(x == 5) res = this.parch;
		if(x == 6) res = this.fare;
		return res;
	}
	/**
	 * Calcule l'amplitude du modele de donn�es pour chaque caract�ristiques en faisant la soustraction du de la valeur maximal de la donn�e parmi tout les les passagers du Titanic � la valeur minimale de la donn�e.  
	 * @param cimetiere Une liste contenant tout les passagers du Titanic (les lignes du CSV Titanic).
	 */
	public static void calculAmpl(List<Titanic> cimetiere) {
		List<Titanic> data = cimetiere;
		Titanic t1 = data.get(0);
		double pClassMin = t1.pClass;
		double pClassMax = t1.pClass;
		double ageMin = t1.age;
		double ageMax = t1.age;
		double sibSpMin = t1.sibSp;
		double sibSpMax = t1.sibSp;
		double parchMin = t1.parch;
		double parchMax = t1.parch;
		double fareMin = t1.fare;
		double fareMax = t1.fare;

		for (Titanic i : data) {
			if (pClassMin > i.pClass)
				pClassMin = i.pClass;
			if (pClassMax < i.pClass)
				pClassMax = i.pClass;

			if (ageMin > i.age)
				ageMin = i.age;
			if (ageMax < i.age)
				ageMax = i.age;

			if (sibSpMin > i.sibSp)
				sibSpMin = i.sibSp;
			if (sibSpMax < i.sibSp)
				sibSpMax = i.sibSp;

			if (parchMin > i.parch)
				parchMin = i.parch;
			if (parchMax < i.parch)
				parchMax = i.parch;
			
			if (fareMin > i.fare)
				fareMin = i.fare;
			if (fareMax < i.fare)
				fareMax = i.fare;
		}

		amplFare = fareMax - fareMin;
		amplParch = parchMax - parchMin;
		amplSibSp = sibSpMax - sibSpMin;
		amplPClass = pClassMax - pClassMin;
		amplAge = ageMax - ageMin;

	}
	/**
	 * Affichage d'un passager du Titanic.
	 * @return la chaine de caract�re pr�sentant un passager du Titanic ainsi que les valeurs de ses attributs.
	 */
	@Override
	public String toString() {
		return "Titanic [passengerId=" + passengerId + ", survivor=" + survived + ", pClass=" + pClass + ", name="
				+ name + ", sex=" + sex + ", age=" + age + ", sibSp=" + sibSp + ", parch=" + parch + ", ticket="
				+ ticket + ", fare=" + fare + ", cabin=" + cabin + ", embarked=" + embarked + "]";
	}
}
