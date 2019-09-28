package com.sda.auction.repository;

import com.sda.auction.model.Item;
import com.sda.auction.model.User;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Integer> {

	@Query("select item from Item item where current_date between item.startDate and item.endDate")
	List<Item> findAvailable();

}
