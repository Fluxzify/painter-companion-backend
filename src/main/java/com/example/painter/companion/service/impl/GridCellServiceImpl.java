// package com.example.painter.companion.service.impl;

package com.example.painter.companion.service.impl;

import com.example.painter.companion.dto.GridCellDTO;
import com.example.painter.companion.mapper.GridCellMapper;
import com.example.painter.companion.model.GridCell;
import com.example.painter.companion.repository.GridCellRepository;
import com.example.painter.companion.service.GridCellService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class GridCellServiceImpl implements GridCellService {

    private final GridCellRepository gridCellRepository;
    private final GridCellMapper gridCellMapper;

    public GridCellServiceImpl(GridCellRepository gridCellRepository, GridCellMapper gridCellMapper) {
        this.gridCellRepository = gridCellRepository;
        this.gridCellMapper = gridCellMapper;
    }

    @Override
    public GridCellDTO createGridCell(GridCellDTO gridCellDTO) {
        GridCell gridCell = gridCellMapper.toEntity(gridCellDTO);
        GridCell saved = gridCellRepository.save(gridCell);
        return gridCellMapper.toDTO(saved);
    }

    @Override
    public GridCellDTO getGridCellById(Long id) {
        return gridCellRepository.findById(id)
                .map(gridCellMapper::toDTO)
                .orElse(null);
    }

    @Override
    public List<GridCellDTO> getAllGridCells() {
        return gridCellRepository.findAll()
                .stream()
                .map(gridCellMapper::toDTO)
                .collect(Collectors.toList());
    }

    @Override
    public GridCellDTO updateGridCell(Long id, GridCellDTO gridCellDTO) {
        return gridCellRepository.findById(id).map(existing -> {
            existing.setX(gridCellDTO.getX());
            existing.setY(gridCellDTO.getY());
            existing.setPowerType(gridCellDTO.getPowerType());
            // canvas no se actualiza aquí para simplificar
            GridCell updated = gridCellRepository.save(existing);
            return gridCellMapper.toDTO(updated);
        }).orElse(null);
    }

    @Override
    public void deleteGridCell(Long id) {
        gridCellRepository.deleteById(id);
    }
}
