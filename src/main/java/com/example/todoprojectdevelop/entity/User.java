package com.example.todoprojectdevelop.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import lombok.Getter;

import java.util.List;

@Getter
@Entity
@Table(name = "user")
public class User extends BaseEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Email //import jakarta.validation.constraints.Email;
    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column(nullable = false)
    private String userName;

    // orphanRemoval = true: 부모 엔티티가 삭제되면 자식 엔티티도 삭제되게 해주는 옵션
    @OneToMany(mappedBy = "id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Todo> todos;

    // 기본 생성자 필수로 가져야 함
    public User() {
    }

    public User(String email, String password, String userName) {
        this.email = email;
        this.password = password;
        this.userName = userName;
    }

    public void updateEmail(String userEmail) {
        this.email = userEmail;
    }

    public void updateName(String userName) {
        this.userName = userName;
    }


}
