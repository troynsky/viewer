package ru.cbr.repository;

import ru.cbr.dto.BnkseekFilter;
import ru.cbr.model.BNKSEEK;

import java.util.List;

public interface BNKSEEKRepositoryCustom {
    List<BNKSEEK> getByParam(BnkseekFilter filter);
    Long getCount(BnkseekFilter filter);
}
