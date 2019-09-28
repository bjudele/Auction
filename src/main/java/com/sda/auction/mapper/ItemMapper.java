package com.sda.auction.mapper;

import com.sda.auction.dto.ItemForm;
import com.sda.auction.model.Item;
import com.sda.auction.util.DateParser;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ItemMapper {

	private final DateParser dateParser;

	@Autowired
	public ItemMapper(DateParser dateParser) {
		this.dateParser = dateParser;
	}

	public Item map(ItemForm itemForm) {
		Item item = new Item();
		item.setName(itemForm.getName());
		item.setDescription(itemForm.getDescription());
		item.setStartingPrice(itemForm.getStartingPrice());

		Date startDate = dateParser.parse(itemForm.getStartDate());
		item.setStartDate(startDate);

		Date endDate = dateParser.parse(itemForm.getEndDate());
		item.setEndDate(endDate);

		return item;
	}

	public ItemForm map(Item item) {
		ItemForm itemForm = new ItemForm();
		itemForm.setName(item.getName());
		itemForm.setDescription(item.getDescription());
		itemForm.setStartingPrice(item.getStartingPrice());
		itemForm.setCategory(item.getCategory());
		itemForm.setId(item.getId());
		itemForm.setCurrentPrice(item.getCurrentPrice());
		itemForm.setOwnerName(item.getOwnerName());

		String startDate = dateParser.format(item.getStartDate());
		itemForm.setStartDate(startDate);
		String endDate = dateParser.format(item.getEndDate());
		itemForm.setEndDate(endDate);

		return itemForm;
	}

	public List<ItemForm> mapListToDto(List<Item> itemList) {
		return itemList.stream().map(this::map).collect(Collectors.toList());
	}
}
