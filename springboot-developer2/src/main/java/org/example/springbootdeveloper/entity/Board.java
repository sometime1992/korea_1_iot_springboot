package org.example.springbootdeveloper.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor // 파라미터가 없는 기본 생성자
@AllArgsConstructor // 모든 필드값을 파라미터로 받는 생성자 생성
// @AllArgsConstructor 지금 필요한 인자값은 4개이지만 만약을 대비해서 넣어줌
@Getter
@Setter
@Entity
//클래스는 DB의 테이블에 존재하는 Column들을 필드로 가지는 객체를 말한다.
// Entity는 DB의 테이블과 1대 1로 대응되며, 때문에 테이블이 가지지 않는 컬럼을 필드로 가져서는 안된다.
// 또한 Entity 클래스는 다른 클래스를 상속받거나 인터페이스의 구현체여서는 안된다.
@Table(name = "board")
// DB와 이름이 다를 경우 이름 지정 name = "board"
public class Board {
    @Id // PK명시
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    // 기본 키 값을 자동 생성(자동 증가) - DB의 AUTO_INCREMENT를 사용
    // ID값을 생성하고 있지 않기 때문에  @GeneratedValue(strategy = GenerationType.IDENTITY)를 통해 DB에 ID생성/증가를 위임한다
    private Long id;

    @Column(nullable = false, length=50)
    private String writer;

    @Column(nullable = false, length=100)
    private String title;

    @Column(nullable = false, length=500)
    private String content;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private Category category;



    public Board(String writer, String title, String content, Category category) {
        this.writer = writer;
        this.title = title;
        this.content = content;
        this.category = category;

    }
}