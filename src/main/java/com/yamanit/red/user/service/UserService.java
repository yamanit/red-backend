package com.yamanit.red.user.service;

import com.yamanit.red.user.model.User;
import com.yamanit.red.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;

	public User addUser() {
		return userRepository.addNewUser();
	}

	public User getUser(String uuid) {
		return userRepository.getUser(uuid);
	}

	public User modifyUser(User user) {
		return userRepository.save(user);
	}
}
