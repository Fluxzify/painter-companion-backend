// package com.example.painter.companion.controller;

package com.example.painter.companion.controller;

import com.example.painter.companion.dto.CanvasDTO;
import com.example.painter.companion.service.CanvasService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/canvases")
public class CanvasController {

    private final CanvasService canvasService;

    public CanvasController(CanvasService canvasService) {
        this.canvasService = canvasService;
    }

    @PostMapping
    public ResponseEntity<CanvasDTO> createCanvas(@RequestBody CanvasDTO canvasDTO) {
        return ResponseEntity.ok(canvasService.createCanvas(canvasDTO));
    }

    @GetMapping("/{id}")
    public ResponseEntity<CanvasDTO> getCanvasById(@PathVariable Long id) {
        CanvasDTO dto = canvasService.getCanvasById(id);
        if (dto == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<CanvasDTO>> getAllCanvases() {
        return ResponseEntity.ok(canvasService.getAllCanvases());
    }

    @PutMapping("/{id}")
    public ResponseEntity<CanvasDTO> updateCanvas(@PathVariable Long id, @RequestBody CanvasDTO canvasDTO) {
        CanvasDTO updated = canvasService.updateCanvas(id, canvasDTO);
        if (updated == null) return ResponseEntity.notFound().build();
        return ResponseEntity.ok(updated);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCanvas(@PathVariable Long id) {
        canvasService.deleteCanvas(id);
        return ResponseEntity.noContent().build();
    }
}
