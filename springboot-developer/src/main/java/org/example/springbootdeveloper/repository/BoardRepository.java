package org.example.springbootdeveloper.repository;

import org.example.springbootdeveloper.entity.Board;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board, Long> {
//    데이터베이스의 추가, 조회, 수정, 삭제의 findAll(), findById(), save() 등의 메서드들을 사용할 수 있습니다.
//    제공되는 메서드들 이용하여 쉽고 간편하게 CRUD 조작을 할 수 있습니다.
//    즉, JpaRepository를 사용하면, 복잡한 JDBC(Java DataBase Connectivity) 코드를 작성하지 않아도 간단하게 DB와의 데이터 접근 작업을 처리할 수 있습니다.
}
