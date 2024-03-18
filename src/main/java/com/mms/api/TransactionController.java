package com.mms.api;

import com.mms.dto.TransactionDto;
import com.mms.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class TransactionController {

    private final TransactionService transactionService;

    @PostMapping("/transaction")
    public ResponseEntity<TransactionDto> addNewTransaction(@RequestBody TransactionDto transactionDto) {
        TransactionDto newTransaction = transactionService.create(transactionDto);
        return new ResponseEntity<>(newTransaction, HttpStatus.CREATED);
    }
}
