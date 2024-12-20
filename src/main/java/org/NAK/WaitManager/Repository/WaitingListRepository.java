package org.NAK.WaitManager.Repository;

import org.NAK.WaitManager.Entity.WaitingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface WaitingListRepository extends JpaRepository<WaitingList, Long> {
}
