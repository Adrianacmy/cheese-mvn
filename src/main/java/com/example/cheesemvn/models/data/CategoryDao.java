package com.example.cheesemvn.models.data;

import com.example.cheesemvn.models.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;


@Repository
@Transactional
public interface CategoryDao extends CrudRepository<Category, Integer> {

}
