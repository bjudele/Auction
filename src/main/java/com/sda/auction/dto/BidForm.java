package com.sda.auction.dto;

import lombok.Data;

@Data
public class BidForm {

	private String ownerEmail;

	private int itemId;

	private int value;


}
