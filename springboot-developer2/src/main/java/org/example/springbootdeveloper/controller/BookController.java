package org.example.springbootdeveloper.controller;

import lombok.RequiredArgsConstructor;
import org.example.springbootdeveloper.dto.request.BookRequestDto;
import org.example.springbootdeveloper.dto.request.BookRequestUpdateDto;
import org.example.springbootdeveloper.dto.response.BookResponseDto;
import org.example.springbootdeveloper.entity.Category;
import org.example.springbootdeveloper.service.BookService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/books")
@RequiredArgsConstructor
// 초기화 되지 않은 final 필드나 @NonNull이 붙은 필드에 대해 생성자를 생성
public class BookController {
    // Service 객체를 주입 받아 사용하는 변수
    private final BookService bookService;

    // 생성자 주입 - RequiredArgsConstructor로 대체
//    public BookController(BookService bookService) {
//        this.bookService = bookService;
//    }

    // 책 생성
    @PostMapping
    public ResponseEntity<BookResponseDto> createdBook(@RequestBody BookRequestDto requestDto) {
        BookResponseDto createdBook = bookService.createBook(requestDto);
        return ResponseEntity.ok(createdBook);
    }

    // 전체 책 조회
    @GetMapping
    public ResponseEntity<List<BookResponseDto>> getAllBooks() {
        List<BookResponseDto> books = bookService.getAllBooks();
        return ResponseEntity.ok(books);
    }


    // 단건 책 조회
    @GetMapping("/{id}")
    public ResponseEntity<BookResponseDto> getBookById(@PathVariable Long id) {
        BookResponseDto book = bookService.getBookById(id);
        return ResponseEntity.ok(book);
    }

    // 제목에 특정 단어가 포함된 게시글 조회
    @GetMapping("/search/title")
    public ResponseEntity<List<BookResponseDto>> getBooksByTitleContaining(
            @RequestParam String keyword
            // @RequestParam으로 중요하지 않은 정보를 url로 받아 전달(값을 전달하지 않고 보내려면 required = false지정)
    ) {
        List<BookResponseDto> books = bookService.getBooksBytitleContaining(keyword);
        return ResponseEntity.ok(books);
    }

    // 카테고리별 책 조회
    @GetMapping("/category/{category}") // {} 변수,인자 값
    //PathVariable을 사용하면 리소스 경로에 식별자를 넣어서 동적으로 URL에 정보를 담을 수 있다.
    //URL 경로의 중괄호 { } 안쪽에 변수를 담고, 그 변수를 @PathVariable(" ")로 받아서 사용할 수 있다.
    public ResponseEntity<List<BookResponseDto>> getBooksByCategory(@PathVariable Category category) {
        List<BookResponseDto> books = bookService.getBooksByCategory(category);
        return ResponseEntity.ok(books);
    }

    // 카테고리와 작성자별 책 조회
    @GetMapping("/search/category-writer")
    public ResponseEntity<List<BookResponseDto>> getBooksByCategoryAndWriter(
            @RequestParam(required = false) Category category,
            @RequestParam String writer
    ) {
        List<BookResponseDto> books = bookService.getBooksByCategoryAndWriter(category, writer);
            return ResponseEntity.ok(books);
    }

    // 특정 id 책 수정
    @PutMapping("/{id}")
    public ResponseEntity<BookResponseDto> updatedBook(
            @PathVariable Long id, @RequestBody BookRequestUpdateDto requestDto
    ) {
        BookResponseDto updatedBook = bookService.updateBook(id, requestDto);
        return ResponseEntity.ok(updatedBook);
    }

    // 특정 id 책 삭제
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookService.deleteBook(id);
        return ResponseEntity.noContent().build();
    }
}