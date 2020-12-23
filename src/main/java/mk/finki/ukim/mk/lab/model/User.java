package mk.finki.ukim.mk.lab.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import mk.finki.ukim.mk.lab.model.enumerations.Role;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "users")
public class User implements UserDetails{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String username;

    private String password;

    private String name;

    private String surname;

    private String address;

    @OneToMany(mappedBy = "user")
    private List<ShoppingCart> carts;

    @OneToMany(mappedBy = "user")
    private List<Order> orders;


    @Enumerated(value = EnumType.STRING)
    private Role role;

    public User(String username, String password, Role role, String name, String surname) {
        this.username = username;
        this.password = password;
        this.role = role;
        this.name = name;
        this.surname = surname;
    }

    public User(String username, String address) {
        this.username = username;
        this.address = address;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(role);
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
