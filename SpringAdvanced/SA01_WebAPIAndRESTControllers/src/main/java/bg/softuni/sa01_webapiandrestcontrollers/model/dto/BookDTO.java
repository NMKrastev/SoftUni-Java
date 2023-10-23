package bg.softuni.sa01_webapiandrestcontrollers.model.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class BookDTO {

    private Long id;

    private String title;

    private String isbn;

    private AuthorDTO author;
}
