package com.sda.auction.service.impl;

import com.sda.auction.dto.ItemForm;
import com.sda.auction.mapper.ItemMapper;
import com.sda.auction.model.Item;
import com.sda.auction.model.User;
import com.sda.auction.repository.ItemRepository;
import com.sda.auction.service.ItemService;
import com.sda.auction.service.UserService;
import com.sda.auction.util.ImageUtil;
import java.sql.SQLException;
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
	public void saveItem(ItemForm itemForm) {
		Item item = itemMapper.map(itemForm);
		String authenticatedEmail = userService.getAuthenticatedEmail();
		setUserByEmail(authenticatedEmail, item);
		itemRepository.save(item);
	}

	@Override
	public List<ItemForm> findAll() {
		List<Item> itemList = itemRepository.findAll();
		List<ItemForm> itemFormList = itemMapper.map(itemList);
		return itemFormList;
	}

	@Override
	public List<ItemForm> findAvailableItems() {
		List<Item> itemList = itemRepository.findAvailable();
		List<ItemForm> itemFormList = itemMapper.map(itemList);
		return itemFormList;
	}

	@Override
	public Item findItemById(String itemId) {
		Integer id = Integer.parseInt(itemId);
		Optional<Item> optionalItem = itemRepository.findById(id);
		if (optionalItem.isPresent()) {
			return optionalItem.get();
		}
		throw new RuntimeException();
	}

	@Override
	public ItemForm findItemFormById(String itemId) {
		Item item = findItemById(itemId);

		ItemForm itemForm = itemMapper.map(item);

		String userEmail = userService.getAuthenticatedEmail();
		int highestBidValue = item.getHighestBidValueFor(userEmail);
		itemForm.setLoggedUserBidValue(highestBidValue);
		return itemForm;
	}

	@Override
	public byte[] getItemImageByItemId(Integer itemId) throws SQLException {
		Item item = findItemById(itemId.toString());
		return ImageUtil.getByteArray(item.getImage());
	}

	private void setUserByEmail(String authenticatedEmail, Item item) {
		User user = userService.findByEmail(authenticatedEmail);
		item.setUser(user);
	}
}
