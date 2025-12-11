package com.cap.project.service;

import com.cap.project.domain.Card;
import com.cap.project.repository.CardRepository;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.UUID;

@Service
public class CardServiceImpl implements CardService {

    private final CardRepository cardRepository;
    // WIP limit per user (example)
    private static final int WIP_LIMIT = 3;

    public CardServiceImpl(CardRepository cardRepository) {
        this.cardRepository = cardRepository;
    }

    @Override
    public Card createCard(Card card) {
        card.setCardId(UUID.randomUUID().toString());
        card.setCreatedAt(new Date());
        card.setUpdatedAt(new Date());

        // If card is being created in WIP column, enforce limit
        if (card.getColumnId() != null) {
            int wipCount = cardRepository.countByAssignedToAndColumnId(card.getAssignedTo(), card.getColumnId());
            // We assume front-end uses the WORK_IN_PROGRESS columnId for WIP enforcement;
            // a safer approach is to fetch Board and find the column by title
            if (wipCount >= WIP_LIMIT) {
                throw new RuntimeException("WIP limit exceeded for user " + card.getAssignedTo());
            }
        }

        return cardRepository.save(card);
    }

    @Override
    public List<Card> getCardsByBoard(String boardId) {
        return cardRepository.findByBoardId(boardId);
    }

    @Override
    public Card updateCard(String cardId, Card card) {
        Card existing = cardRepository.findById(cardId)
                .orElseThrow(() -> new RuntimeException("Card not found"));
        existing.setTitle(card.getTitle());
        existing.setDescription(card.getDescription());
        existing.setAssignedTo(card.getAssignedTo());
        existing.setColumnId(card.getColumnId());
        existing.setUpdatedAt(new Date());
        return cardRepository.save(existing);
    }

    @Override
    public void deleteCard(String cardId) {
        cardRepository.deleteById(cardId);
    }
}
