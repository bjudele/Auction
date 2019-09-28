package com.sda.auction.service;

import com.sda.auction.dto.BidForm;
import com.sda.auction.model.Bid;

public interface BidService {

	void saveBid(BidForm itemForm);

}
