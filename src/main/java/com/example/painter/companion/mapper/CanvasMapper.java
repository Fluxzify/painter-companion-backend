
package com.example.painter.companion.mapper;

import com.example.painter.companion.dto.CanvasDTO;
import com.example.painter.companion.model.Canvas;
import org.mapstruct.*;
import org.mapstruct.Mapper;


@Mapper(componentModel = "spring", uses = {GridCellMapper.class})
public interface CanvasMapper {
    @Mapping(source = "user.id", target = "userId")
    CanvasDTO toDTO(Canvas canvas);

    @Mapping(source = "userId", target = "user.id")
    Canvas toEntity(CanvasDTO dto);
}