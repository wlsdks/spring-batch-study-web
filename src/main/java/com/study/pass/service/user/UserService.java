package com.study.pass.service.user;

import com.study.pass.repository.user.UserEntity;
import com.study.pass.repository.user.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;

    public User getUser(final String userId) {
        // userId를 조건으로 사용자 정보를 조회한다. 프로필에 노출할 사용자의 이름이 필요하다.
        UserEntity userEntity = userRepository.findByUserId(userId);
        // userEntity를 User로 변환받는다. dto변환같음
        return UserModelMapper.INSTANCE.toUser(userEntity);
    }

}
