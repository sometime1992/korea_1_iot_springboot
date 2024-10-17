package org.example.springbootdeveloper.service;

import org.example.springbootdeveloper.dto.BoardDto;
import org.example.springbootdeveloper.dto.StudentDto;
import org.example.springbootdeveloper.entity.Board;
import org.example.springbootdeveloper.entity.Student;
import org.example.springbootdeveloper.repository.BoardRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoardService {

    private final BoardRepository boardRepository;

    // @Service에 @Component로 빈에 등록했기 때문에 따로 생성을 하지않아도 BoardService 사용 가능
    public BoardService(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    public List<BoardDto> getAllBoard() {
        try {
            List<Board> boards = boardRepository.findAll();
            List<BoardDto> boardsDto = boards.stream()
                    .map(board -> new BoardDto(
                            board.getId(),
                            board.getWriter(),
                            board.getTitle(),
                            board.getContent(),
                            board.getCategory()
                    ))
                    .collect(Collectors.toList());
            // toList로 바로 받으면 수정이 불가능함

            return boardsDto;
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Error occurred while fetching board", e
            );
        }
    }

    public BoardDto getBoardById(Long id) {
        try {
            Board board = boardRepository.findById(id)
                    .orElseThrow(() -> new Error("Board not found with id: " + id));
            BoardDto boardDto = new BoardDto(
                    board.getId(),
                    board.getWriter(),
                    board.getTitle(),
                    board.getContent(),
                    board.getCategory()
            );
            return boardDto;
        } catch(Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Error occurred while fetching the board", e
                    // ResponseStatusException(status상태,reason설명,cause원인)
            );
        }
    }

    public BoardDto createBoard(BoardDto boardDto) {
        try {
            Board board = new Board(boardDto.getWriter(), boardDto.getTitle(), boardDto.getContent(), boardDto.getCategory());
            Board savedBoard = boardRepository.save(board);
            return new BoardDto(savedBoard.getId()
                    , savedBoard.getWriter()
                    , savedBoard.getTitle()
                    , savedBoard.getContent()
                    , savedBoard.getCategory());

        } catch(Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.BAD_REQUEST,
                    "Failed to create board", e
            );
        }
    }

    public BoardDto updateBoard(Long id, BoardDto boardDto) {
        try {
            // 수정할 board 데이터를 ID로 조회
            Board board = boardRepository.findById(id)
                    .orElseThrow(() -> new Error("Student not found with id" + id));
            // 수정할 board가 없는 경우 예외 발생

            // 정보 수정
            board.setWriter(boardDto.getWriter());
            board.setTitle(boardDto.getTitle());
            board.setContent(boardDto.getContent());
            board.setCategory(boardDto.getCategory());


            // 수정된 내용을 DB에 저장
            Board updatedBoard = boardRepository.save(board);

            // 수정된 객체를 DTO로 변환하여 반환
            return new BoardDto(updatedBoard.getId()
                    , updatedBoard.getWriter()
                    , updatedBoard.getTitle()
                    , updatedBoard.getContent()
                    , updatedBoard.getCategory()

            );

        } catch(Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Error occurred while updating board"
            );
        }
    }

    public void deleteBoard(Long id) {
        try {

            Board board = boardRepository.findById(id)
                    .orElseThrow(() ->
                            new Error("board not found with id" + id)
                    );
            boardRepository.delete(board);
        } catch (Exception e) {
            throw new ResponseStatusException(
                    HttpStatus.INTERNAL_SERVER_ERROR,
                    "Error occurred while deleting board", e
            );
        }
    }
}


