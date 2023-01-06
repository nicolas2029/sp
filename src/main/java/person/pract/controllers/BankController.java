package person.pract.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import person.pract.dtos.AddressDto;
import person.pract.dtos.BankDto;
import person.pract.services.BankSvc;

@RestController
@RequestMapping("api/v1/bank")
public class BankController {
    private final BankSvc svc;

    @Autowired
    public BankController(BankSvc svc) {
        this.svc = svc;
    }

    @PostMapping
    public @ResponseBody ResponseEntity<Object> create(@RequestBody AddressDto bDto) {
        return new ResponseEntity<>(this.svc.create(bDto), HttpStatus.OK);
    }

    @GetMapping
    public @ResponseBody ResponseEntity<Object> getAll() {
        return new ResponseEntity<>(this.svc.getAll(), HttpStatus.OK);
    }

}
