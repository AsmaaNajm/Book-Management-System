package com.library.bookmanagementsystem.mapper;

import com.library.bookmanagementsystem.dto.PatronAddDTO;
import com.library.bookmanagementsystem.dto.PatronResponseDTO;
import com.library.bookmanagementsystem.dto.PatronUpdateDTO;
import com.library.bookmanagementsystem.models.Patron;
import org.mapstruct.*;

import java.util.List;
@Mapper
public interface PatronMapper {

    Patron asPatron(PatronAddDTO patronAddDTO);

    PatronResponseDTO asPatronResponse(Patron patron);

    List<PatronResponseDTO> asPatronResponseList(List<Patron> patronList);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Patron asUpdatePatron(@MappingTarget Patron patron, PatronUpdateDTO patronUpdateDTO);
}
