package org.example.stab;

import org.example.User;

public class UserDaoStub implements UserDao{

    // Exception を受け取って、そのExceptionを元にどのような振る舞いをするのか、を処理するためのテストじゃないといけないよね
    @Override
    public User find(String userid) throws UserNotFoundException {
        throw new UserNotFoundException();
    }
}
