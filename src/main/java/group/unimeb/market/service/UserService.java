package group.unimeb.market.service;

import group.unimeb.market.dao.UserDao;
import group.unimeb.market.model.User;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;

@Service
public class UserService implements UserDetailsService {
    @Resource
    UserDao userDao;

    public User getCurrentUser() {
        String s = (String) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        return getUserByEmailOrUsername(s);
    }

    private User getUserByEmailOrUsername(String s) {
        return userDao.selectByEmail(s);
    }

    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        User user = getUserByEmailOrUsername(s);
        user.setAuthorities(Collections.singletonList(new SimpleGrantedAuthority("User")));
        return user;
    }
}
