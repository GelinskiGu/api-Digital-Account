package com.gelinski.apiBtgChallenge.services;

import com.gelinski.apiBtgChallenge.data.dto.v1.AccountDTOV1;
import com.gelinski.apiBtgChallenge.data.dto.v1.ClientDTOV1;
import com.gelinski.apiBtgChallenge.data.dto.v1.TransactionDTOV1;
import com.gelinski.apiBtgChallenge.exceptions.ResourceNotFoundException;
import com.gelinski.apiBtgChallenge.mapper.AccountMapper;
import com.gelinski.apiBtgChallenge.mapper.ClientMapper;
import com.gelinski.apiBtgChallenge.mapper.TransactionMapper;
import com.gelinski.apiBtgChallenge.models.AccountEntity;
import com.gelinski.apiBtgChallenge.models.TransactionEntity;
import com.gelinski.apiBtgChallenge.repositories.AccountEntityRepository;
import com.gelinski.apiBtgChallenge.repositories.ClientEntityRepository;
import com.gelinski.apiBtgChallenge.repositories.TransactionEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.logging.Logger;

@Service
public class TransactionService {
    private final Logger logger = Logger.getLogger(TransactionService.class.getName());

    @Autowired
    TransactionEntityRepository transactionRepository;
    @Autowired
    AccountEntityRepository accountRepository;

    public TransactionDTOV1 create(TransactionDTOV1 transaction) {
        logger.info("Creating one transaction!");

        TransactionEntity entity = TransactionMapper.INSTANCE.dtoToEntity(transaction);

        AccountDTOV1 account = AccountMapper.INSTANCE.entityToDTO(accountRepository.findById(transaction.getAccountId()).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this account ID")));

        List<TransactionEntity> transactions = account.getTransactions();
        transactions.add(entity);
        account.setTransactions(transactions);
        accountRepository.save(AccountMapper.INSTANCE.dtoToEntity(account));

        TransactionEntity savedEntity = transactionRepository.save(entity);

        return TransactionMapper.INSTANCE.entityToDTO(savedEntity);
    }

    public List<TransactionDTOV1> findAll() {
        logger.info("Finding all transactions!");

        return TransactionMapper.INSTANCE.mapToDTO(transactionRepository.findAll());
    }

    public TransactionDTOV1 findById(Long id) {
        logger.info("Finding one transaction!");

        TransactionEntity entity = transactionRepository.findById(id).orElseThrow(
                () -> new ResourceNotFoundException("No records found for this transaction ID"));

        return TransactionMapper.INSTANCE.entityToDTO(entity);
    }

}
