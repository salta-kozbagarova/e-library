package kz.salta.ssdb.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import kz.salta.ssdb.model.LibraryCard;

public interface LibraryCardDao extends JpaRepository<LibraryCard, Long> {

}
