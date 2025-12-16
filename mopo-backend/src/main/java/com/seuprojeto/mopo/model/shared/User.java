package com.seuprojeto.mopo.model.shared;

import com.seuprojeto.mopo.model.Role;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

@MappedSuperclass
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class User implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(nullable = false)
    private UUID id;

    @Column(unique = true, length = 100)
    private String username;

    @NotNull
    @NotBlank
    @Email(message = "E-mail inválido")
    @Column(nullable = false, unique = true, length = 100)
    private String email;

    @NotNull
    @NotBlank
    @Column(nullable = false, length = 120)
    private String password;

    @Column(length = 15)
    private String telephone;

    @Column
    private Boolean isActive = true;

    @CreationTimestamp
    @Column(nullable = false, updatable = false)
    private LocalDateTime createdAt = LocalDateTime.now();

    @UpdateTimestamp
    @Column(nullable = false)
    private LocalDateTime updatedAt = LocalDateTime.now();

    @ManyToMany(fetch = FetchType.EAGER)
    @Column
    @NotNull
    private Set<Role> roles = new HashSet<>();

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(
                r -> new SimpleGrantedAuthority(r.getRoleName().name())).toList();
    }

    @Override
    public String getUsername() {
        return this.username;
    }

    public String getRole() {
        return this.getClass().getSimpleName().toUpperCase();
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
}
