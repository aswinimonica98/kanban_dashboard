package com.cap.project.repository;

import com.cap.project.domain.Board;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface BoardRepository extends MongoRepository<Board, String> {
    List<Board> findByCreatedBy(Long createdBy);
}
