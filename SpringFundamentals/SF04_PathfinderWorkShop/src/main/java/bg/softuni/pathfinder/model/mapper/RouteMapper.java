package bg.softuni.pathfinder.model.mapper;

import bg.softuni.pathfinder.model.dto.routeDTO.AllRoutesDTO;
import bg.softuni.pathfinder.model.dto.routeDTO.RouteDetailDTO;
import bg.softuni.pathfinder.model.entity.Route;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface RouteMapper {

    List<AllRoutesDTO> routeToRouteDTO(List<Route> routes);

    RouteDetailDTO routeToRouteDetailDTO(Route route);
}
