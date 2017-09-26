package com.allianz.training;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.AuthorityUtils;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.allianz.training.db.PersonDAO;

@Service
public class CustomUserDetails implements UserDetailsService {

    @Autowired
    private PersonDAO personDAO;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        List<Person> findCustomUsernameNative = personDAO.findCustomUsernameNative(username);
        if (findCustomUsernameNative == null || findCustomUsernameNative.size() == 0) {
            throw new UsernameNotFoundException("User yok");
        }
        Person person = findCustomUsernameNative.get(0);
        User user = new User(person.getPersonCredential()
                                   .getUsername(),
                             person.getPersonCredential()
                                   .getPassword(),
                                   AuthorityUtils.createAuthorityList("ROLE_USER","ROLE_ADMIN"));
        return user;
    }

}
