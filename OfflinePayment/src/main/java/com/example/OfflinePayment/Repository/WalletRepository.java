package com.example.OfflinePayment.Repository;

import com.example.OfflinePayment.Model.Wallet;
import org.springframework.data.jpa.repository.JpaRepository;

public interface WalletRepository extends JpaRepository<Wallet,Long> {

}
