package person.pract.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import person.pract.dtos.ThingDto;
import person.pract.services.ThingSvc;

@RestController
@RequestMapping("api/v1/thing")
public class ThingController {
    private final ThingSvc svc;

    @Autowired
    public ThingController(ThingSvc svc) {
        this.svc = svc;
    }

    @PostMapping(path = "/{id}")
    public @ResponseBody ResponseEntity<Object> addToUser(@RequestBody ThingDto thing,
            @PathVariable("id") long userId) {
        return new ResponseEntity<>(this.svc.addThingToUser(userId, thing), HttpStatus.OK);
    }

}
