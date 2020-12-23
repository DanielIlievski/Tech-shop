package mk.finki.ukim.mk.lab.repository;

import mk.finki.ukim.mk.lab.model.Balloon;
import mk.finki.ukim.mk.lab.model.enumerations.BalloonStatus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BalloonRepository extends JpaRepository<Balloon, Long> {

    List<Balloon> findAllByStatus(BalloonStatus status);

    @Query("select b from Balloon b where b.name like :text or b.description like :text")
    List<Balloon> findAllByNameLikeOrDescriptionLike(@Param("text") String text);

}
