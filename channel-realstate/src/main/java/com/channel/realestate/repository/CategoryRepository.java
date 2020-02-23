package com.channel.realestate.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.channel.realestate.dto.Category;

@Repository
public interface CategoryRepository extends JpaRepository<Category, String> {

}
