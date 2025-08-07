// package com.example.painter.companion.controller;

package com.example.painter.companion.controller;

import com.example.painter.companion.dto.GridCellDTO;
import com.example.painter.companion.service.GridCellService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/gridcells")
public class GridCellController {

    private final GridCellService gridCellService;

    public GridCellController(GridCellService gridCellService) {
        this.gridCellService = gridCellService;
    }

    @PostMapping
    public ResponseEntity<GridCellDTO> createGridCell(@RequestBody GridCellDTO gridCellDTO) {
        return ResponseEntity.ok(gridCellService.createGridCell(gridCellDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<GridCellDTO> getGridCellById(@PathVariable Long id) {
        GridCellDTO dto = gridCellService.getGridCellById(id);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<GridCellDTO>> getAllGridCells() {
        return ResponseEntity.ok(gridCellService.getAllGridCells());
    }

    @PutMapping("/{id}")
    public ResponseEntity<GridCellDTO> updateGridCell(@PathVariable Long id, @RequestBody GridCellDTO gridCellDTO) {
        GridCellDTO updated = gridCellService.updateGridCell(id, gridCellDTO);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGridCell(@PathVariable Long id) {
        gridCellService.deleteGridCell(id);
        return ResponseEntity.noContent().build();
    }
}
