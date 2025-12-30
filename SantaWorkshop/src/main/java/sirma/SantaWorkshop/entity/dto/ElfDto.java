package sirma.SantaWorkshop.entity.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import sirma.SantaWorkshop.entity.enums.SkillLevel;

import java.util.List;

public class ElfDto {
    private Long id;

    @NotNull
    @Size(min = 2, max = 40)
    private String name;
    private SkillLevel skillLevel;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public SkillLevel getSkillLevel() {
        return skillLevel;
    }

    public void setSkillLevel(SkillLevel skillLevel) {
        this.skillLevel = skillLevel;
    }
}
