package com.epam.racecup.test;

import com.epam.racecup.mapper.ResultMapper;
import com.epam.racecup.model.ResultStatus;
import com.epam.racecup.model.dto.ResultDTO;
import com.epam.racecup.model.entity.ResultEntity;
import com.epam.racecup.repository.ResultRepository;
import com.epam.racecup.service.ResultService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.sql.Time;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class ResultServiceUnitTest {

    @Mock
    private ResultRepository resultRepository;

    @Mock
    private ResultMapper resultMapper;


    @InjectMocks
    private ResultService resultService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void saveResult() {
        ResultDTO resultDTO = buildResultDTO();
        ResultEntity resultEntity = buildResultEntity();

        when(resultMapper.dtoToEntity(resultDTO)).thenReturn(resultEntity);
        when(resultRepository.save(resultEntity)).thenReturn(resultEntity);

        resultService.saveResult(resultDTO);

        verify(resultRepository, times(1)).save(resultEntity);
    }

    @Test
    public void updateResultDnfCase() {
        ResultDTO resultDTO = buildResultDTO();
        ResultEntity resultEntity = buildResultEntity();
        List<ResultDTO> results = Collections.singletonList(resultDTO);

        when(resultService.getResultById(resultDTO.getResultId())).thenReturn(resultDTO);
        when(resultMapper.dtoToEntity(resultDTO)).thenReturn(resultEntity);
        when(resultRepository.save(resultEntity)).thenReturn(resultEntity);

        resultService.updateResult(results);

        verify(resultRepository, times(1)).save(resultEntity);
        assertEquals(ResultStatus.DNF, resultDTO.getResultStatus());
        assertNull(resultDTO.getTransitTime());
    }

    private ResultDTO buildResultDTO() {
        return ResultDTO
                .builder()
                .resultId(1)
                .transitTime(Time.valueOf("01:00:00"))
                .resultStatus(ResultStatus.DNF)
                .athlete(null)
                .race(null)
                .build();
    }

    private ResultEntity buildResultEntity() {
        return ResultEntity
                .builder()
                .resultId(1)
                .transitTime(Time.valueOf("01:00:00"))
                .resultStatus(ResultStatus.DNF)
                .athlete(null)
                .race(null)
                .build();
    }

}


