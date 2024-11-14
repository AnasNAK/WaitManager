package org.NAK.WaitManager.Service.contract;

import org.NAK.WaitManager.DTO.Visitor.CreateVisitorDTO;
import org.NAK.WaitManager.DTO.Visitor.ResponseVisitorDTO;
import org.NAK.WaitManager.DTO.Visitor.UpdateVisitorDTO;

import java.util.List;

public interface VisitorService {
    ResponseVisitorDTO saveVisitor(CreateVisitorDTO createVisitorDTO);
    ResponseVisitorDTO updateVisitor(UpdateVisitorDTO updateVisitorDTO);
    ResponseVisitorDTO getVisitor(Long id);
    void deleteVisitor(Long id);
    List<ResponseVisitorDTO> getVisitors();

}
