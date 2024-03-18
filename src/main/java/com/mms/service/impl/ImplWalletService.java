package com.mms.service.impl;

import com.mms.dto.WalletDto;
import com.mms.entity.WalletEntity;
import com.mms.repository.WalletRepository;
import com.mms.service.WalletService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ImplWalletService implements WalletService {

    private final ModelMapper mapper;

    private final WalletRepository walletRepository;

    @Override
    public List<WalletDto> getAll() {
        List<WalletEntity> wallets = walletRepository.getAll();
        List<WalletDto> walletDtos = new ArrayList<>();
        if (!wallets.isEmpty()) {
            for (WalletEntity wallet: wallets) {
                WalletDto walletDto = mapper.map(wallet, WalletDto.class);
                walletDtos.add(walletDto);
            }
            return walletDtos;
        }
        return null;
    }

    @Override
    public WalletDto getById(Long id) {
        if (walletRepository.getWalletById(id).isPresent()) {
            return mapper.map(walletRepository.getWalletById(id).get(), WalletDto.class);
        }
        return null;
    }

    @Override
    @Transactional
    public WalletDto create(WalletDto walletDto) {
        WalletEntity wallet = mapper.map(walletDto, WalletEntity.class);
        if (wallet.getBalance() == null) {
            wallet.setBalance(BigDecimal.valueOf(0));
        }
        walletRepository.saveAndFlush(wallet);
        walletDto = mapper.map(wallet, WalletDto.class);
        return walletDto;
    }

    @Override
    @Transactional
    public WalletDto update(WalletDto walletDto, Long id) {
        WalletEntity wallet = mapper.map(getById(id), WalletEntity.class);
        wallet.setUpdatedAt(Date.from(Instant.now()));
        wallet.setUpdatedBy("anonymous");
        wallet.setName(walletDto.getName());
        wallet.setBalance(walletDto.getBalance());
        walletRepository.saveAndFlush(wallet);
        walletDto = mapper.map(wallet, WalletDto.class);
        return walletDto;
    }

    @Override
    @Transactional
    public void delete(Long id) {
        WalletEntity wallet = mapper.map(getById(id), WalletEntity.class);
        wallet.setDeleted(true);
        walletRepository.saveAndFlush(wallet);
    }

    @Override
    public BigDecimal getTotalBalance() {
        return walletRepository.getTotalBalance();
    }
}
