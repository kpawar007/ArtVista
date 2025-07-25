package com.artapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.artapp.model.Art;

public interface ArtRepository extends JpaRepository<Art, Integer> {

}
