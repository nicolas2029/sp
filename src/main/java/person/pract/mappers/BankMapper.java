package person.pract.mappers;

import org.mapstruct.Mapper;

import person.pract.dtos.AddressDto;
import person.pract.dtos.BankDto;
import person.pract.dtos.ThingDto;
import person.pract.models.Address;
import person.pract.models.Bank;

// @Mapper(componentModel = "spring")
public interface BankMapper {
    Address toAddress(AddressDto aDto);

    AddressDto toAddressDto(Address address);

    BankDto toBankDto(Bank bank);

    Bank toBank(BankDto bDto);

}
