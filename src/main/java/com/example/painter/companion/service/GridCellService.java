// package com.example.painter.companion.service;

package com.example.painter.companion.service;

import com.example.painter.companion.dto.GridCellDTO;

import java.util.List;

public interface GridCellService {
    GridCellDTO createGridCell(GridCellDTO gridCellDTO);
    GridCellDTO getGridCellById(Long id);
    List<GridCellDTO> getAllGridCells();
    GridCellDTO updateGridCell(Long id, GridCellDTO gridCellDTO);
    void deleteGridCell(Long id);
}
