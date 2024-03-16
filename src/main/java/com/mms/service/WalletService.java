package com.mms.service;

import com.mms.dto.WalletDto;

import java.math.BigDecimal;
import java.util.List;

public interface WalletService {

    List<WalletDto> getAll();

    WalletDto getById(Long id);

    WalletDto create(WalletDto walletDto);

    WalletDto update(WalletDto walletDto, Long id);

    void delete(Long id);

    BigDecimal getTotalBalance();
}
