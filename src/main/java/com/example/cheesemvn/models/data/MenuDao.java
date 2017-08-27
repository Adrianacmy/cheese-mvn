package com.example.cheesemvn.models.data;

import com.example.cheesemvn.models.Cheese;
import com.example.cheesemvn.models.Menu;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
@Transactional
public interface MenuDao extends CrudRepository <Menu, Integer> {
}

