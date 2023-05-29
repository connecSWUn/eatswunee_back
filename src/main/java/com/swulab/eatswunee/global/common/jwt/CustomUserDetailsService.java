package com.swulab.eatswunee.global.common.jwt;

import com.swulab.eatswunee.domain.user.application.port.out.FindUserPort;
import com.swulab.eatswunee.domain.user.domain.model.User;
import java.util.Collections;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomUserDetailsService implements UserDetailsService {

  private final FindUserPort findUserPort;
  private final PasswordEncoder passwordEncoder;


  @Override
  public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

    User user = findUserPort.findUserByLoginId(username);

    return createUserDetails(user);
  }

  private UserDetails createUserDetails(User user) {

    GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(user.getRole().name());

    return org.springframework.security.core.userdetails.User
        .builder()
        .username(String.valueOf(user.getUserId()))
        .password(passwordEncoder.encode(user.getPassword()))
        .authorities(Collections.singleton(grantedAuthority))
        .build();



  }
}
