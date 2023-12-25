package com.example.OfflinePayment.ServiceImpl;

import com.example.OfflinePayment.ExceptionHandling.UserAlreadyEnrolledException;
import com.example.OfflinePayment.Model.User;
import com.example.OfflinePayment.Repository.UserRepository;
import com.example.OfflinePayment.Services.UserServices;
import com.example.OfflinePayment.ExceptionHandling.UserNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.util.Optional;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserServices {

    @Autowired
    UserRepository userRepository;

    @Value("${jwt.secret}")
    String jwtSecret;
    @Override
    public User registerUser(Long userId, String userName, String address, Double latitude, Double longitude) throws UnsupportedEncodingException {


        User user = new User();
        user.setUserId(userId);
        user.setName(userName);
        user.setUser_secret(generateUserSecret());
        user.setUser_status(true);
        user.setUser_enrolled(false);
        user.setUser_enrollapproved(false);
        user.setUser_latitude(latitude);
        user.setUser_longitude(longitude);
        userRepository.save(user);

        return user;
    }
    @Override
    public Boolean enrollForOfflinePayment(Long userId){
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()){
            User currUser = user.get();
            if(!currUser.getUser_enrolled()){
                currUser.setUser_enrolled(true);
                userRepository.save(currUser);
                return true;
            }
            throw new UserAlreadyEnrolledException("User is already enrolled");
        }
        throw new UserNotFoundException("User not found");
    }

    @Override
    public User approveUser(Long userId){
        Optional<User> user = userRepository.findById(userId);
        if(user.isPresent()){
            User currUser = user.get();
            if(!currUser.getUser_enrollapproved()){
                currUser.setUser_enrollapproved(true);
                userRepository.save(currUser);
                return currUser;
            }
            throw new UserAlreadyEnrolledException("User is already approved");
        }
        throw new UserNotFoundException("User not found");
    }


    @Override
    public String generateUserSecret(){
        return UUID.randomUUID().toString();
    }
}
