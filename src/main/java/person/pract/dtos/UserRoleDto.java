package person.pract.dtos;

import java.time.LocalDateTime;

public class UserRoleDto {
    public long id;
    public LocalDateTime registeredAt;
    public RoleDto role;
    public int grade;
}
