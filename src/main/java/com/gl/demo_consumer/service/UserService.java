package com.gl.demo_consumer.service;

import com.gl.demo_consumer.entity.User;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class UserService {


    private static final String baseURL = "http://localhost:8087/user/";
    private static RestTemplate restTemplate = new RestTemplate();

    public User saveUser(User user) {
        return restTemplate.postForObject(baseURL, user, User.class);

    }

    public User getUserById(Long id) {
        User user = restTemplate.getForObject(baseURL + id, User.class);
        return user;
    }

    public void deleteUser(Long id) {
        restTemplate.delete(baseURL + id);
    }

    public void updateUser(User user, Long id) {
        restTemplate.put(baseURL + id, user, User.class);
    }

}
