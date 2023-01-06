package person.pract.dtos.user;

import java.util.Set;

import person.pract.dtos.CardDto;
import person.pract.dtos.ThingDto;
import person.pract.dtos.UserRoleDto;

public class FullUserDto {
    public long id;
    public String email;
    public String name;
    public int age;
    public Set<CardDto> cards;
    public Set<UserRoleDto> roles;
    public Set<ThingDto> things;
}
