package kg.soft.jumushkg.repository;


import kg.soft.jumushkg.domain.entity.user.JobSeeker;
import kg.soft.jumushkg.domain.entity.userInfo.Education;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface JobSeekerRepository extends JpaRepository<JobSeeker, Long> {
    List<JobSeeker> findAllByUsername(String username);

    @Query("SELECT DISTINCT js FROM JobSeeker js " +
            "LEFT JOIN FETCH js.professions p " +
            "LEFT JOIN js.educationJobs e " +
            "WHERE (:position = '' or :position IS NULL OR p.position.name = :position) " +
            "AND (:education IS NULL OR e.education = :education) " +
            "AND (:country = '' or :country IS NULL OR js.country = :country) " +
            "AND (:city = '' or :city IS NULL OR js.city = :city) " +
            "AND (:experience = '' or :experience IS NULL OR js.experienceJ.name = :experience)")
    List<JobSeeker> filterJobSeekers(
            @Param("position") String position,
            @Param("education") Education education,
            @Param("country") String country,
            @Param("city") String city,
            @Param("experience") String experience
    );


    @Query("SELECT js FROM JobSeeker js " +
            "WHERE (:firstname IS NULL OR js.firstname = :firstname) " +
            "AND (:lastname IS NULL OR js.lastname = :lastname) " )
    List<JobSeeker> searchJobSeekers(
            String firstname,
            String lastname

    );
}
