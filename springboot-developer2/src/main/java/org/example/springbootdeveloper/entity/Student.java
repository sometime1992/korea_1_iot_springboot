package org.example.springbootdeveloper.entity;


import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;


@Entity // Student 클래스를 JPA 엔터티임을 선언, DB 테이블과 매핑
@Table(name = "students") // 해당 엔터티가 'students'라는 이름의 테이블과 매핑됨을 명시
// db테이블 명과 dto클래스 명이 다른경우 명시해줘야 한다.
@Getter
@Setter
public class Student {

     @Id // 해당 필드가 테이블의 기본 키(PK)임을 명시
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     // 기본 키 값을 자동 생성(자동 증가) - DB의 AUTO_INCREMENT를 사용
     private Long id;
     // ID값을 생성하고 있지 않기 때문에  @GeneratedValue(strategy = GenerationType.IDENTITY)를 통해 DB에 ID생성/증가를 위임한다

    private String name;
    private String email;

     protected Student() {}
    // JPA는 엔터티 생성 시 기본 생성자를 사용 - 필수

    public Student(String name, String email) {
         this.name = name;
         this.email = email;
    }

}
