package com.example.OfflinePayment.Services;

import com.example.OfflinePayment.Model.User;

import java.io.UnsupportedEncodingException;

public interface UserServices {

    User registerUser(Long userId, String userName, String address, Double latitude, Double longitude) throws UnsupportedEncodingException;

   // Boolean enrollForOfflinePayment(int userId);

//    GeoLocation getGeoLocation(String address) throws UnsupportedEncodingException;

    Boolean enrollForOfflinePayment(Long userId);

    User approveUser(Long userId);

    String generateUserSecret();
   // public User approveUser(int user_id);
}
