package hiberspring.domain.dtos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class EmployeeDataExportDTO {

    private String fullName;

    private String position;

    private EmployeeCardImportDTO card;

    @Override
    public String toString() {
        return String.format("Name: %s\nPosition: %s\nCard Number: %s\n-------------------------",
                this.fullName, this.position, this.card.getNumber());
    }
}
