// package com.example.painter.companion.repository;

package com.example.painter.companion.repository;

import com.example.painter.companion.model.GridCell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface GridCellRepository extends JpaRepository<GridCell, Long> {
}
