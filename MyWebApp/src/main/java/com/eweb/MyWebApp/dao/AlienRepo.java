package com.eweb.MyWebApp.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import com.eweb.MyWebApp.Alien;

public interface AlienRepo extends JpaRepository<Alien, Integer>{

}
