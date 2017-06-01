package com.vishal.ECommerce.Repository;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import com.vishal.ECommerce.Model.UserModel;

public interface UserRepository extends CrudRepository<UserModel,String> {

	
}
