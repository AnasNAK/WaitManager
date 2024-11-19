package org.NAK.WaitManager.Service.contract;

import org.NAK.WaitManager.DTO.Visit.CreateVisitDTO;
import org.NAK.WaitManager.DTO.Visit.ResponseVisitDTO;
import org.NAK.WaitManager.DTO.Visit.UpdateVisitDTO;
import org.NAK.WaitManager.Entity.Embeded.EmbeddedIds;

import java.util.List;

public interface VisitService {
    ResponseVisitDTO saveVisit(CreateVisitDTO createVisitDTO);
    ResponseVisitDTO updateVisit(UpdateVisitDTO updateVisitDTO);
    ResponseVisitDTO findVisitById(EmbeddedIds embeddedIds);
    void deleteVisit(EmbeddedIds embeddedIds);
    List<ResponseVisitDTO> findAllVisits();
    List<ResponseVisitDTO> getScheduledVisits(long waitingListId);
}

