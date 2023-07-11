package softuni.exam.service.impl;

import jakarta.xml.bind.JAXBContext;
import jakarta.xml.bind.JAXBException;
import jakarta.xml.bind.Unmarshaller;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import softuni.exam.models.dtos.ticket.TicketImportDTO;
import softuni.exam.models.dtos.ticket.TicketImportWrapperDTO;
import softuni.exam.models.entities.Passenger;
import softuni.exam.models.entities.Plane;
import softuni.exam.models.entities.Ticket;
import softuni.exam.models.entities.Town;
import softuni.exam.repository.PassengerRepository;
import softuni.exam.repository.PlaneRepository;
import softuni.exam.repository.TicketRepository;
import softuni.exam.repository.TownRepository;
import softuni.exam.service.TicketService;
import softuni.exam.util.FileUtil;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

import static softuni.exam.constant.Message.INVALID_IMPORT;
import static softuni.exam.constant.Message.SUCCESSFUL_IMPORT;
import static softuni.exam.constant.Paths.TICKETS_FILE_PATH;

@Service
public class TicketServiceImpl implements TicketService {

    private final StringBuilder sb = new StringBuilder();
    private final ModelMapper mapper;
    private final FileUtil fileUtil;
    private final TicketRepository ticketRepository;
    private final TownRepository townRepository;
    private final PassengerRepository passengerRepository;
    private final PlaneRepository planeRepository;

    public TicketServiceImpl(ModelMapper mapper, FileUtil fileUtil, TicketRepository ticketRepository,
                             TownRepository townRepository, PassengerRepository passengerRepository,
                             PlaneRepository planeRepository) {
        this.mapper = mapper;
        this.fileUtil = fileUtil;
        this.ticketRepository = ticketRepository;
        this.townRepository = townRepository;
        this.passengerRepository = passengerRepository;
        this.planeRepository = planeRepository;
    }

    @Override
    public boolean areImported() {
        return this.ticketRepository.count() > 0;
    }

    @Override
    public String readTicketsFileContent() throws IOException {
        return this.fileUtil.readFile(TICKETS_FILE_PATH);
    }

    @Override
    public String importTickets() throws FileNotFoundException, JAXBException {

        final FileReader reader = new FileReader(TICKETS_FILE_PATH.toFile());

        final JAXBContext context = JAXBContext.newInstance(TicketImportWrapperDTO.class);

        final Unmarshaller unmarshaller = context.createUnmarshaller();

        final TicketImportWrapperDTO ticketsImportWrapperDTO = (TicketImportWrapperDTO) unmarshaller.unmarshal(reader);

        final List<TicketImportDTO> ticketsDTO = ticketsImportWrapperDTO.getTickets();

        ticketsDTO
                .stream()
                .map(ticketDTO -> {

                    final Ticket ticket = this.mapper.map(ticketDTO, Ticket.class);

                    final Town fromTown = this.townRepository.findByName(ticketDTO.getFromTown().getName());
                    final Town toTown = this.townRepository.findByName(ticketDTO.getToTown().getName());
                    final Passenger passenger = this.passengerRepository.findByEmail(ticketDTO.getPassenger().getEmail());
                    final Plane plane = this.planeRepository.findByRegisterNumber(ticketDTO.getPlane().getRegisterNumber());

                    ticket.setFromTown(fromTown);
                    ticket.setToTown(toTown);
                    ticket.setPassenger(passenger);
                    ticket.setPlane(plane);

                    return ticket;

                })
                .collect(Collectors.toList())
                .forEach(ticket -> {

                    try {

                        this.ticketRepository.saveAndFlush(ticket);
                        this.sb.append(String.format(SUCCESSFUL_IMPORT, ticket.getClass().getSimpleName(),
                                        ticket.getFromTown().getName(), ticket.getToTown().getName()))
                                .append(System.lineSeparator());

                    } catch (Exception e) {

                        this.sb.append(String.format(INVALID_IMPORT, ticket.getClass().getSimpleName()))
                                .append(System.lineSeparator());
                    }
                });

        return this.sb.toString().trim();
    }
}
