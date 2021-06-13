package com.yamanit.red.user.service;

import com.yamanit.red.user.model.User;
import com.yamanit.red.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userInMemoryRepository;

	public User addUser() {
		return userInMemoryRepository.addNewUser();
	}

	public User getUser(String uuid) {
		return userInMemoryRepository.getUser(uuid);
	}

	public User modifyUser(User user) {
		return userInMemoryRepository.save(user);
	}
}
