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
            "LEFT JOIN js.profession p " +
            "LEFT JOIN p.position pos " +
            "LEFT JOIN js.education e " +
            "WHERE (:position IS NULL OR :position = '' OR pos.name = :position) " +
            "AND (:education IS NULL OR e = :education) " +
            "AND (:country IS NULL OR :country = '' OR js.country = :country) " +
            "AND (:city IS NULL OR :city = '' OR js.city = :city) " +
            "AND (:experience IS NULL OR :experience = '' OR js.about LIKE %:experience%)")
    List<JobSeeker> filterJobSeekers(
            @Param("position") String position,
            @Param("education") Education education,
            @Param("country") String country,
            @Param("city") String city,
            @Param("experience") String experience
    );

    @Query("SELECT js FROM JobSeeker js " +
            "WHERE (:firstname IS NULL OR js.username = :username)")
    List<JobSeeker> searchJobSeekers(
            @Param("username") String username
    );


}
