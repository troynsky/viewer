package ru.cbr.service;

import ru.cbr.dto.BnkseekDto;
import ru.cbr.dto.BnkseekFilter;
import ru.cbr.dto.PagingResultDto;

public interface BnkseekService {

    PagingResultDto<BnkseekDto> getBnkseekByParam(BnkseekFilter filter);

    BnkseekDto getBnkseekById(Long id);

    void saveBnkseek(BnkseekDto dto);
}
