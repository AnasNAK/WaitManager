package org.NAK.WaitManager.Mapper;

import org.NAK.WaitManager.DTO.Visitor.CreateVisitorDTO;
import org.NAK.WaitManager.DTO.Visitor.ResponseVisitorDTO;
import org.NAK.WaitManager.DTO.Visitor.UpdateVisitorDTO;
import org.NAK.WaitManager.Entity.Visitor;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface VisitorMapper {

    ResponseVisitorDTO toResponseVisitorDTO(Visitor visitor);

    Visitor toVisitor(CreateVisitorDTO createVisitorDTO);

    Visitor toVisitor(UpdateVisitorDTO updateVisitorDTO);
}
