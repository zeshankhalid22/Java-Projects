package org.example.app.entities;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.*;


@Entity(name = "user")
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class User implements UserDetails {

    @Id
    private String userId;
    @Column(name = "user_name", nullable = false)
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    @Getter(AccessLevel.NONE)
    @Column(length = 100)
    private String password;
    @Column(length = 1000)
    private String about;
    private String phoneNumber;



    @Enumerated(value = EnumType.STRING)
    private Providers provider = Providers.SELF;


    @ElementCollection(fetch = FetchType.EAGER)
    private List<String> rolelist = new ArrayList<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // list or roles returned
        Collection<SimpleGrantedAuthority> roles = rolelist.stream().map(SimpleGrantedAuthority::new)
                .toList();
        return roles;
    }

    @Override
    public String getPassword() {
        return this.password;
    }

    @Override
    public String getUsername() {
        return this.email;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }
}