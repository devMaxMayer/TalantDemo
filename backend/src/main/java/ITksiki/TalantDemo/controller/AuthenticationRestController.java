package ITksiki.TalantDemo.controller;

import ITksiki.TalantDemo.dto.AuthenticationRequestDto;
import ITksiki.TalantDemo.entity.User;
import ITksiki.TalantDemo.security.jwt.JwtTokenProvider;
import ITksiki.TalantDemo.security.jwt.JwtUser;
import ITksiki.TalantDemo.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;

import static ITksiki.TalantDemo.security.jwt.JwtTokenFilter.ACCESS_TOKEN_COOKIE_NAME;

@Slf4j
@RestController
@RequestMapping(value = "/api/v1/auth/")
public class AuthenticationRestController {

    private final AuthenticationManager authenticationManager;

    private final JwtTokenProvider jwtTokenProvider;

    private final UserService userService;

    @Autowired
    public AuthenticationRestController(AuthenticationManager authenticationManager, JwtTokenProvider jwtTokenProvider, UserService userService) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenProvider = jwtTokenProvider;
        this.userService = userService;
    }

    @PostMapping("registration")
    public void registration(@RequestBody AuthenticationRequestDto requestDto, final HttpServletResponse response) {

    }

    @PostMapping("login")
    public void login(@RequestBody AuthenticationRequestDto requestDto, final HttpServletResponse response) {
        try {
            String username = requestDto.getUsername();
            authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(username, requestDto.getPassword()));
            User user = userService.findByName(username);

            if (user == null) {
                throw new UsernameNotFoundException("User with username: " + username + " not found");
            }

            String token = jwtTokenProvider.createToken(username, user.getRoles());
            final Cookie cookie = new Cookie(ACCESS_TOKEN_COOKIE_NAME, token);
            cookie.setMaxAge((int) jwtTokenProvider.getValidityInMilliseconds());
            cookie.setHttpOnly(true);
            cookie.setPath("/");
            response.addCookie(cookie);
        } catch (AuthenticationException e) {
            log.error("", e);
            throw new BadCredentialsException("Invalid username or password");
        }
    }

    @GetMapping("user")
    public JwtUser user() {
        return userService.currentJwtUser();
    }

    /**
     * кодирует пароль, который необходимо проставить пользователю в БД
     */
    public static void main(String[] args) {
        BCryptPasswordEncoder we = new BCryptPasswordEncoder();
        String encode = we.encode("1234");
        System.out.println(encode);
    }
}