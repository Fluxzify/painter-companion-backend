
package com.example.painter.companion.dto;

import com.example.painter.companion.model.PowerType;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
public class CanvasDTO {
    private Long id;
    private String name;
    private String description;
    private int gridSize;
    private Long userId;
    private List<GridCellDTO> gridCells;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
}