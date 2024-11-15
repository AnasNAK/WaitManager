package org.NAK.WaitManager.Mapper;

import javax.annotation.processing.Generated;
import org.NAK.WaitManager.DTO.Visitor.CreateVisitorDTO;
import org.NAK.WaitManager.DTO.Visitor.ResponseVisitorDTO;
import org.NAK.WaitManager.DTO.Visitor.UpdateVisitorDTO;
import org.NAK.WaitManager.Entity.Visitor;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-11-15T16:43:59+0100",
    comments = "version: 1.6.2, compiler: javac, environment: Java 22.0.2 (Oracle Corporation)"
)
@Component
public class VisitorMapperImpl implements VisitorMapper {

    @Override
    public ResponseVisitorDTO toResponseVisitorDTO(Visitor visitor) {
        if ( visitor == null ) {
            return null;
        }

        ResponseVisitorDTO responseVisitorDTO = new ResponseVisitorDTO();

        responseVisitorDTO.setId( visitor.getId() );
        responseVisitorDTO.setFirstName( visitor.getFirstName() );
        responseVisitorDTO.setLastName( visitor.getLastName() );

        return responseVisitorDTO;
    }

    @Override
    public Visitor toVisitor(CreateVisitorDTO createVisitorDTO) {
        if ( createVisitorDTO == null ) {
            return null;
        }

        Visitor visitor = new Visitor();

        visitor.setFirstName( createVisitorDTO.getFirstName() );
        visitor.setLastName( createVisitorDTO.getLastName() );

        return visitor;
    }

    @Override
    public Visitor toVisitor(UpdateVisitorDTO updateVisitorDTO) {
        if ( updateVisitorDTO == null ) {
            return null;
        }

        Visitor visitor = new Visitor();

        visitor.setFirstName( updateVisitorDTO.getFirstName() );
        visitor.setLastName( updateVisitorDTO.getLastName() );

        return visitor;
    }
}
