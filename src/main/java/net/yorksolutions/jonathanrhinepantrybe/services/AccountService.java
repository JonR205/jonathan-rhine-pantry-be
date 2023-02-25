package net.yorksolutions.jonathanrhinepantrybe.services;

import net.yorksolutions.jonathanrhinepantrybe.entity.Account;
import net.yorksolutions.jonathanrhinepantrybe.entity.Ingredient;
import net.yorksolutions.jonathanrhinepantrybe.repositories.AccountRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Optional;

@Service
public class AccountService {

    private AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    public Account getByUsernameAndPassword(String username, String password) {
        return accountRepository.findAccountByUsernameAndPassword(username, password).orElse(null);
    }

    public ResponseEntity<Account> register(Account accountRequest) throws Exception {
        if (accountRepository.findAccountByUsername(accountRequest.getUsername()).isPresent()) throw new Exception();

        if (accountRequest.getUsername().equals(null)) {
            throw new Exception();
        } else if (accountRequest.getPassword().equals(null)) {
            throw new Exception();
        }

        return new ResponseEntity<>(accountRepository.save(accountRequest), HttpStatus.OK);
    }

    public Account getAccountById(Long id) {
        return accountRepository.findById(id).orElse(null);
    }

    public void deleteById(Long id) {
        Optional<Account> accountOpt = accountRepository.findById(id);

        accountRepository.deleteById(id);

    }

    public void editAccount(Long id, Account accountRequest) {
        Optional<Account> accountOpt = this.accountRepository.findById(id);
        if (accountOpt.isEmpty()) {
            throw new ResponseStatusException((HttpStatus.NOT_FOUND));
        }
        accountRepository.save(accountRequest);
    }
}
