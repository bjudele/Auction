package com.sda.auction.controller;

import com.sda.auction.dto.BidForm;
import com.sda.auction.dto.ItemForm;
import com.sda.auction.model.Bid;
import com.sda.auction.model.Item;
import com.sda.auction.service.BidService;
import com.sda.auction.service.ItemService;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("account")
public class AccountController {

	@Autowired
	private ItemService itemService;
	@Autowired
	private BidService bidService;

	@RequestMapping(value = {"/", ""}, method = RequestMethod.GET)
	public ModelAndView home() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("redirect:/account/home");
		return modelAndView;
	}

	@RequestMapping(value = {"/home",}, method = RequestMethod.GET)
	public ModelAndView accountHome() {
		ModelAndView modelAndView = new ModelAndView();
		List<ItemForm> itemList = itemService.getAvailableItems();
		modelAndView.addObject("itemList", itemList);
		modelAndView.setViewName("account/home");
		return modelAndView;
	}

	@RequestMapping(value = {"/item/{itemId}",}, method = RequestMethod.GET)
	public ModelAndView viewItemPage(@PathVariable(value = "itemId") String itemId) {
		ModelAndView modelAndView = new ModelAndView();

		ItemForm itemForm = itemService.getItemById(itemId);
		modelAndView.addObject(itemForm);

		BidForm bidForm = itemService.getBidFrom(itemForm);
		modelAndView.addObject(bidForm);

		modelAndView.setViewName("account/viewItem");
		return modelAndView;
	}

	@RequestMapping(value = {"/item/{itemId}",}, method = RequestMethod.POST)
	public ModelAndView bidItemPage(@PathVariable(value = "itemId") String itemId,
			@Valid BidForm bidForm) {
		ModelAndView modelAndView = new ModelAndView();

		bidService.saveBid(bidForm);

		modelAndView.setViewName("redirect:/account/item/" + itemId);
		return modelAndView;
	}

}
