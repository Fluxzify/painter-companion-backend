package com.example.painter.companion.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "grid_cell")
public class GridCell {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private int x;

    @Column(nullable = false)
    private int y;

    @Column(length = 50)
    private PowerType powerType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "canvas_id", nullable = false)
    private Canvas canvas;
}
