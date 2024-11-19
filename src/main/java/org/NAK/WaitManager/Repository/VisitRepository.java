package org.NAK.WaitManager.Repository;

import org.NAK.WaitManager.Entity.Embeded.EmbeddedIds;
import org.NAK.WaitManager.Entity.Visit;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface VisitRepository extends JpaRepository<Visit, EmbeddedIds> {
    Optional<Visit> findByVisitorIdAndWaitingListId(Long visitorId, Long waitingListId);
    List<Visit> findByWaitingListId(long waitingListId);
    long countByWaitingListId(Long waitingListId);

    List<Visit> findByWaitingListId(Long waitingListId);
}

