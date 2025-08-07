package com.example.painter.companion.mapper;

import com.example.painter.companion.dto.GridCellDTO;
import com.example.painter.companion.model.GridCell;
import org.mapstruct.*;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface GridCellMapper {

    @Mapping(source = "canvas.id", target = "canvasId")
    GridCellDTO toDTO(GridCell gridCell);

    @Mapping(source = "canvasId", target = "canvas.id")
    GridCell toEntity(GridCellDTO dto);
}
