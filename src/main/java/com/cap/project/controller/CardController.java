package com.cap.project.controller;

import com.cap.project.domain.Card;
import com.cap.project.service.CardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    private final CardService service;

    public CardController(CardService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Card> createCard(@RequestBody Card card) {
        return ResponseEntity.ok(service.createCard(card));
    }

    @GetMapping("/board/{boardId}")
    public ResponseEntity<List<Card>> getByBoard(@PathVariable String boardId) {
        return ResponseEntity.ok(service.getCardsByBoard(boardId));
    }

    @PutMapping("/{cardId}")
    public ResponseEntity<Card> update(@PathVariable String cardId, @RequestBody Card card) {
        return ResponseEntity.ok(service.updateCard(cardId, card));
    }

    @DeleteMapping("/{cardId}")
    public ResponseEntity<Void> delete(@PathVariable String cardId) {
        service.deleteCard(cardId);
        return ResponseEntity.noContent().build();
    }
}
