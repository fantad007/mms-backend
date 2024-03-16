package com.mms.api;

import com.mms.service.WalletService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.math.BigDecimal;

@RestController
@RequiredArgsConstructor
public class WalletController {

    private final WalletService walletService;

    @GetMapping("/wallets/total-balance")
    public BigDecimal getTotalBalance() {
        return walletService.getTotalBalance();
    }
}
