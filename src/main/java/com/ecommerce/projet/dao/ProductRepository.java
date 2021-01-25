package com.ecommerce.projet.dao;

import com.ecommerce.projet.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.web.bind.annotation.CrossOrigin;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
