package org.example.springbootdeveloper.entity;

import jakarta.persistence.*;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "book")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class Book {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // 입력하는 값의 크기가 미세하게(띄어쓰기,영어or한글의 크기차이)다를 수 있기 때문에 db에서는 크기를 조금 더 크게 넣어준다.
    @Column(nullable = false, length = 50)
    private String writer;

    @Column(nullable = false, length = 100)
    private String title;

    @Column(nullable = false, length = 100)
    private String content;

    @Enumerated(EnumType.STRING)
    // JPA에서 열거형 데이터를 DB에 저장할 때 방식을 지정
    // : enum의 이름을 문자열로 저장
    @Column(nullable = false)
    private Category category;

}

// @NotNull 은 유효성 검사를 해주기 때문에 위와 같이 비어 있는 값이 들어가서는 안된다는 에러가 나오지만
// 데이터베이스의 제약조건과는 관계가 없어 보였다.
// 하지만 좀더 찾아보니 이런 제약조건을 해석하여 데이터베이스에 자동으로 not null 제약 조건을 걸어준다!
// nullable = false 는 데이터베이스에 명시적으로 not null 제약 조건을 걸어준다. 하지만 유효성 검사는 해주지 않는다!
// @NotNull을 이용하는 것이 제약조건 설정과 유효성 검사를 같이 해주기때문에 조금 더 안전하게 사용할 수 있을것 같다.
