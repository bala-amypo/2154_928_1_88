package com.example.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(
    name = "apartment_units",
    uniqueConstraints = @UniqueConstraint(columnNames = "unit_number")
)
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ApartmentUnit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Unit number is required")
    @Column(name = "unit_number", nullable = false, unique = true)
    private String unitNumber;

    @Min(value = 0, message = "Floor must be >= 0")
    private Integer floor;

    @OneToOne
    @JoinColumn(name = "owner_id")
    private User owner;
}
