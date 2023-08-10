package com.example.anything.stock.service;

import com.example.anything.stock.domain.Stock;
import com.example.anything.stock.repository.StockRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class StockService {
    private final StockRepository repository;

//    @Transactional
    public synchronized void decrease(Long id, Long quantity) {
        Stock stock = repository.findById(id).orElseThrow();
        stock.decrease(quantity);
        repository.saveAndFlush(stock);
    }
}
