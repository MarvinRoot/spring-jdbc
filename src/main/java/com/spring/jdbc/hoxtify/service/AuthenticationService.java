package com.spring.jdbc.hoxtify.service;

import com.spring.jdbc.hoxtify.dao.UserDaoImpl;
import com.spring.jdbc.hoxtify.model.User;
import com.spring.jdbc.hoxtify.model.filter.UserFilter;
import com.spring.jdbc.hoxtify.utils.AESUtil;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import java.nio.charset.StandardCharsets;
import java.util.Date;

import static com.spring.jdbc.hoxtify.model.constants.ConstantsEnum.TOKEN_VALIDITY_IN_MILLISECONDS;

@Service
public class AuthenticationService {
    private static final String SECRET_KEY = "1234567891234567"; // Ideally, generate and store this securely. It must be 16 chars long
    private final UserDaoImpl userDao;
    public AuthenticationService(UserDaoImpl userDao) {
        this.userDao = userDao;
    }

    public String validateUser(User user) throws Exception {
        User foundUser = userDao.getUserList(new UserFilter(user.getUsername(), user.getPassword(), user.getEmail())).get(0);
        if (foundUser != null) {
            return createToken(user.getUsername(), user.getPassword());
        } else {
            throw new Exception("User Not Found");
        }
    }

    // Method to create a token
    public String createToken(String username, String password) throws Exception {
        // Combine the username, password, and timestamp into a single string
        String timestamp = String.valueOf(new Date().getTime());
//        String dataToEncrypt = username + ":" + password + ":" + timestamp;

        // Generate AES key from a secret key
        SecretKey key = new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8), "AES");

        String usernameEncrypt = AESUtil.encrypt(username, key);
        String passwordEncrypt = AESUtil.encrypt(password, key);
        String timestampEncrypt = AESUtil.encrypt(timestamp, key);
        // Encrypt the data
        return usernameEncrypt + ":" + passwordEncrypt + ":" + timestampEncrypt;
    }

    public boolean validateToken(String token) throws Exception {
        // Generate AES key from the same secret key
        SecretKey key = new SecretKeySpec(SECRET_KEY.getBytes(StandardCharsets.UTF_8), "AES");

        // Decrypt the token
//        String decryptedData = AESUtil.decrypt(token, key);

        // Split the data to retrieve the username, password, and timestamp
        String[] parts = token.split(":");
        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid token format");
        }

        String username = AESUtil.decrypt(parts[0], key);
        String password = AESUtil.decrypt(parts[1], key);
        User foundUser = userDao.getUserList(new UserFilter(username, password, null)).get(0);
        if (foundUser == null) {
            throw new Exception("Token invalid");
        }
        long timestamp = Long.parseLong(AESUtil.decrypt(parts[2], key));

        // Check if the token is still valid based on the timestamp
        long currentTime = new Date().getTime();
        return (currentTime - timestamp) <= TOKEN_VALIDITY_IN_MILLISECONDS;
    }
}
