package com.task.eCommerce.repository;

import com.task.eCommerce.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ItemRepository extends JpaRepository<Item, String> {
    Item findByItemId(String itemId);

    Optional<Item> findByItemCode(String itemCode);

    Item deleteByItemId(String itemId);
}
