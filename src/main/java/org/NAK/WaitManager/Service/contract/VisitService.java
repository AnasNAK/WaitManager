package org.NAK.WaitManager.Service.contract;

import org.NAK.WaitManager.DTO.Visit.CreateVisitDTO;
import org.NAK.WaitManager.DTO.Visit.ResponseVisitDTO;
import org.NAK.WaitManager.DTO.Visit.UpdateVisitDTO;
import org.NAK.WaitManager.Entity.Embeded.EmbeddedIds;
import org.NAK.WaitManager.Enum.Status;

import java.util.List;
import java.util.Map;

public interface VisitService {
    ResponseVisitDTO saveVisit(CreateVisitDTO createVisitDTO);
    ResponseVisitDTO updateVisit(UpdateVisitDTO updateVisitDTO);
    ResponseVisitDTO findVisitById(EmbeddedIds embeddedIds);
    void deleteVisit(EmbeddedIds embeddedIds);
    List<ResponseVisitDTO> findAllVisits();

    List<ResponseVisitDTO> getScheduledVisits(long waitingListId);

    double calculateAverageWaitingTime(Long waitingListId);

    long calculateVisitorRotation(Long waitingListId);

    double calculateSatisfactionRateForWaitingList(Long waitingListId);

    Map<Status, Long> calculateVisitorStatusDistribution(Long waitingListId);

    Map<String ,Double> generatePerformanceIndicators(Long waitingListId);

}

