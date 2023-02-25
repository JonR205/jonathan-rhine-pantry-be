package net.yorksolutions.jonathanrhinepantrybe.controllers;

import net.yorksolutions.jonathanrhinepantrybe.entity.Account;
import net.yorksolutions.jonathanrhinepantrybe.entity.Ingredient;
import net.yorksolutions.jonathanrhinepantrybe.services.AccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

@RestController
@RequestMapping("/accounts")
@CrossOrigin
public class AccountControllers {

    private AccountService accountService;

    public AccountControllers(AccountService accountService) {
        this.accountService = accountService;
    }

    @GetMapping("/{id}")
    public Account getAccountById(@PathVariable Long id) {
        return accountService.getAccountById(id);
    }


    @GetMapping
    public ResponseEntity<Account> getByUsernameAndPassword(@RequestParam String username,
                                                            @RequestParam String password) {

        final var account = accountService.getByUsernameAndPassword(username, password);

        if (account == null)
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);

        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @PostMapping
    public void register(@RequestBody Account accountRequest) {
        try {
            accountService.register(accountRequest);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.PRECONDITION_FAILED);
        }
    }

    @DeleteMapping("/{id}")
    public void deleteAccountById(@PathVariable Long id) {
        try {
            accountService.deleteById(id);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public void editAccount(@PathVariable Long id, @RequestBody Account accountRequest){
        try {
            accountService.editAccount(id, accountRequest);
        } catch (Exception e) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
