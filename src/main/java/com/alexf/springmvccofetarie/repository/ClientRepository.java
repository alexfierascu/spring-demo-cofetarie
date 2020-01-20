package com.alexf.springmvccofetarie.repository;

import com.alexf.springmvccofetarie.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<Client, Integer> {
}
