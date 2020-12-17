package org.bwbc.repositories;

import java.util.List;

import org.bwbc.beans.Acteur;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ActeurRepository extends CrudRepository<Acteur, Long> {

	/** Recherche tous les acteurs triés par identité
	 * @return List
	 */
	@Query("From Acteur a ORDER By a.identite")
	List<Acteur> findActeursTriesParIdentite();
	
	/** Recherche tous les acteurs dont l'identité (ou partie) est passée en paramètre
	 * @param identite identité
	 * @return List
	 */
	@Query("From Acteur a WHERE a.identite = :identite")
	List<Acteur> findActeursParIdentite(String identite);
	
	/** Recherche tous les acteurs nés l'année passée en paramètre. Les acteurs sont triés par date de naissance ascendante.
	 * @param annee année
	 * @return List
	 *  a
	 */
	@Query("Select a From Acteur a  WHERE year(a.anniversaire) = :annee ORDER BY a.anniversaire ASC")
	List<Acteur> findActeursParAnneeNaissance(int annee);


	/** Recherche les acteurs dont le nom de personnage est passé en paramètre
	 * @param roleName nom du personnage de fiction
	 * @return List
	 */
	@Query("Select a From Acteur a JOIN a.roles r WHERE r.nom = :roleName")
	List<Acteur> findActeursParRole(String roleName);
		
	/** Recherche tous les acteurs ayant joué dans un film paru l'année passée en paramètre.
	 * @param annee année
	 * @return List
	 */
	@Query("Select a From Acteur a Join a.roles r Join r.film f WHERE f.annee = :annee")
	List<Acteur> findActeursParFilmParuAnnee(@Param("annee") int annee);

	/** Recherche tous les acteurs ayant joué dans un film produit dans le pays dont le nom est passé en paramètre
	 * @param nom nom du pays
	 * @return List
	 */
	@Query("SELECT DISTINCT a From Acteur a Join a.roles r Join r.film f Join f.pays p Where p.nom = :nom")
	List<Acteur> findActeursParPays(String nom);
	
	/** Recherche tous les acteurs ayant joué dans un film paru l'année passée en paramètre et produit dans un des pays passés en paramètre
	 * @param noms noms des pays de production des films
	 * @param annee année de parution
	 * @return List
	 */
	@Query("SELECT DISTINCT a From Acteur  a Join a.roles r Join r.film f Join f.pays p Where p.nom IN (:noms) AND f.annee = :annee")
	List<Acteur> findActeursParListePaysEtAnnee(List<String> noms, int annee);
	
	/** Recherche tous les acteurs ayant joué dans un film réalisé par la personne dont l'identité est passée en paramètre. Seuls les films dont l'année
	 * de paution est comprise entre anneeMin et anneeMax sont concernés.
	 * @param identite identité du réalisateur
	 * @param anneeMin année min de recherche
	 * @param anneeMax année max de recherche
	 * @return List
	 */
	@Query("SELECT DISTINCT a From Acteur a Join a.roles r Join r.film f Join f.realisateurs l WHERE l.identite = :identite AND f.annee BETWEEN :anneeMin AND :anneeMax")
	List<Acteur> findActeursParRealisateurEntreAnnees(String identite, int anneeMin, int anneeMax);
	
}