package com.mms.api;

import com.mms.dto.TransactionDto;
import com.mms.exception.ObjectNotFoundException;
import com.mms.service.TransactionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CrudTransactionController {

    private final TransactionService transactionService;

    @GetMapping("/transactions")
    public List<TransactionDto> getAll() {
        return transactionService.getAll();
    }

    @GetMapping("/transaction/{id}")
    public TransactionDto getById(@PathVariable Long id) {
        TransactionDto transactionDto = transactionService.getById(id);
        if (transactionDto == null) {
            throw new ObjectNotFoundException("Not found entity with id = " + id);
        }
        return transactionDto;
    }

    @PostMapping("/transaction")
    public ResponseEntity<TransactionDto> addNewTransaction(@RequestBody TransactionDto transactionDto) {
        TransactionDto newTransaction = transactionService.create(transactionDto);
        return new ResponseEntity<>(newTransaction, HttpStatus.CREATED);
    }
}
