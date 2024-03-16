package com.mms.api;

import com.mms.dto.WalletDto;
import com.mms.exception.ObjectNotFoundException;
import com.mms.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class CrudWalletController {

    private final WalletService walletService;

    @GetMapping("/wallets")
    public List<WalletDto> getAll() {
        return walletService.getAll();
    }

    @GetMapping("/wallet/{id}")
    public WalletDto getById(@PathVariable Long id) {
        WalletDto walletDto = walletService.getById(id);
        if (walletDto == null) {
            throw new ObjectNotFoundException("Not found entity with id = " + id);
        }
        return walletDto;
    }

    @PostMapping("/wallet")
    public ResponseEntity<WalletDto> create(@RequestBody WalletDto walletDto) {
        WalletDto newWallet = walletService.create(walletDto);
        return new ResponseEntity<>(newWallet, HttpStatus.CREATED);
    }

    @PutMapping("/wallet/{id}")
    public ResponseEntity<WalletDto> update(@RequestBody WalletDto walletDto, @PathVariable Long id) {
        WalletDto editWallet = walletService.update(walletDto, id);
        return new ResponseEntity<>(editWallet, HttpStatus.CREATED);
    }

    @DeleteMapping("/wallet/{id}")
    public void delete(@PathVariable Long id) {
        walletService.delete(id);
    }
}
