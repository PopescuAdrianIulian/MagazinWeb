package com.magazin.MagazinWeb.repository;

import com.magazin.MagazinWeb.entity.Items;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Items, Long> {
}