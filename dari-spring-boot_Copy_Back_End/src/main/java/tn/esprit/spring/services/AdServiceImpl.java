package tn.esprit.spring.services;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.Ad;
import tn.esprit.spring.entities.Comment;
import tn.esprit.spring.repository.AdRepository;
import tn.esprit.spring.repository.CommentRepository;

@Service
public class AdServiceImpl implements IAdService {
	@Autowired
	AdRepository adRepository;
	@Autowired
	CommentRepository commentRepository;
	public static final Logger l = LogManager.getLogger(AdServiceImpl.class);


	@Override
	public Ad addAd(Ad ad) {
		adRepository.save(ad);		
		return ad;
	}

	@Override
	public List<Ad> retrieveAllAds() {
		List<Ad> ads=(List<Ad>)adRepository.findAll();
		for (Ad ad : ads) {
			l.info("ad +++"+ad);	
		}
		return ads;
	}

	/*ou bien
	@Override
	public List<Ad> retrieveAllAds() {
		List<Ad> ads=(List<Ad>)adRepository.findAll();
		for (Ad ad : ads) {
			ad.getIdAd();
		}
		return ads;
	}*/

	@Override
	public void deleteAd(int id) {

		adRepository.delete(adRepository.findById(id).get());
	}

	@Override
	public Ad updateAd(Ad ad) {
		adRepository.save(ad);
		return ad;
	}



	@Override
	public List<String> getAllCommentsByAd(int AdId) {
		Ad aa = adRepository.findById(AdId).get();
		List<String> CommentsDescription = new ArrayList<>();

		for(Comment com : aa.getComments()){
			CommentsDescription.add(com.getDescriptionComment());	

		}

		return CommentsDescription;
	}

	@Override
	public Ad getAdById(int adId) {
		return adRepository.findById(adId).get();	

	}

	@Override
	public Comment addComment(Comment comment) {
		commentRepository.save(comment);
		return comment;
	}

	@Override
	public void deleteComment(int commentId) {
		commentRepository.deleteById(commentId);

	}


	@Override
	public Comment UpdateComment(Comment comment) {
		commentRepository.save(comment);
		return comment;
	}

	@Override
	public void AssignCommentToanAd(int CommentId, int AdId) {
		// TODO Auto-generated method stub

	}

	
	}

   




