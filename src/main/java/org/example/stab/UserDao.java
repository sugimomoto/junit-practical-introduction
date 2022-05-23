package org.example.stab;

import org.example.User;

public interface UserDao {

    User find(String userid) throws UserNotFoundException;
}
