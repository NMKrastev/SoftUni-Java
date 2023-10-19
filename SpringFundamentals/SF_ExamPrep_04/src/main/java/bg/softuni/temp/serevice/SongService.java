package bg.softuni.temp.serevice;

import bg.softuni.temp.model.dto.AddSongDTO;
import bg.softuni.temp.model.dto.SongDTO;
import bg.softuni.temp.model.entity.Song;
import bg.softuni.temp.model.entity.Style;
import bg.softuni.temp.model.mapper.SongMapper;
import bg.softuni.temp.repository.SongRepository;
import bg.softuni.temp.user.CurrentUser;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongService {

    private final SongRepository songRepository;
    private final StyleService styleService;
    private final SongMapper songMapper;
    private final CurrentUser currentUser;

    public SongService(SongRepository songRepository, StyleService styleService,
                       SongMapper songMapper, CurrentUser currentUser) {

        this.songRepository = songRepository;
        this.styleService = styleService;
        this.songMapper = songMapper;
        this.currentUser = currentUser;
    }

    public boolean createSong(AddSongDTO addSongDTO) {

        final Song song = this.songMapper.addSongDtoToSong(addSongDTO);

        final Style style = this.styleService.findStyle(addSongDTO.getStyle());

        song.setStyle(style);

        final Song saved = this.songRepository.save(song);

        final Optional<Song> songById = this.songRepository.findById(saved.getId());

        return songById.isPresent();
    }

    public List<SongDTO> findAllSongs(String style) {

        return this.songRepository.findAll()
                .stream()
                .map(this.songMapper::songToSongDto)
                .filter(s -> s.getStyle().getName().equals(style))
                .toList();
    }

    public Song findSongById(Long songId) {

        return this.songRepository.findById(songId).get();
    }
}
