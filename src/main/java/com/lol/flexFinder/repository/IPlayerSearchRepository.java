package com.lol.flexFinder.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lol.flexFinder.entity.PlayerSearch;

public interface IPlayerSearchRepository extends JpaRepository<PlayerSearch, Long> {

}
