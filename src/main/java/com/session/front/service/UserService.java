package com.session.front.service;

import com.session.front.domain.*;
import com.session.front.repository.UserRepository;
import jakarta.persistence.EntityExistsException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserService {

    private final UserRepository userRepository;

    public void createUser(CreateUserReqDto dto){
        if (dto.getUserId() == null || dto.getPassword() == null){
            throw new RuntimeException("입력되지 않은 필드가 존재합니다.");
        }
        User selectedUser = userRepository.findByUserId(dto.getUserId()).orElse(null);
        if (selectedUser != null){
            throw new EntityExistsException("이미 존재하는 아이디입니다.");
        }
        User newUser = new User(dto.getUserId(), dto.getPassword(), dto.getEmail());

        userRepository.save(newUser);
    }

    public Long loginUSer(LoginUserReqDto dto){

        // 아이디나 비밀번호가 비어있는지 확인
        if (dto.getUserId() == null || dto.getUserId().isEmpty() ||
                dto.getPassword() == null || dto.getPassword().isEmpty()) {
            throw new RuntimeException("필수 필드를 모두 입력하세요.");
        }

        User selectedUser = userRepository.findByUserIdAndPassword(dto.getUserId(), dto.getPassword())
                .orElseThrow(() -> new RuntimeException("아이디 또는 비밀번호가 틀렸습니다."));
        return selectedUser.getId();
    }

    public void changeUserPassword(UpdateUserPasswordReqDto dto){
        User selectedUser = userRepository.findById(dto.getId())
                .orElseThrow(() -> new RuntimeException("잘못된 요청입니다."));
        selectedUser.setPassword(dto.getPassword());
        userRepository.save(selectedUser);
    }

    public void deleteUser(DeleteUserReqDto dto){
        userRepository.deleteById(dto.getId());
    }
}
