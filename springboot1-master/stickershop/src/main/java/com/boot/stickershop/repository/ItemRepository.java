package com.boot.stickershop.repository;

import com.boot.stickershop.domain.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepository extends JpaRepository<Item, Long> {

}
