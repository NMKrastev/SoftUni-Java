package bg.softuni.dictionaryApp.model.mapper;

import bg.softuni.dictionaryApp.model.dto.AddWordDTO;
import bg.softuni.dictionaryApp.model.dto.WordDTO;
import bg.softuni.dictionaryApp.model.entity.Word;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface WordMapper {

    Word addWordDtoToWord(AddWordDTO addWordDTO);

    WordDTO wordToWordDto(Word word);
}
