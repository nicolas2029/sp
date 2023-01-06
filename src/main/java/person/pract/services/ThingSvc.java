package person.pract.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import person.pract.dtos.ThingDto;
import person.pract.mappers.UserMapper;
import person.pract.models.Thing;
import person.pract.models.User;
import person.pract.repositories.ThingRepo;

@Service
public class ThingSvc {
    private final ThingRepo repo;
    private final UserMapper mapper;

    @Autowired
    public ThingSvc(ThingRepo repo, UserMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public ThingDto addThingToUser(long user_id, ThingDto dto) {
        Thing thing = this.mapper.toThing(dto);
        User user = User.builder().id(user_id).build();
        thing.setUser(user);
        return this.mapper.toThingDto(this.repo.save(thing));
    }
}
