package com.example.todoprojectdevelop.repository;

import com.example.todoprojectdevelop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long> {

    // 유저 조회
    User findByEmail(String email);
    List<User> findByUserName(String userName);
    List<User> findByUserNameAndEmail(String userName, String email);

    default User findByUserIdOrElseThrow(Long userId) {
        return findById(userId).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Does not exitst id = " + userId));
    }

    User findByEmailAndPassword(String email, String password);

//    default Boolean login(String email, String password) {
//        User user = findByEmailAndPassword(email, password);
//
//        return user.getId() != null;
//    }


//    default User login(String email, String password) {
//        return findByEmailAndPassword(email, password);
//
////        return findById(user.getId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.UNAUTHORIZED));
//    }
}
