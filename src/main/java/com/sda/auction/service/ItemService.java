package com.sda.auction.service;

import com.sda.auction.dto.BidForm;
import com.sda.auction.dto.ItemForm;
import com.sda.auction.model.Item;
import java.util.List;

public interface ItemService {

	void saveItem(ItemForm itemForm, String authenticatedEmail);

	List<ItemForm> getAllItems();

	ItemForm getItemById(String itemId);

	ItemForm getItemById(int itemId);

	List<ItemForm> getAvailableItems();

	BidForm getBidFrom(ItemForm itemForm);

	Item getItemEntity(int itemId);
}
