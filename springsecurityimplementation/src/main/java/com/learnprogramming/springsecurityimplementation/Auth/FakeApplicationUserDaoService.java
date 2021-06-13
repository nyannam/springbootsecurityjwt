package com.learnprogramming.springsecurityimplementation.Auth;

import com.google.common.collect.Lists;
import com.learnprogramming.springsecurityimplementation.security.ApplicationUserRole;
import lombok.AllArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Repository("fake")
public class FakeApplicationUserDaoService implements ApplicationUserDao{

    private final PasswordEncoder passwordEncoder;

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUsername(String username) {
        return getApplicationUsers()
                .stream()
                .filter(applicationUser -> username.equals(applicationUser.getUsername()))
                .findFirst();
    }

    private List<ApplicationUser> getApplicationUsers() {
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
          new ApplicationUser(
                  ApplicationUserRole.STUDENT.getGrantedAuthorities(),
                  passwordEncoder.encode("password"),
                  "Naga",
                  true,
                  true,
                  true,
                  true
          ),
                new ApplicationUser(
                        ApplicationUserRole.ADMIN.getGrantedAuthorities(),
                        passwordEncoder.encode("password1@"),
                        "Ross",
                        true,
                        true,
                        true,
                        true
                ),
                new ApplicationUser(
                        ApplicationUserRole.ADMINTRAINEE.getGrantedAuthorities(),
                        passwordEncoder.encode("password1@"),
                        "Jon",
                        true,
                        true,
                        true,
                        true
                )
        );
        return applicationUsers;

    }
}
