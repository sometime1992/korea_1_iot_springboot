package org.example.springbootdeveloper.entity;

// 유니온 (확장과 제한 a|b - 제한)
// 인터페이스처럼 사용
public enum Category {
    NOTICE, // 공지사항
    FREE, // 자유게시판
    QNA, // 문의
    EVENT // 이벤트
}
