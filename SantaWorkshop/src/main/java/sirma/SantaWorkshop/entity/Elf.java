package sirma.SantaWorkshop.entity;

import jakarta.persistence.*;
import sirma.SantaWorkshop.entity.enums.SkillLevel;

import java.util.List;

@Entity
@Table(name = "elves")
public class Elf extends BaseEntity {
    @Column(name = "elf_name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "skill_level")
    private SkillLevel skillLevel;
    @ManyToOne
    @JoinColumn(name = "gift_id")
    private Gift assignedGift;


    public Elf(String name, SkillLevel skillLevel, Gift assignedGift) {
        this.name = name;
        this.skillLevel = skillLevel;
        this.assignedGift = assignedGift;
    }

    public Elf() {

    }

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

    public Gift getAssignedGiftId() {
        return assignedGift;
    }

    public void setAssignedGiftId(Gift assignedGiftId) {
        this.assignedGift = assignedGift;
    }
}
