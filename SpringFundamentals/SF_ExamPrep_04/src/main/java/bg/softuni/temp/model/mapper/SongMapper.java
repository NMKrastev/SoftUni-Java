package bg.softuni.temp.model.mapper;

import bg.softuni.temp.model.dto.AddSongDTO;
import bg.softuni.temp.model.dto.SongDTO;
import bg.softuni.temp.model.entity.Song;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SongMapper {

    Song addSongDtoToSong(AddSongDTO addSongDTO);

    SongDTO songToSongDto(Song song);
}
