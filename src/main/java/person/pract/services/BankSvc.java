package person.pract.services;

import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import lombok.extern.log4j.Log4j2;
import person.pract.dtos.AddressDto;
import person.pract.mappers.UserMapper;
import person.pract.models.Address;
import person.pract.repositories.AddressRepo;

@Service
@Log4j2
public class BankSvc {
    private final AddressRepo repo;
    private final UserMapper mapper;

    @Autowired
    public BankSvc(AddressRepo repo, UserMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public AddressDto create(AddressDto bDto) {
        Address b = this.mapper.toAddress(bDto);
        return this.mapper.toAddressDto(this.repo.save(b));
    }

    public List<AddressDto> getAll() {
        return this.mapper.toAddressesDto(this.repo.findAll());
    }
}
