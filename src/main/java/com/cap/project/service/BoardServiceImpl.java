package com.cap.project.service;

import com.cap.project.domain.Board;
import com.cap.project.domain.ColumnMeta;
import com.cap.project.repository.BoardRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class BoardServiceImpl implements BoardService {

    private final BoardRepository boardRepository;

    public BoardServiceImpl(BoardRepository boardRepository) {
        this.boardRepository = boardRepository;
    }

    @Override
    public Board createBoard(Board board) {
        board.setBoardId(UUID.randomUUID().toString());
        List<ColumnMeta> defaultCols = List.of(
                new ColumnMeta(UUID.randomUUID().toString(), "TO_BE_DONE", 0),
                new ColumnMeta(UUID.randomUUID().toString(), "WORK_IN_PROGRESS", 1),
                new ColumnMeta(UUID.randomUUID().toString(), "COMPLETED", 2)
        );
        if (board.getColumns() == null || board.getColumns().isEmpty()) {
            board.setColumns(defaultCols);
        }
        return boardRepository.save(board);
    }

    @Override
    public List<Board> getBoardsForUser(Long userId) {
        return boardRepository.findByCreatedBy(userId);
    }

    @Override
    public Board getBoardById(String boardId) {
        return boardRepository.findById(boardId)
                .orElseThrow(() -> new RuntimeException("Board not found"));
    }

    @Override
    public Board updateBoard(String boardId, Board board) {
        Board existing = getBoardById(boardId);
        existing.setName(board.getName());
        existing.setDescription(board.getDescription());
        existing.setMemberIds(board.getMemberIds());
        return boardRepository.save(existing);
    }

    @Override
    public void deleteBoard(String boardId) {
        boardRepository.deleteById(boardId);
    }
}
