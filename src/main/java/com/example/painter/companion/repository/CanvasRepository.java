// package com.example.painter.companion.repository;

package com.example.painter.companion.repository;

import com.example.painter.companion.model.Canvas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CanvasRepository extends JpaRepository<Canvas, Long> {
}
