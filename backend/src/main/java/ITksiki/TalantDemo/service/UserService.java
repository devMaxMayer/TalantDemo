package ITksiki.TalantDemo.service;

import ITksiki.TalantDemo.entity.Event;
import ITksiki.TalantDemo.entity.User;
import ITksiki.TalantDemo.security.jwt.JwtUser;


import java.util.List;
import java.util.Set;

public interface UserService {

    User register(User user);

    List<User> getAll();

    User findByName(String username);

    User findById(Long id);

    void disable(Long id);

    JwtUser currentJwtUser();

    User currentUser();


}
