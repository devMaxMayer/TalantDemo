package ITksiki.TalantDemo.service.impl;


import ITksiki.TalantDemo.entity.*;
import ITksiki.TalantDemo.enums.Status;
import ITksiki.TalantDemo.repository.UserRepository;
import ITksiki.TalantDemo.repository.UserRoleRepository;
import ITksiki.TalantDemo.security.jwt.JwtUser;
import ITksiki.TalantDemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    private final UserRoleRepository userRoleRepository;
    private final BCryptPasswordEncoder passwordEncoder;


    @Autowired
    public UserServiceImpl(UserRepository userRepository,
                           UserRoleRepository userRoleRepository,
                           BCryptPasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.userRoleRepository = userRoleRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public User register(User user) {

        user.setPassword(passwordEncoder.encode(user.getPassword()));
        user.setStatus(Status.ACTIVE);
        User registeredUser = userRepository.save(user);

        UserRole userRole = new UserRole(registeredUser, Role.USER);
        userRoleRepository.save(userRole);

        log.info("IN register - user: {} successfully registered", registeredUser);

        return registeredUser;
    }

    @Override
    public List<User> getAll() {
        List<User> result = userRepository.findAll();
        log.info("IN getAll - {} users found", result.size());
        return result;
    }

    @Override
    public User findByName(String name) {
        User result = userRepository.findByName(name);
        log.info("IN findByname - user: {} found by name: {}", result, name);
        return result;
    }

    @Override
    public User findById(Long id) {
        User result = userRepository.findById(id).orElse(null);

        if (result == null) {
            log.warn("IN findById - no user found by id: {}", id);
            return null;
        }

        log.info("IN findById - user: {} found by id: {}", result);
        return result;
    }

    @Override
    public void disable(Long id) {
        userRepository.disableById(id, Status.DISABLE);
        log.info("IN delete - user with id: {} successfully deleted");
    }

    @Override
    public JwtUser currentJwtUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return (JwtUser) auth.getPrincipal();
    }

    @Override
    public User currentUser() {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        JwtUser jwtUser = (JwtUser) auth.getPrincipal();
        return findById(jwtUser.getId());
    }

}