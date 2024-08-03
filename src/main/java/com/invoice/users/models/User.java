package com.invoice.users.models;

import com.invoice.roles.models.Roles;
import jakarta.persistence.*;
import lombok.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Table(name = "usuario")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true , nullable = false, updatable = false)
    private String username;
    @Column(unique = true)
    private String email;
    private String password;
    @Column(columnDefinition="boolean default true")
    private boolean isEnabled = true;
    @Column(columnDefinition="boolean default true")
    private boolean accountNoExpired = true;
    @Column(columnDefinition="boolean default true")
    private boolean accountNoLocked = true;
    @Column(columnDefinition="boolean default true")
    private boolean credentialNoExpired = true;
    @ManyToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinTable(name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Roles> roles = new HashSet<>();
}
