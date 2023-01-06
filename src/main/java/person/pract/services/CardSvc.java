package person.pract.services;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import person.pract.dtos.CardDto;
import person.pract.dtos.FullCardDto;
import person.pract.dtos.NewCardDto;
import person.pract.mappers.UserMapper;
import person.pract.models.Card;
import person.pract.repositories.CardRepo;

@Service
public class CardSvc {
    private final CardRepo repo;
    private final UserMapper mapper;

    @Autowired
    public CardSvc(CardRepo repo, UserMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    @Transactional
    public FullCardDto addCreditToCard(CardDto cDto) {
        Card card = this.repo.findById(cDto.id).orElseThrow();
        card.increase(cDto.balance);
        return this.mapper.toFullCardDto(card);
    }

    public FullCardDto create(NewCardDto card) {
        return this.mapper.toFullCardDto(this.repo.save(this.mapper.newToCard(card)));
    }
}
