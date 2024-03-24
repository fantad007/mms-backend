package com.mms.service;

import com.mms.dto.TransactionDto;

import java.util.List;

public interface TransactionService {

    List<TransactionDto> getAll();

    TransactionDto getById(Long id);

    TransactionDto create(TransactionDto transactionDto);

    TransactionDto update(TransactionDto transactionDto, Long id);

    void delete(Long id);
}
