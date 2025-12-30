package sirma.SantaWorkshop.entity.dto;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import sirma.SantaWorkshop.entity.enums.Category;
import sirma.SantaWorkshop.entity.enums.Status;

import java.net.CacheRequest;
import java.sql.Statement;
import java.time.LocalDateTime;

public class GiftDto {
    private Long id;
    @NotNull
    @Size(min =  2, max = 50)
    private String name;
    private Category category;
    @NotNull
    @Size(min = 0,max = 99)
    private int targetAge;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public int getTargetAge() {
        return targetAge;
    }

    public void setTargetAge(int targetAge) {
        this.targetAge = targetAge;
    }


}
