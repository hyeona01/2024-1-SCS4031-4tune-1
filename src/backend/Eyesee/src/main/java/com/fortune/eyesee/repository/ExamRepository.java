package com.fortune.eyesee.repository;

import com.fortune.eyesee.entity.Exam;
import com.fortune.eyesee.enums.ExamStatus;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;
import java.util.Optional;

@Repository
public interface ExamRepository extends JpaRepository<Exam, Integer> {

    // ExamId와 AdminId로 Exam 데이터 조회
    boolean existsByExamIdAndAdmin_AdminId(Integer examId, Integer adminId);

    // 특정 상태에 해당하는 Exam 리스트 조회
    List<Exam> findByAdmin_AdminIdAndExamStatus(Integer adminId, ExamStatus examStatus);

    // 랜덤 코드와 adminId로 Exam 조회
    Exam findByExamRandomCode(String examRandomCode);


    // adminId 없이 상태로만 Exam 조회
    List<Exam> findByExamStatus(ExamStatus examStatus);

    // 특정 sessionId와 adminId를 기준으로 Exam 데이터 조회
    Optional<Exam> findBySession_SessionIdAndAdmin_AdminId(Integer sessionId, Integer adminId);

    @Query("""
    SELECT e 
    FROM Exam e 
    WHERE 
        e.examDate >= :currentDate OR 
        (e.examDate = :currentDate AND e.examStartTime >= :currentTime)
    """)
    List<Exam> findActiveExams(@Param("currentDate") LocalDate currentDate, @Param("currentTime") LocalTime currentTime);

}