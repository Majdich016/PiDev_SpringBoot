package tn.esprit.spring.repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import tn.esprit.spring.entities.Ad;


public interface AdRepository extends CrudRepository<Ad, Integer>{
	//"SELECT DISTINCT(`id_ad` )FROM `t_ad` a INNER JOIN t_comment c ON a.`id_ad`=c.ads_id_ad WHERE c.number_likes >100  "
	@Query(nativeQuery = true, value ="select"
	+ " DISTINCT a.id_ad FROM Ad a" 
	+ " JOIN a.Comment c where a.id_ad=?c.ads_id_ad"
	+ " where c.number_likes > nbrLikes")
	public List<Ad> getAdWithBestLikesOnCommentsJPQL();
	//UPDATE `t_ad` SET `success` = b'1', `end_date` = '2020-03-31', `start_date` = '2020-03-25', 
	//`rentingtype` = 'TEMPORARY_RENTING', `rentperiod` = 'DAY', `price` = '200' WHERE `t_ad`.`id_ad` = 1;
}
