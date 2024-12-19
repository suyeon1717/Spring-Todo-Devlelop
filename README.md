# 일정 관리 앱 Develop
## 📋 요구사항
#### JPA로 일정, 유저, 댓글 CRUD 구현하기
#### 회원가입 및 비밀번호 암호화
#### 필터를 사용하여 로그인(인증) 구현
#### 일정 페이징 조회

## 🥊 API 명세 및 ERD 작성
#### API 명세
![image](https://github.com/user-attachments/assets/c1e9257c-bef8-4262-ad06-30646afd8257)<br>
![image](https://github.com/user-attachments/assets/a04f1054-7970-4935-9a01-637f23503264)

#### ERD
일정 N : 유저 1 <br>
댓글 N : 일정 1 <br>
![image](https://github.com/user-attachments/assets/306f8d00-24da-4ae2-aeb4-a1f796b9f18c)

## 🥊 구현 결과
### 1) 일정 CRUD
![image](https://github.com/user-attachments/assets/75c5cd3a-0494-4369-8d30-0d4ab0ff255a)<br>
![image](https://github.com/user-attachments/assets/d0a2f268-5bc0-48ba-bfd1-273db2cfef96)<br>

### 2) 유저 CRUD
![image](https://github.com/user-attachments/assets/f5341374-5a49-485c-adc7-34f725e27712)<br>
### 3) 회원가입
![image](https://github.com/user-attachments/assets/d7afa60e-b6af-42e4-b45b-1e3436e3bc1a)<br>

### 4) 로그인
![image](https://github.com/user-attachments/assets/75a5b5c1-2c86-47d4-b467-840ccc153064)<br>
![image](https://github.com/user-attachments/assets/0931dc05-b2de-424e-ab53-df088d3a2a32)<br>

### 5) 예외 처리
- 동일한 이메일로 가입 -> email을 unique하게
```java
@Email //import jakarta.validation.constraints.Email;
@Column(nullable = false, unique = true)
private String email;
```

```java
// 유저 생성
    public SignUpResponseDto signUp(String email, String password,  String userName) {

        if (userRepository.findByEmail(email) != null) {
            throw new RuntimeException("이미 존재하는 이메일입니다.");
        }
        User user = new User(email, password, userName);
        User savedUser = userRepository.save(user); // Repository에 저장

        return new SignUpResponseDto(savedUser);
    }
```
![image](https://github.com/user-attachments/assets/2fc221cc-0c9f-47fb-be46-407c9a91be0b)<br>
![image](https://github.com/user-attachments/assets/5a21213f-2e47-41d3-9851-fc5a30b6716e)<br>



- 그 외, @NoBlank @Size 등
```java
// 예시 1 TodoRequest
@Getter
public class TodoRequestDto {

    @NotNull
    @Size(min = 1, max = 20)
    private final String title;

    @Size(max = 300)
    private final String contents;

    public TodoRequestDto(String title, String contents) {
        this.title = title;
        this.contents = contents;
    }
}

// 예시 2 LoginRequest
@Getter
public class LoginRequestDto {

    // 이메일과 비밀번호로 로그인
    @NotBlank
    @Email(message = "형식 : abc@naver.com")
    private final String email;

    @NotBlank
    @Pattern(regexp = "^(?=.*[a-zA-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,64}$")
    @Size(min = 8, max = 64)
    private final String password;

    public LoginRequestDto(String email, String password) {
        this.email = email;
        this.password = password;
    }
}

```
### 6) 비밀번호 암호화
![image](https://github.com/user-attachments/assets/46999d37-0743-4f1e-be93-d32460f0508b)<br>

### 7) 댓글 CRUD
![image](https://github.com/user-attachments/assets/2f277c75-d0e7-4aaa-aa09-27f2136ddfb4)<br>

### 8) 일정 페이징 조회
![image](https://github.com/user-attachments/assets/a6442f6b-cffe-4e01-a1a9-a5ee0dd2f95a)<br>
