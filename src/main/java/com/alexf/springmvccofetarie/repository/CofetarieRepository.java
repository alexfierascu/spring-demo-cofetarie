package com.alexf.springmvccofetarie.repository;

import com.alexf.springmvccofetarie.model.Cofetarie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CofetarieRepository extends JpaRepository<Cofetarie, Integer> {
}
