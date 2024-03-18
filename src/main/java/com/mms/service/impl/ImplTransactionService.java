package com.mms.service.impl;

import com.mms.dto.CategoryDto;
import com.mms.dto.TransactionDto;
import com.mms.dto.WalletDto;
import com.mms.entity.CategoryEntity;
import com.mms.entity.TransactionType;
import com.mms.entity.WalletEntity;
import com.mms.entity.connection.CategoryWalletEntity;
import com.mms.repository.CategoryRepository;
import com.mms.repository.CategoryWalletRepository;
import com.mms.repository.WalletRepository;
import com.mms.service.CategoryService;
import com.mms.service.TransactionService;
import com.mms.service.WalletService;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.Date;

@Service
@RequiredArgsConstructor
public class ImplTransactionService implements TransactionService {

    private final ModelMapper mapper;

    private final WalletRepository walletRepository;

    private final CategoryRepository categoryRepository;

    private final CategoryWalletRepository categoryWalletRepository;

    private final WalletService walletService;

    private final CategoryService categoryService;

    @Override
    @Transactional
    public TransactionDto create(TransactionDto transactionDto) {
        WalletDto walletDto = walletService.getById(transactionDto.getWalletId());
        CategoryDto categoryDto = categoryService.getById(transactionDto.getCategoryId());
        BigDecimal amount = transactionDto.getAmount();
        TransactionType type = categoryDto.getType();
        if (type.equals(TransactionType.INCOME)) {
            walletDto.setBalance(walletDto.getBalance().add(amount));
        } else {
            if (walletDto.getBalance().compareTo(amount) < 0) {
                return null;
            }
            walletDto.setBalance(walletDto.getBalance().subtract(amount));
        }
        categoryDto.setAmount(categoryDto.getAmount().add(amount));
        WalletEntity wallet = mapper.map(walletDto, WalletEntity.class);
        CategoryEntity category = mapper.map(categoryDto, CategoryEntity.class);
        CategoryWalletEntity categoryWallet = new CategoryWalletEntity();
        categoryWallet.setWallet(wallet);
        categoryWallet.setCategory(category);
        categoryWallet.setAmount(amount);
        categoryWallet.setDescription(transactionDto.getDescription());
        categoryWallet.setAtTime(new Date());
        walletRepository.saveAndFlush(wallet);
        categoryRepository.saveAndFlush(category);
        categoryWalletRepository.saveAndFlush(categoryWallet);
        transactionDto.setAtTime(categoryWallet.getAtTime());
        transactionDto.setTypeName(category.getType().getName());
        return transactionDto;
    }
}
