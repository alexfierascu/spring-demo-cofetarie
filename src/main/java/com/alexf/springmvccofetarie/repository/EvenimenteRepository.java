package com.alexf.springmvccofetarie.repository;

import com.alexf.springmvccofetarie.model.Evenimente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EvenimenteRepository extends JpaRepository<Evenimente, Integer> {
}
