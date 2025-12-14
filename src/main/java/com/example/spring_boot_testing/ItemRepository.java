package com.example.spring_boot_testing;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemRepository extends JpaRepository<Item, Long> {
    Optional<Item> findByName(String name);
    void deleteByName(String name);
}
