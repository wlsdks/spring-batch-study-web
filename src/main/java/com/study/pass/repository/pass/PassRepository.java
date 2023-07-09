package com.study.pass.repository.pass;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PassRepository extends JpaRepository<PassEntity, Integer> {
    @Query(value = "select p from PassEntity p " +
                        "join fetch p.packageEntity " +
                        "where p.userId = :userId " +
                        "order by p.endedAt desc nulls first ") // 종료 일시가 null인 값들이 처음으로 가도록 한다.
    List<PassEntity> findByUserId(String userId);

}