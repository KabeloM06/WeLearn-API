package com.kabelo.WeLearn.user;

import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@Component
public class UserDaoService {

    //JPA or Hibernate talks to the database
    //In meantime, we'll talk to static List

    private static List<User> users = new ArrayList<>();

    private static int usersCount = 0;

    static {
        users.add(new User(++usersCount, "Kabelo", "kabelo@test.com", "tutor"));
        users.add(new User(++usersCount, "Tshego", "tshego@test.com", "tutor"));
        users.add(new User(++usersCount, "Mohau", "mohau@test.com", "learner"));
        users.add(new User(++usersCount, "Masego", "masego@test.com", "learner"));
        users.add(new User(++usersCount, "Ntu", "admin@test.com", "admin"));
    }

    public List<User> findAll() {
        return users;
    }

    public User save(User user) {
        user.setId(++usersCount);
        users.add(user);
        return user;
    }

    public User findOne(int id) {
        Predicate<? super User> predicate = user -> user.getId().equals(id);
        return users.stream().filter(predicate).findFirst().get();
    }
}
