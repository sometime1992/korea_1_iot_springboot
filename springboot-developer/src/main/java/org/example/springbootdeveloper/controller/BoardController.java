package org.example.springbootdeveloper.controller;

import org.example.springbootdeveloper.dto.BoardDto;
import org.example.springbootdeveloper.dto.StudentDto;
import org.example.springbootdeveloper.service.BoardService;
import org.example.springbootdeveloper.service.StudentService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/board")
public class BoardController {

    private final BoardService boardservice;

    public BoardController(BoardService boardservice) {
        this.boardservice = boardservice;

    }

    // board전체 조회
    @GetMapping
    public List<BoardDto> getAllBoard() {
        return boardservice.getAllBoard();
    }

    // board ID조회(맵핑)
    @GetMapping("/{id}")
    public BoardDto getBoardById(@PathVariable Long id) {
        return boardservice.getBoardById(id);
    }

    // @Requestbody로 인자값으로 들어오는 중요 정보를 PostMapping(전달)로 전달
    @PostMapping
    public BoardDto createBoard(@RequestBody BoardDto boardDto) {
        return boardservice.createBoard(boardDto);
    }

    // @PutMapping ID값으로 특정 ID 정보 수정
    @PutMapping("/{id}")
    public BoardDto updateBoard(@PathVariable Long id, @RequestBody BoardDto boardDto) {
        // @PathVariable Long id - 수정할 id
        // @RequestBody StudentDto studentDto - DB에 있는 학생 정보
        // 수정할 id를 DB에 있는 정보에 수정후 삽입
        return boardservice.updateBoard(id, boardDto);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBoard(@PathVariable Long id) {
        boardservice.deleteBoard(id);
        return ResponseEntity.noContent().build();
    }

}
