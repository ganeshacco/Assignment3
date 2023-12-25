package com.example.OfflinePayment.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
@Data
@Builder
//@NoArgsConstructor
@AllArgsConstructor
@Entity
public class User implements UserDetails {
    @Id
    Long userId;

    String userName;

    String password;

    public void setPassword(String password) {
        this.password = password;
    }

    String user_secret;

    Boolean user_status;

    Boolean user_enrolled;

    Boolean user_enrollapproved;

    Double user_latitude;

    Double user_longitude;

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Wallet wallet;





//    public void addOfflinePaymentCode(OfflinePaymentCode code) {
//        offlinePaymentCodes.add(code);
//        code.setUser(this);
//    }
//
//    public void removeOfflinePaymentCode(OfflinePaymentCode code) {
//        offlinePaymentCodes.remove(code);
//        code.setUser(null);
//    }

    @Override
    public String toString() {
        return "User{" +
                "user_id=" + userId +
                ", name='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", user_secret='" + user_secret + '\'' +
                ", user_status=" + user_status +
                ", user_enrolled=" + user_enrolled +
                ", user_enrollapproved=" + user_enrollapproved +
                ", user_latitude=" + user_latitude +
                ", user_longitude=" + user_longitude +
                ", wallet=" + wallet +
                ", role=" + role +
                '}';
    }

    public Wallet getWallet() {
        return wallet;
    }

    public void setWallet(Wallet wallet) {
        this.wallet = wallet;
    }



    public User(Long user_id, String userName, String user_secret, Boolean user_status, Boolean user_enrolled, Boolean user_enrollapproved, Double user_latitude, Double user_longitude) {
        this.userId = userId;
        this.userName = userName;
        this.user_secret = user_secret;
        this.user_status = user_status;
        this.user_enrolled = user_enrolled;
        this.user_enrollapproved = user_enrollapproved;
        this.user_latitude = user_latitude;
        this.user_longitude = user_longitude;
    }

    public Boolean getUser_enrollapproved() {
        return user_enrollapproved;
    }

    public void setUser_enrollapproved(Boolean user_enrollapproved) {
        this.user_enrollapproved = user_enrollapproved;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {

        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setName(String userName) {
        this.userName = userName;
    }

    public String getUser_secret() {
        return user_secret;
    }

    public void setUser_secret(String user_secret) {
        this.user_secret = user_secret;
    }

    public Boolean getUser_status() {
        return user_status;
    }

    public void setUser_status(Boolean user_status) {
        this.user_status = user_status;
    }

    public Boolean getUser_enrolled() {
        return user_enrolled;
    }

    public void setUser_enrolled(Boolean user_enrolled) {
        this.user_enrolled = user_enrolled;
    }

    public Double getUser_latitude() {
        return user_latitude;
    }

    public void setUser_latitude(Double user_latitude) {
        this.user_latitude = user_latitude;
    }

    public Double getUser_longitude() {
        return user_longitude;
    }

    public void setUser_longitude(Double user_longitude) {
        this.user_longitude = user_longitude;
    }

    @Enumerated(EnumType.STRING)
    Role role;

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

//    public void addNotification(UserNotification notification) {
//        notifications.add(notification);
//        notification.setUser(this);
//    }
//
//    public void removeNotification(UserNotification notification) {
//        notifications.remove(notification);
//        notification.setUser(null);
//    }



    public User() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return null;
    }

    @Override
    public String getPassword() {
        return null;
    }

    @Override
    public String getUsername() {
        return null;
    }

    @Override
    public boolean isAccountNonExpired() {
        return false;
    }

    @Override
    public boolean isAccountNonLocked() {
        return false;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return false;
    }

    @Override
    public boolean isEnabled() {
        return false;
    }
}
