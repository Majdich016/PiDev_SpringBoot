package tn.esprit.spring.services;

import java.util.List;


//import org.springframework.data.repository.query.Param;

import tn.esprit.spring.entities.Ad;
import tn.esprit.spring.entities.Comment;

public interface IAdService {
	Ad addAd(Ad ad);
	Comment addComment(Comment comment);
	List<Ad> retrieveAllAds();
	void deleteAd(int id); 
	Ad updateAd(Ad ad); 
	Ad getAdById(int adId);
	List<String> getAllCommentsByAd(int AdId);
	public void deleteComment(int commentId);
	
	Comment UpdateComment(Comment comment);
	void AssignCommentToanAd(int CommentId, int AdId);
	

}
