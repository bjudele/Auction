package com.sda.auction.model;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;
import sun.reflect.generics.tree.Tree;

@Entity
@Table(name = "item")
@Data
@EqualsAndHashCode(exclude = "user")
public class Item {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "item_id")
	private int id;
	@Column
	private String name;
	@Column
	private String description;
	@Column
	private int startingPrice;
	@Column
	private Date startDate;
	@Column
	private Date endDate;
	@Column
	private String category;


	@ToString.Exclude
	@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
	@JoinColumn(name = "user_id")
	private User user;

	@OneToMany(mappedBy = "item", cascade = CascadeType.ALL)
	private Set<Bid> bids = new TreeSet<>();

	public int getCurrentPrice() {
		TreeSet<Bid> bidsTreeSet = new TreeSet<>(bids);
		if (bidsTreeSet.size() == 0) {
			return startingPrice;
		}
		return bidsTreeSet.last().getValue();
	}

	public int highestBidValueOf(String userEmail) {
		int result = 0;
		for (Bid bid : bids) {
			User user = bid.getUser();
			if (user.getEmail().compareTo(userEmail) == 0 && result < bid.getValue()) {
				result = bid.getValue();
			}
		}
		return result;
	}

	public String getOwnerName() {
		return user.getFirstName() + " " + user.getLastName();
	}
}
