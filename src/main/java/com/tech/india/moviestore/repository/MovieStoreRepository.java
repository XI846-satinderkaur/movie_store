package com.tech.india.moviestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tech.india.moviestore.entity.MovieEntity;

public interface MovieStoreRepository extends JpaRepository<MovieEntity,Long>{
     
}
