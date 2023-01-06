package person.pract.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import person.pract.dtos.CardDto;
import person.pract.dtos.NewCardDto;
import person.pract.services.CardSvc;

@RestController
@RequestMapping("api/v1/cards")
public class CardController {
    private final CardSvc svc;

    @Autowired
    public CardController(CardSvc svc) {
        this.svc = svc;
    }

    @PostMapping
    public @ResponseBody ResponseEntity<Object> create(@RequestBody NewCardDto card) {
        return new ResponseEntity<>(this.svc.create(card), HttpStatus.OK);
    }

    @PatchMapping
    public @ResponseBody ResponseEntity<Object> increase(@RequestBody CardDto card) {
        return new ResponseEntity<>(this.svc.addCreditToCard(card), HttpStatus.OK);
    }

}
