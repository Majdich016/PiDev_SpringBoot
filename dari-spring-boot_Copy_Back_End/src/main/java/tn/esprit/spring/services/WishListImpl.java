package tn.esprit.spring.services;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import tn.esprit.spring.entities.WishList;
import tn.esprit.spring.repository.WishListRepository;

@Service
public class WishListImpl implements WishListService{

	public static final Logger L = LogManager.getLogger(AdServiceImpl.class);

	@Autowired
	WishListRepository wishListRepository;
	
	@Override	
	public WishList addWishList(WishList wl) {
		// TODO Auto-generated method stub
		return wishListRepository.save(wl);
	}

	@Override
	public void deleteWishList(int id) {
		// TODO Auto-generated method stub
		wishListRepository.delete(wishListRepository.findById(id).get());
	}

	@Override
	public WishList updateWishList(WishList wl) {
		// TODO Auto-generated method stub
		return wishListRepository.save(wl);
	}

	@Override
	public List<WishList> retrieveAllWishLists() {
		// TODO Auto-generated method stub
		List<WishList> wls=(List<WishList>)wishListRepository.findAll();
		for (WishList wl : wls) {
			L.info("whishlist +++"+wl);
		}
		return wls;
	}

	@Override
	public WishList retrieveWishList(String id) {
		// TODO Auto-generated method stub
		WishList u= wishListRepository.findById(Integer.parseInt(id)).orElse(null);
		L.info("retrive user by id ++++:"+u);
		return u;
				
	}

}
