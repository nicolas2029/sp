package person.pract.services;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import person.pract.dtos.LoginDto;
import person.pract.dtos.UserDto;
import person.pract.dtos.UserRoleDto;
import person.pract.dtos.user.FullUserDto;
import person.pract.mappers.UserMapper;
import person.pract.models.User;
import person.pract.models.UserRole;
import person.pract.repositories.UserRepo;
import person.pract.repositories.UserRoleRepo;

@Service
public class UserSvc {
    private final UserRepo repo;
    private final UserRoleRepo urRepo;
    private final UserMapper mapper;

    @Autowired

    public UserSvc(UserRepo repo, UserRoleRepo urRepo, UserMapper mapper) {
        this.repo = repo;
        this.urRepo = urRepo;
        this.mapper = mapper;
    }

    public UserDto create(LoginDto lDto) {
        User user = mapper.LoginDtoToUser(lDto);
        return this.mapper.ToUserDto(this.repo.save(user));
    }

    public List<UserDto> getAll() {
        return this.mapper.ToUsersDto(this.repo.findAll());
    }

    public FullUserDto getById(long userId) {
        return this.mapper.toFullUserDto(this.repo.getUserWithRolesAndCards(userId));
    }

    public UserRoleDto addRoleToUser(long userId, UserRoleDto dto) {
        dto.registeredAt = LocalDateTime.now();
        UserRole ur = this.mapper.toUserRole(dto);
        User user = new User();
        user.setId(userId);
        ur.setUser(user);
        return this.mapper.toUserRoleDto(this.urRepo.save(ur));
    }

    // @Transactional
    // public void addCard(NewCardDto cDto) {
    // User user = this.repo.findById(cDto.user_id).orElseThrow();
    // Bank bank = new Bank();
    // bank.setId(cDto.bank_id);
    // Card card = new Card(0L, 0L, user, bank);
    // user.addCard(card);
    // }

    // @Transactional
    // Card addCard(Card card, long userId) {
    // User user = this.repo.findById(userId).orElseThrow();
    // user.
    // }
}
