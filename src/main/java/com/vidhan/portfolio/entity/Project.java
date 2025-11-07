package com.vidhan.portfolio.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Entity
@Table(name = "projects")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Project {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotBlank(message = "Project name is required")
    @Column(nullable = false)
    private String name;
    
    @NotBlank(message = "Description is required")
    @Column(columnDefinition = "TEXT")
    private String description;
    
    @Column(name = "tech_stack")
    private String techStack;
    
    @Column(name = "start_date")
    private LocalDate startDate;
    
    @Column(name = "end_date")
    private LocalDate endDate;
    
    @Column(name = "image_url")
    private String imageUrl;
    
    @Column(name = "github_url")
    private String githubUrl;
    
    @Column(name = "live_url")
    private String liveUrl;
    
    @Column(columnDefinition = "TEXT")
    private String highlights;
    
    @Column(name = "display_order")
    private Integer displayOrder;
    
    @Column(name = "is_featured")
    private Boolean isFeatured = false;
}