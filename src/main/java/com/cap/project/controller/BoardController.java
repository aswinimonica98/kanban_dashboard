package com.cap.project.controller;

import com.cap.project.domain.Board;
import com.cap.project.service.BoardService;
import com.cap.project.config.UserDetailsImpl;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boards")
public class BoardController {

    private final BoardService service;

    public BoardController(BoardService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Board> createBoard(@RequestBody Board board, Authentication authentication) {
        if (authentication != null && authentication.getPrincipal() instanceof UserDetailsImpl ud) {
            board.setCreatedBy(ud.getId());
        }
        Board created = service.createBoard(board);
        return ResponseEntity.ok(created);
    }

    @GetMapping
    public ResponseEntity<List<Board>> getBoards(Authentication authentication) {
        Long userId = null;
        if (authentication != null && authentication.getPrincipal() instanceof UserDetailsImpl ud) {
            userId = ud.getId();
        }
        List<Board> boards = service.getBoardsForUser(userId);
        return ResponseEntity.ok(boards);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Board> getById(@PathVariable String id) {
        return ResponseEntity.ok(service.getBoardById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Board> update(@PathVariable String id, @RequestBody Board board) {
        return ResponseEntity.ok(service.updateBoard(id, board));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable String id) {
        service.deleteBoard(id);
        return ResponseEntity.noContent().build();
    }
}
