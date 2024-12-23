package com.ensagps.gdmsensa.Repo;

import com.ensagps.gdmsensa.Model.Element;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ElementRepo extends JpaRepository<Element, Long> {
}