package com.JiveTurkey.JiveTurkeyProject.Repository;

import com.JiveTurkey.JiveTurkeyProject.domain.Category;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends CrudRepository<Category,Long> {


}
