// package com.example.painter.companion.service;

package com.example.painter.companion.service;

import com.example.painter.companion.dto.CanvasDTO;

import java.util.List;

public interface CanvasService {
    CanvasDTO createCanvas(CanvasDTO canvasDTO);
    CanvasDTO getCanvasById(Long id);
    List<CanvasDTO> getAllCanvases();
    CanvasDTO updateCanvas(Long id, CanvasDTO canvasDTO);
    void deleteCanvas(Long id);
}
