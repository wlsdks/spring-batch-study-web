package com.study.pass.service.user;

import com.study.pass.repository.user.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;
import org.mapstruct.factory.Mappers;

/**
 * dto로 변환해주는 클래스
 */
@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface UserModelMapper {

    UserModelMapper INSTANCE = Mappers.getMapper(UserModelMapper.class);

    // UserEntity를 받아서 User로 변환해준다.
    User toUser(UserEntity userEntity);

}
