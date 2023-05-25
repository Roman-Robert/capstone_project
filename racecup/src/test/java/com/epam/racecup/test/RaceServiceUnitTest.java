package com.epam.racecup.test;

import com.epam.racecup.mapper.RaceMapper;
import com.epam.racecup.model.RaceType;
import com.epam.racecup.model.dto.RaceDTO;
import com.epam.racecup.model.entity.RaceEntity;
import com.epam.racecup.repository.RaceRepository;
import com.epam.racecup.service.RaceService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.sql.Date;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import static junit.framework.TestCase.assertEquals;
import static junit.framework.TestCase.assertTrue;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class RaceServiceUnitTest {
    @Mock
    private RaceRepository raceRepository;

    @Mock
    private RaceMapper raceMapper;

    @InjectMocks
    private RaceService raceService;

    @Test
    public void saveRaceTest() {
        RaceDTO raceDTO = createRaceDTO();
        RaceEntity raceEntity = createRaceEntity();

        when(raceMapper.dtoToEntity(raceDTO)).thenReturn(raceEntity);
        when(raceRepository.save(raceEntity)).thenReturn(raceEntity);

        raceService.saveRace(raceDTO);

        verify(raceRepository, times(1)).save(raceEntity);
    }

    @Test
    public void updateRaceTest() {
        long id = 1;
        RaceDTO raceDTO = createRaceDTO();
        RaceDTO oldRaceDTO = createRaceDTO();

        RaceEntity oldRaceEntity = createRaceEntity();

        when(raceService.getRaceById(id)).thenReturn(oldRaceDTO);
        when(raceMapper.dtoToEntity(raceDTO)).thenReturn(oldRaceEntity);
        when(raceRepository.save(oldRaceEntity)).thenReturn(oldRaceEntity);

        raceService.updateRace(raceDTO, id);

        verify(raceRepository, times(1)).save(oldRaceEntity);
        assertEquals(oldRaceDTO.getOrganizerId(), raceDTO.getOrganizerId());
        assertEquals(oldRaceDTO.getIsActual(), raceDTO.getIsActual());
    }

    @Test
    public void getAllRacesTest() {
        Pageable pageable = PageRequest.of(0, 10);
        Page<RaceEntity> raceEntities = new PageImpl<>(Arrays.asList(createRaceEntity(), createRaceEntity()));
        when(raceRepository.findAll(pageable)).thenReturn(raceEntities);

        Page<RaceDTO> result = raceService.getAllRaces(pageable);

        assertEquals(raceEntities.getTotalElements(), result.getTotalElements());
        assertEquals(raceEntities.getContent().size(), result.getContent().size());
    }

    @Test
    public void getRaceByIdTest() {
        long raceId = 1;
        RaceEntity raceEntity = createRaceEntity();
        RaceDTO raceDTO = createRaceDTO();

        when(raceRepository.getOne(raceId)).thenReturn(raceEntity);
        when(raceMapper.entityToDto(raceEntity)).thenReturn(raceDTO);

        RaceDTO result = raceService.getRaceById(raceId);

        assertEquals(raceDTO, result);
    }

    @Test
    public void findByDateAfterTest() {
        Date date = Date.valueOf(LocalDate.now());
        Pageable pageable = PageRequest.of(0, 10);
        Page<RaceEntity> raceEntities = new PageImpl<>(Arrays.asList(createRaceEntity(), createRaceEntity()));
        when(raceRepository.findByDateAfter(date, pageable)).thenReturn(raceEntities);

        Page<RaceDTO> result = raceService.findByDateAfter(date, pageable);

        assertEquals(raceEntities.getTotalElements(), result.getTotalElements());
        assertEquals(raceEntities.getContent().size(), result.getContent().size());
    }

    @Test
    public void findByDateAfterTodayTest() {
        Date today = Date.valueOf(LocalDate.now());
        List<RaceEntity> raceEntities = Arrays.asList(createRaceEntity(), createRaceEntity());
        when(raceRepository.findByDateAfter(today)).thenReturn(raceEntities);

        List<RaceDTO> result = raceService.findByDateAfter();

        assertEquals(raceEntities.size(), result.size());
    }

    @Test
    public void findByDateBeforeTodayTest() {
        Date today = Date.valueOf(LocalDate.now());
        List<RaceEntity> raceEntities = Arrays.asList(createRaceEntity(), createRaceEntity());
        when(raceRepository.findByDateBefore(today)).thenReturn(raceEntities);

        List<RaceDTO> result = raceService.findByDateBefore();

        assertEquals(raceEntities.size(), result.size());
    }

    @Test
    public void getRaceByNameTest() {
        String name = "RaceName";
        RaceEntity raceEntity = createRaceEntity();

        when(raceRepository.findByName(name)).thenReturn(raceEntity);

        Optional<RaceEntity> result = raceService.getRaceByName(name);

        assertTrue(result.isPresent());
        assertEquals(raceEntity, result.get());
    }

    private RaceDTO createRaceDTO() {
        return RaceDTO
                .builder()
                .id(1)
                .raceType(RaceType.ROAD)
                .name("RaceName")
                .location("Location")
                .distanceKm(42.195)
                .date(new java.util.Date())
                .info("Info")
                .organizerId(123)
                .isActual(1)
                .build();
    }

    private RaceEntity createRaceEntity() {
        return RaceEntity
                .builder()
                .id(1)
                .raceType(RaceType.ROAD)
                .name("RaceName")
                .location("Location")
                .distanceKm(42.195)
                .date(new java.util.Date())
                .info("Info")
                .organizerId(123)
                .isActual(1)
                .build();
    }
}
