// package com.example.painter.companion.service.impl;

package com.example.painter.companion.service.impl;

import com.example.painter.companion.dto.CanvasDTO;
import com.example.painter.companion.mapper.CanvasMapper;
import com.example.painter.companion.model.Canvas;
import com.example.painter.companion.repository.CanvasRepository;
import com.example.painter.companion.service.CanvasService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CanvasServiceImpl implements CanvasService {

    private final CanvasRepository canvasRepository;
    private final CanvasMapper canvasMapper;

    public CanvasServiceImpl(CanvasRepository canvasRepository, CanvasMapper canvasMapper) {
        this.canvasRepository = canvasRepository;
        this.canvasMapper = canvasMapper;
    }

    @Override
    public CanvasDTO createCanvas(CanvasDTO canvasDTO) {
        Canvas canvas = canvasMapper.toEntity(canvasDTO);
        Canvas saved = canvasRepository.save(canvas);
        return canvasMapper.toDTO(saved);
    }

    @Override
    public CanvasDTO getCanvasById(Long id) {
        return canvasRepository.findById(id)
                .map(canvasMapper::toDTO)
                .orElse(null);
    }

    @Override
    public List<CanvasDTO> getAllCanvases() {
        return canvasRepository.findAll()
                .stream()
                .map(canvasMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CanvasDTO updateCanvas(Long id, CanvasDTO canvasDTO) {
        return canvasRepository.findById(id).map(existing -> {
            existing.setName(canvasDTO.getName());
            existing.setDescription(canvasDTO.getDescription());
            existing.setGridSize(canvasDTO.getGridSize());
            // user no se actualiza aquí para simplificar
            Canvas updated = canvasRepository.save(existing);
            return canvasMapper.toDTO(updated);
        }).orElse(null);
    }

    @Override
    public void deleteCanvas(Long id) {
        canvasRepository.deleteById(id);
    }
}
