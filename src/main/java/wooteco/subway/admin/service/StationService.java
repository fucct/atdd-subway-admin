package wooteco.subway.admin.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import wooteco.subway.admin.domain.Station;
import wooteco.subway.admin.dto.StationCreateRequest;
import wooteco.subway.admin.dto.StationResponse;
import wooteco.subway.admin.repository.StationRepository;

@Service
public class StationService {

    private final StationRepository stationRepository;

    public StationService(StationRepository stationRepository) {
        this.stationRepository = stationRepository;
    }

    public StationResponse save(StationCreateRequest request) {
        Station station = request.toStation();
        Station persistStation = stationRepository.save(station);

        return StationResponse.of(persistStation);
    }

    public List<StationResponse> findAll() {
        List<Station> stations = stationRepository.findAll();

        return stations.stream()
            .map(StationResponse::of)
            .collect(Collectors.toList());
    }

    public void deleteById(Long id) {
        stationRepository.deleteById(id);
    }

    public Long findIdByName(String stationName) {
        return stationRepository.findIdByName(stationName);
    }
}