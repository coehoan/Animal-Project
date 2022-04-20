package site.metacoding.animalprojectfrontend.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.animalprojectfrontend.domain.user.User;
import site.metacoding.animalprojectfrontend.domain.user.UserRepository;
import site.metacoding.animalprojectfrontend.web.api.dto.user.JoinDto;
import site.metacoding.animalprojectfrontend.web.api.dto.user.LoginDto;

@RequiredArgsConstructor
@Service
public class UserService {
    private final UserRepository userRepository;

    @Transactional
    public void 회원가입(JoinDto joinDto) {
        userRepository.save(joinDto.toEntity());
    }

    public User 로그인(LoginDto loginDto) {
        User userEntity = userRepository.aLogin(loginDto.getUsername(), loginDto.getPassword());
        return userEntity;
    }

}
