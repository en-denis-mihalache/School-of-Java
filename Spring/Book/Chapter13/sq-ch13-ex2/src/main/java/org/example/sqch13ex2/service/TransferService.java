package org.example.sqch13ex2.service;

import org.example.sqch13ex2.model.Account;
import org.example.sqch13ex2.repository.AccountRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.util.List;

@Service
public class TransferService {
    private final AccountRepository accountRepository;

    public TransferService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public void transfer(long idSender, long idReceiver, BigDecimal amount){

        Account sender = accountRepository.findAccountById(idSender);
        Account receiver = accountRepository.findAccountById(idReceiver);

        BigDecimal senderNewAmount = sender.getAmount().subtract(amount);
        BigDecimal receiverNewAmount = receiver.getAmount().add(amount);

        accountRepository.changeAmount(idSender,senderNewAmount);
        accountRepository.changeAmount(idReceiver,receiverNewAmount);

        throw new RuntimeException("OH NO BIG NONO!");
    }

    public List<Account> getAllAccounts(){
        return accountRepository.findAllAccounts();
    }
}
