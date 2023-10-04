package dk.kea.kinoxp_rest.service;


import dk.kea.kinoxp_rest.model.User;

import java.util.List;

public interface IUserService extends ICrudService<User,Long>{
    List<User> findByName(String name);
}
