package com.boot.Repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.boot.Entity.Payload;

public interface payRepo  extends JpaRepository<Payload,String>{

}
