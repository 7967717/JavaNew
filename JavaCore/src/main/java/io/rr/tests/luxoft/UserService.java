package io.rr.tests.luxoft;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.concurrent.atomic.AtomicInteger;

public class UserService {

    public UserService(UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    private UserDAO userDAO;

    private Map<Integer, CachedUser> cache = new HashMap<>();
    private Map<Integer, LocalDateTime> clearCache = new HashMap<>();

//    private static  AtomicInteger idCounter = new AtomicInteger();
//
//    public synchronized User createUser(String name) {
//        return new User(idCounter.getAndIncrement(), name, new ArrayList<>());
//    }

//    @She
//    private List<User> updateCache() {
//        cache = new HashMap<>();
//        cache = userDAO.getAllUsers();
//    }



    public User getUser(int id) {
        var first = cache.containsKey(id);
        if (first) {
            return cache.get(id).getUser();
        } else {
            User user = userDAO.getUser(id);
            CachedUser cachedUser = new CachedUser(user.getId(), LocalDateTime.now(), user);
            cache.put(id, cachedUser);
            clearCache.put(id, LocalDateTime.now());
            return user;
        }
    }

    //@Se
//    private void clearCache() throws InterruptedException {
//        while(true) {
//            Thread.sleep(10000000);
//            LocalDateTime now = LocalDateTime.now();
//            LocalDateTime time = now.minusHours(1);
//            clearCache.entrySet().stream().
//
//        }
//    }

}
