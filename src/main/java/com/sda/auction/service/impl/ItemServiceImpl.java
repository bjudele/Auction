package com.sda.auction.service.impl;

import com.sda.auction.dto.BidForm;
import com.sda.auction.dto.ItemForm;
import com.sda.auction.mapper.ItemMapper;
import com.sda.auction.model.Item;
import com.sda.auction.model.User;
import com.sda.auction.repository.ItemRepository;
import com.sda.auction.service.ItemService;
import com.sda.auction.service.UserService;
import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ItemServiceImpl implements ItemService {

	private ItemMapper itemMapper;
	private ItemRepository itemRepository;
	private UserService userService;

	@Autowired
	public ItemServiceImpl(ItemMapper itemMapper, ItemRepository itemRepository,
			UserService userService) {
		this.itemMapper = itemMapper;
		this.itemRepository = itemRepository;
		this.userService = userService;
	}

	@Override
	public void saveItem(ItemForm itemForm, String authenticatedEmail) {
		Item item = itemMapper.map(itemForm);
		setUserByEmail(authenticatedEmail, item);
		itemRepository.save(item);
	}

	@Override
	public List<ItemForm> getAllItems() {

		List<Item> itemList = itemRepository.findAll();
		return itemMapper.mapListToDto(itemList);
	}

	@Override
	public ItemForm getItemById(int id) {
		Optional<Item> itemOptional = itemRepository.findById(id);
		if (itemOptional.isPresent()) {
			Item item = itemOptional.get();
			ItemForm itemForm = itemMapper.map(item);

			String userEmail = userService.getLoggedInUserEmail();
			itemForm.setLoggedUserBidValue(item.highestBidValueOf(userEmail));

			return itemForm;
		}
		throw new RuntimeException();
	}

	@Override
	public ItemForm getItemById(String itemId) {
		Integer id = Integer.parseInt(itemId);
		return this.getItemById(id);
	}

	@Override
	public List<ItemForm> getAvailableItems() {
		List<Item> itemList = itemRepository.findAvailable();
		return itemMapper.mapListToDto(itemList);
	}

	@Override
	public BidForm getBidFrom(ItemForm itemForm) {
		BidForm bidForm = new BidForm();
		bidForm.setValue(itemForm.getCurrentPrice() + 1);
		bidForm.setItemId(itemForm.getId());
		bidForm.setOwnerEmail(userService.getLoggedInUserEmail());
		return bidForm;
	}

	@Override
	public Item getItemEntity(int itemId) {
		Optional<Item> optionalItem = itemRepository.findById(itemId);
		if (optionalItem.isPresent()) {
			return optionalItem.get();
		}
		throw new RuntimeException("No item with " + itemId + " found");
	}

	private void setUserByEmail(String authenticatedEmail, Item item) {
		User user = userService.findByEmail(authenticatedEmail);
		item.setUser(user);
	}
}
