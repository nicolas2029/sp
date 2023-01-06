package person.pract.mappers;

import java.util.List;

import org.mapstruct.Mapper;

import person.pract.dtos.AddressDto;
import person.pract.dtos.BankDto;
import person.pract.dtos.CardDto;
import person.pract.dtos.FullCardDto;
import person.pract.dtos.LoginDto;
import person.pract.dtos.NewCardDto;
import person.pract.dtos.ThingDto;
import person.pract.dtos.UserDto;
import person.pract.dtos.UserRoleDto;
import person.pract.dtos.user.FullUserDto;
import person.pract.models.Address;
import person.pract.models.Bank;
import person.pract.models.Card;
import person.pract.models.Thing;
import person.pract.models.User;
import person.pract.models.UserRole;

@Mapper(componentModel = "spring")
public interface UserMapper {
    UserDto ToUserDto(User user);

    List<UserDto> ToUsersDto(List<User> users);

    User LoginDtoToUser(LoginDto lDto);

    UserRoleDto toUserRoleDto(UserRole userRole);

    CardDto toCardDto(Card card);

    Card toCard(CardDto cDto);

    Card newToCard(NewCardDto cDto);

    FullCardDto toFullCardDto(Card card);

    FullUserDto toFullUserDto(User user);

    Address toAddress(AddressDto aDto);

    AddressDto toAddressDto(Address address);

    BankDto toBankDto(Bank bank);

    Bank toBank(BankDto bDto);

    List<AddressDto> toAddressesDto(List<Address> addresses);

    UserRole toUserRole(UserRoleDto dto);

    ThingDto toThingDto(Thing thing);

    Thing toThing(ThingDto dto);
}
