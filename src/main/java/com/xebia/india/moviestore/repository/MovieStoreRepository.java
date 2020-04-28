package com.xebia.india.moviestore.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.xebia.india.moviestore.entity.MovieEntity;

public interface MovieStoreRepository extends JpaRepository<MovieEntity,Long>{
     
}
