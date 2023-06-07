package com.melancholia.educationplatform.user;

import com.melancholia.educationplatform.user.permissions.Privilege;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.data.mongodb.core.mapping.DBRef;

import java.util.*;

@NoArgsConstructor
@Document(collection = "users")
@Data
public class User implements UserDetails {
    @Id
    private String id;

    @Size(max=40)
    @NotBlank
    @Indexed
    private String username;
    
    @Email
    @NotBlank
    @Indexed
    private String email;
    
    @Size(max=120)
    private String password;

    private String phone;

    @DBRef
    private Set<Privilege> privileges = new HashSet<>();

    public void addPrivilege(Privilege privilege){
        privileges.add(privilege);
    }

    public User(String username, String email, String password, String phone) {
        this.username = username;
        this.email = email;
        this.password = password;
        this.phone = phone;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        List<GrantedAuthority> authorities = new ArrayList<>();
        for (Privilege privilege : privileges) {
            authorities.add(new SimpleGrantedAuthority(privilege.getName()));
        }
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}
