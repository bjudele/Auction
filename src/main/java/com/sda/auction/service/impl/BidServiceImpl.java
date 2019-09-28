package com.sda.auction.service.impl;

import com.sda.auction.dto.BidForm;
import com.sda.auction.model.Bid;
import com.sda.auction.model.Item;
import com.sda.auction.model.User;
import com.sda.auction.repository.BidRepository;
import com.sda.auction.service.BidService;
import com.sda.auction.service.ItemService;
import com.sda.auction.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BidServiceImpl implements BidService {

	private ItemService itemService;
	private BidRepository bidRepository;
	private UserService userService;

	@Autowired
	public BidServiceImpl(ItemService itemService, BidRepository bidRepository,
			UserService userService) {
		this.itemService = itemService;
		this.bidRepository = bidRepository;
		this.userService = userService;
	}

	@Override
	@Transactional
	public void saveBid(BidForm bidForm) {
		Bid bid = new Bid();
		bid.setValue(bidForm.getValue());

		User user = userService.getLoggedUser();
		bid.setUser(user);

		Item item = itemService.getItemEntity(bidForm.getItemId());
		bid.setItem(item);

		bidRepository.save(bid);

	}

}
