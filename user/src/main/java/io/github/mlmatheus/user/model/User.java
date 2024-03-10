package io.github.mlmatheus.user.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_user")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    @JsonIgnore
    private Long id;

    @Column(name = "username")
    private String username;

    @Column(name = "user_email")
    private String email;

    @Column(name = "user_password")
    @JsonIgnore
    private String password;
}
