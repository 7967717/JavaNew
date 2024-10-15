package io.rr.tests.luxoft;

import java.util.List;

public interface UserDAO  {

    User getUser(int id);

    List<User> getAllUsers();

}
