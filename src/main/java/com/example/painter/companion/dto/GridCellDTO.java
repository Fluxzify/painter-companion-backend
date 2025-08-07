package com.example.painter.companion.dto;

import com.example.painter.companion.model.PowerType;
import lombok.Data;

@Data
public class GridCellDTO {
    private Long id;
    private int x;
    private int y;
    private PowerType powerType;
    private Long canvasId;
}