package distance;

import main.IPoint;
/**
 * L'interface Distance recueille les deux m�thodes de calcul de distance Manhattan et Euclidienne. 
 * Les m�thodes retournent un r�sultat de type num�rique (double) et prend en param�tre deux
 * objets de type IPoint qui sont des points repr�sentant une donn�e dans notre nuage de points.
 * 
 * @author arthur.debacq.etu
 * @author bastien.warnier.etu
 * @author pierre.foulon3.etu
 * @author maxime.bimont.etu
 *
 */
public interface Distance {
	/**
	 * @param p1 Un point dans le nuage.
	 * @param p2 Un deuxi�me point dans le nuage.
	 * @return La Distance Manhattan entre deux points (double).
	 */
	static double distanceManhattan(IPoint p1, IPoint p2) {
		return 0;
	}
	/**
	 * @param p1 Un point dans le nuage.
	 * @param p2 Un deuxi�me point dans le nuage.
	 * @return La Distance Euclidienne entre les deux points (double).
	 */
	static double distanceEuclidienne(IPoint p1, IPoint p2) {
		return 0;
	}
}
