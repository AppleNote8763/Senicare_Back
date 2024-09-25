package com.korit.senicare.entity;

import com.korit.senicare.dto.request.tool.PatchToolRequestDto;
import com.korit.senicare.dto.request.tool.PostToolRequestDto;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "tools")
@Table(name = "tools")
public class ToolEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer toolNumber;
    private String name;
    private String purpose;
    private Integer count;

    public ToolEntity(PostToolRequestDto dto) {
        this.name = dto.getName();
        this.purpose = dto.getPurpose();
        this.count = dto.getCount();
    }

    public void patch(PatchToolRequestDto dto) {
        this.name = dto.getName();
        this.purpose = dto.getPurpose();
        this.count = dto.getCount();
    }

    public void decreaseCount(Integer usedCount) {
        this.count -= usedCount;
    }

}
