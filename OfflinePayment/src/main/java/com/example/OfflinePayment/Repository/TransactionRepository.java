package com.example.OfflinePayment.Repository;

import com.example.OfflinePayment.Model.Transaction;
import com.example.OfflinePayment.Model.TransactionStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TransactionRepository extends JpaRepository<Transaction, Long> {
    Optional<List<Transaction>> findByStatus(TransactionStatus transactionStatus);
}
