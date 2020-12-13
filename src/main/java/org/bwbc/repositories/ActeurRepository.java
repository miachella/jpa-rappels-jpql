package org.bwbc.repositories;

import java.util.List;

import org.bwbc.beans.Acteur;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface ActeurRepository extends CrudRepository<Acteur, Long> {

	@Query("From Acteur")
	List<Acteur> findActeurs();
	
	// TODO implémenter la requête JPQL permettant de trouver la liste des acteurs
	// ayant joué dans un film paru durant
	// l'année passée en paramètre
	@Query("From Acteur WHERE identite LIKE %:identite%")
	List<Acteur> findActeursParIdentite(String identite);
	
	// TODO implémenter la requête JPQL permettant de trouver la liste des acteurs
	// nés une année donnée
	@Query("From Acteur WHERE year(anniversaire)=:annee")
	List<Acteur> findActeursParAnneeNaissance(int annee);


	// TODO implémenter la requête JPQL permettant de trouver la liste des acteurs
	// ayant joué dans un film français
	@Query("From Acteur a JOIN FETCH a.roles r WHERE r.nom=:roleName")
	List<Acteur> findActeursParRole(String roleName);
		
	// TODO implémenter la requête JPQL permettant de trouver la liste des acteurs
	// ayant joué dans un film paru durant une année précise
	@Query("From Acteur a JOIN FETCH a.roles r JOIN FETCH r.film f WHERE f.annee=:annee")
	List<Acteur> findActeursParFilmParuAnnee(@Param("annee") int annee);

	// TODO implémenter la requête JPQL permettant de trouver la liste des acteurs
	// ayant joué dans des films d'un pays donné
	@Query("SELECT distinct a From Acteur a JOIN FETCH a.roles r JOIN FETCH r.film f JOIN FETCH f.pays p WHERE p.nom=:nom")
	List<Acteur> findActeursParPays(String nom);
	
	// TODO implémenter la requête JPQL permettant de trouver la liste des acteurs
	// ayant joué dans des films d'un pays donné
	@Query("SELECT distinct a From Acteur a JOIN FETCH a.roles r JOIN FETCH r.film f JOIN FETCH f.pays p WHERE p.nom in (:noms) and f.annee=:annee")
	List<Acteur> findActeursParListePaysEtAnnee(List<String> noms, int annee);
	
	// TODO implémenter la requête JPQL permettant de trouver la liste des acteurs
	// ayant joué dans des films d'un pays donné
	@Query("SELECT distinct a From Acteur a JOIN FETCH a.roles r JOIN FETCH r.film f JOIN FETCH f.realisateurs r WHERE r.identite like %:identite% and f.annee between :anneeMin and :anneeMax")
	List<Acteur> findActeursParRealisateurEntreAnnees(String identite, int anneeMin, int anneeMax);
	
	// TODO implémenter la requête JPQL permettant de trouver la liste des acteurs
	// ayant joué dans un film co-produit par plusieurs pays
	// durant une année précise
//	@Query("From Acteur a JOIN FETCH a.roles r JOIN FETCH r.film f JOIN FETCH f.pays p WHERE p.nom in (:noms) and f.annee=:annee")
//	List<Acteur> findActeursCoproductionAnnee(@Param("noms") List<String> noms, @Param("annee") int annee);
}