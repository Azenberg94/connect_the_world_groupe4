package com.pachimari.user.repository;

import com.pachimari.user.User;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Pierre on 25/03/2017.
 */
public interface UserRepository  extends MongoRepository<User,Long>{

}
