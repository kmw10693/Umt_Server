package com.umt.umt_server.infra;

import com.umt.umt_server.domain.Treasure;
import com.umt.umt_server.domain.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TreasureRepository extends JpaRepository<Treasure, Long> {

    @Query(value = "select * from treasure where ST_Distance_Sphere(POINT(:longitude, :latitude), POINT(longitude, latitude)) <= 2000", nativeQuery = true)
    List<Treasure> getTreasures(@Param("longitude") double longitude, @Param("latitude") double latitude);

    List<Treasure> findByUser(User user);

    @Query("select count(t.id) from Treasure t where t.user = :user")
    Long findCountByUser(User user);

}
