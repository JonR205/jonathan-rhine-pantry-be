package net.yorksolutions.jonathanrhinepantrybe.repositories;

import net.yorksolutions.jonathanrhinepantrybe.entity.Account;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AccountRepository extends CrudRepository<Account, Long> {

    public Optional<Account> findAccountByUsernameAndPassword(String username, String password);

    public Optional<Account> findAccountByUsername(String username);
}
