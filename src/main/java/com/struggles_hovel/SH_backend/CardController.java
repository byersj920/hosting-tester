package com.struggles_hovel.SH_backend;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cards")
public class CardController {

    @Autowired
    private CardRepository cardRepository;

    @GetMapping
    public List<Card> getAllCards() {
        return cardRepository.findAll();
    }

    @PostMapping
    public Card addCardToDatabase(@RequestBody Card card) {
        return cardRepository.save(card);
    }



    @PostMapping("/add")
    public Card addUsernameToCard(@RequestParam Long cardId, @RequestParam String username) {
        Optional<Card> optionalCard = cardRepository.findById(cardId);
        if (optionalCard.isPresent()) {
            Card card = optionalCard.get();
            card.addUsername(username);
            return cardRepository.save(card);
        } else {
            throw new RuntimeException("Card not found");
        }
    }

    @PostMapping("/uploadCards")
    public Integer uploadCardsToCube(@RequestParam ArrayList<Number> cardList, @RequestParam String username) {

        Integer cardCounter = 0;

        for (Number cardId : cardList) {
            Optional<Card> optionalCard = cardRepository.findById(cardId.longValue());

            if (optionalCard.isPresent()) {
                Card card = optionalCard.get();

                if (card.getNumberNeeded() > 0) {
                    card.addUsername(username);
                    card.setNumberNeeded(card.getNumberNeeded() - 1);
                    cardRepository.save(card);
                    cardCounter++;
                }
            }
        }

        return cardCounter;
    }

    @PostMapping("/remove")
    public Card removeUsernameFromCard(@RequestParam Long cardId, @RequestParam String username) {

        Optional<Card> optionalCard = cardRepository.findById(cardId);
        if (optionalCard.isPresent()) {
            Card card = optionalCard.get();
            card.removeUsername(username);
            return cardRepository.save(card);
        } else {
            throw new RuntimeException("Card not found");
        }
    }
}
