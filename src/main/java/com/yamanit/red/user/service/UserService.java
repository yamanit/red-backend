package com.yamanit.red.user.service;

import com.yamanit.red.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {
	private final UserRepository userRepository;

	public String addUser() {
		return userRepository.addUser();
	}
}
