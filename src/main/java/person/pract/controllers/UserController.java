package person.pract.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import person.pract.dtos.LoginDto;
import person.pract.dtos.UserRoleDto;
import person.pract.services.UserSvc;

@RequestMapping("api/v1/users")
@RestController
public class UserController {
    private final UserSvc svc;

    @Autowired
    public UserController(UserSvc svc) {
        this.svc = svc;
    }

    @PostMapping
    public @ResponseBody ResponseEntity<Object> create(@RequestBody LoginDto user) {
        return new ResponseEntity<>(this.svc.create(user), HttpStatus.OK);
    }

    @GetMapping
    public @ResponseBody ResponseEntity<Object> getAll() {
        return new ResponseEntity<>(this.svc.getAll(), HttpStatus.OK);
    }

    @GetMapping(path = "/{id}")
    public @ResponseBody ResponseEntity<Object> getById(@PathVariable("id") long userId) {
        return new ResponseEntity<>(this.svc.getById(userId), HttpStatus.OK);
    }

    @PostMapping(path = "/role/{id}")
    public @ResponseBody ResponseEntity<Object> createRole(@RequestBody UserRoleDto ur,
            @PathVariable("id") long userId) {
        return new ResponseEntity<>(this.svc.addRoleToUser(userId, ur), HttpStatus.OK);
    }

    // @PostMapping(path = "/cards/")
    // public void addCard(@RequestBody NewCardDto card) {
    // this.svc.addCard(card);
    // }
}
