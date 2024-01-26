package com.library.bookmanagementsystem.mapper;

import com.library.bookmanagementsystem.dto.PatronAddDTO;
import com.library.bookmanagementsystem.dto.PatronResponseDTO;
import com.library.bookmanagementsystem.dto.PatronUpdateDTO;
import com.library.bookmanagementsystem.models.Patron;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2024-01-26T22:20:43+0400",
    comments = "version: 1.5.5.Final, compiler: javac, environment: Java 17.0.10 (Amazon.com Inc.)"
)
@Component
public class PatronMapperImpl implements PatronMapper {

    @Override
    public Patron asPatron(PatronAddDTO patronAddDTO) {
        if ( patronAddDTO == null ) {
            return null;
        }

        Patron patron = new Patron();

        patron.setName( patronAddDTO.getName() );
        patron.setContactInformation( patronAddDTO.getContactInformation() );

        return patron;
    }

    @Override
    public PatronResponseDTO asPatronResponse(Patron patron) {
        if ( patron == null ) {
            return null;
        }

        PatronResponseDTO patronResponseDTO = new PatronResponseDTO();

        patronResponseDTO.setId( patron.getId() );
        patronResponseDTO.setName( patron.getName() );
        patronResponseDTO.setContactInformation( patron.getContactInformation() );

        return patronResponseDTO;
    }

    @Override
    public List<PatronResponseDTO> asPatronResponseList(List<Patron> patronList) {
        if ( patronList == null ) {
            return null;
        }

        List<PatronResponseDTO> list = new ArrayList<PatronResponseDTO>( patronList.size() );
        for ( Patron patron : patronList ) {
            list.add( asPatronResponse( patron ) );
        }

        return list;
    }

    @Override
    public Patron asUpdatePatron(Patron patron, PatronUpdateDTO patronUpdateDTO) {
        if ( patronUpdateDTO == null ) {
            return patron;
        }

        if ( patronUpdateDTO.getName() != null ) {
            patron.setName( patronUpdateDTO.getName() );
        }
        if ( patronUpdateDTO.getContactInformation() != null ) {
            patron.setContactInformation( patronUpdateDTO.getContactInformation() );
        }

        return patron;
    }
}
