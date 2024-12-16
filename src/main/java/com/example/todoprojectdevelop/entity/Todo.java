package com.example.todoprojectdevelop.entity;

import jakarta.persistence.*;
import lombok.Getter;

@Getter
@Entity
@Table(name = "todo")
public class Todo extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long todo_id;

    @Column(nullable = false)
    private String title;

    @Column(columnDefinition = "longtext")
    private String contents;

    @Column(nullable = false)
    private String userName;

//    // 일정 N : 유저 1
//    @Setter
//    @ManyToOne
//    @JoinColumn(name = "user_id")
//    private User user;

    // 기본 생성자 필수로 가져야 함
    public Todo() {
    }

    public Todo(String title, String contents, String userName) {
        // id는 자동생성, member는 참조하는 값이므로 파라미터 X
        this.title = title;
        this.contents = contents;
        this.userName = userName;
    }

    public void updateTitle(String title) {
        this.title = title;
    }

    public void updateContents(String contents) {
        this.contents = contents;
    }
}
