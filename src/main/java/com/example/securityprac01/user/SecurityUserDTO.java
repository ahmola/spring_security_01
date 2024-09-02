package com.example.securityprac01.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class SecurityUserDTO {

    private Long id;

    private String email;

    private String password;

    private List<Role> roles = new ArrayList<>();
}
