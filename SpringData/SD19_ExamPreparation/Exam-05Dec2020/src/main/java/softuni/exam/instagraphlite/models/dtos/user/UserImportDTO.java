package softuni.exam.instagraphlite.models.dtos.user;

import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserImportDTO {

    private String username;

    private String password;

    @SerializedName("profilePicture")
    private String path;
}
