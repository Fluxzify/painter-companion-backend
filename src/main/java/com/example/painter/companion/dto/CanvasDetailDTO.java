package com.example.painter.companion.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Data
public class CanvasDetailDTO extends CanvasDTO {
    private List<GridCellDTO> gridCells;
}