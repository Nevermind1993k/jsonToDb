package com.nevermind.bu.dao;

import com.nevermind.bu.entity.Data;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DataDao extends JpaRepository<Data, String> {

}
