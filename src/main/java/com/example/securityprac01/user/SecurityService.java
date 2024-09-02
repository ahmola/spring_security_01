package com.example.securityprac01.user;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Service
public class SecurityService implements UserDetailsService {

    private final PasswordEncoder passwordEncoder;

    private final SecurityRepository securityRepository;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        SecurityUser user = securityRepository.findByEmail(email)
                .orElseThrow(() -> new UsernameNotFoundException("There is no such email : " + email));

        return new SecurityUser(user.getId(), user.getEmail(), user.getPassword(),
                List.of(Role.ROLE_USER));
    }

    public UserDetails createUser(SecurityUserDTO securityUserDTO) {
        log.info(securityUserDTO.toString());
        securityUserDTO.setPassword(passwordEncoder.encode(securityUserDTO.getPassword()));
        SecurityUser user = new SecurityUser(securityUserDTO);

        securityRepository.save(user);
        return user;
    }

    public List<SecurityUser> all() {
        return securityRepository.findAll();
    }
}
