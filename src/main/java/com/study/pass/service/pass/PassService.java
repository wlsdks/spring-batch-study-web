package com.study.pass.service.pass;

import com.study.pass.repository.pass.PassEntity;
import com.study.pass.repository.pass.PassRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class PassService {

    private final PassRepository passRepository;

    public List<Pass> getPasses(final String userId) {
        // userId를 조건으로 pass를 조회한다. 이때 packageSeq에 맞는 package정보도 필요하다.
        final List<PassEntity> passEntities = passRepository.findByUserId(userId);
        return PassModelMapper.INSTANCE.map(passEntities);
    }

}
