package com.example.anything.stock.domain;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Getter
@NoArgsConstructor
public class Stock {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Long productID;
    private Long quantity;

    @Version
    private Long version;

    public Stock(Long productID, Long quantity) {
        this.productID = productID;
        this.quantity = quantity;
    }

    public void decrease(Long quantity){
        if(this.quantity-quantity <0){
            throw new RuntimeException("재고는 0개 미만이 될 수 없습니다.");
        }
        this.quantity -= quantity;

    }

}
