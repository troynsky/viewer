package ru.cbr.service;

import ma.glasnost.orika.MapperFacade;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import ru.cbr.dto.BnkseekDto;
import ru.cbr.dto.BnkseekFilter;
import ru.cbr.dto.PagingResultDto;
import ru.cbr.model.*;
import ru.cbr.repository.*;

import java.util.List;
import java.util.Objects;

@Service
public class BnkseekServiceImpl implements BnkseekService {

    @Autowired
    private BNKSEEKRepository bnkseekRepository;

    @Autowired
    private MapperFacade mapperFacade;

    @Autowired
    private REALRepository realRepository;

    @Autowired
    private PZNRepository pznRepository;

    @Autowired
    private UERRepository uerRepository;

    @Autowired
    private TNPRepository tnpRepository;

    @Autowired
    private REGRepository regRepository;

    @Override
    @Transactional(readOnly = true)
    public PagingResultDto<BnkseekDto> getBnkseekByParam(BnkseekFilter filter) {

        List<BNKSEEK> result = bnkseekRepository.getByParam(filter);
        Long total = bnkseekRepository.getCount(filter);

        List<BnkseekDto> collection = mapperFacade.mapAsList(result, BnkseekDto.class);

        return new PagingResultDto<>(collection, total);
    }

    @Override
    @Transactional
    public BnkseekDto getBnkseekById(Long id) {
        if (Objects.isNull(id)) {
            return new BnkseekDto();
        }
        BNKSEEK bnkseek = bnkseekRepository.findOne(id);

        return mapperFacade.map(bnkseek, BnkseekDto.class);
    }

    @Override
    @Transactional
    public void saveBnkseek(BnkseekDto dto) {
        BNKSEEK bnkseek;
        if (Objects.nonNull(dto.getId())) {
            bnkseek = bnkseekRepository.findOne(dto.getId());
        } else {
            bnkseek = new BNKSEEK();
            bnkseek.setVkey(RandomStringUtils.randomAlphanumeric(8));
            bnkseek.setNewnum(RandomStringUtils.randomNumeric(9));
            bnkseek.setNamen("test");
            bnkseek.setSrok("00");
        }


        REAL real = bnkseek.getReal();
        if (Objects.nonNull(dto.getReal())) {
            real = realRepository.findOne(dto.getReal().getId());
        }
        bnkseek.setReal(real);

        PZN pzn = bnkseek.getPzn();
        if (Objects.nonNull(dto.getPzn())) {
            pzn = pznRepository.findOne(dto.getPzn().getId());
        }
        bnkseek.setPzn(pzn);

        UER uer = bnkseek.getUer();
        if (Objects.nonNull(dto.getUer())) {
            uer = uerRepository.findOne(dto.getUer().getId());
        }
        bnkseek.setUer(uer);

        REG reg = bnkseek.getRgn();
        if (Objects.nonNull(dto.getRgn())) {
            reg = regRepository.findOne(dto.getRgn().getId());
        }
        bnkseek.setRgn(reg);

        TNP tnp = bnkseek.getTnp();
        if (Objects.nonNull(dto.getTnp())) {
            tnp = tnpRepository.findOne(dto.getTnp().getId());
        }
        bnkseek.setTnp(tnp);

        bnkseek.setInd(dto.getInd());
        bnkseek.setNnp(dto.getNnp());
        bnkseek.setAdr(dto.getAdr());
        bnkseek.setRkc(dto.getRkc());
        bnkseek.setNamep(dto.getNamep());
        bnkseek.setTelef(dto.getTelef());
        bnkseek.setRegn(dto.getRegn());
        bnkseek.setOkpo(dto.getOkpo());
        bnkseek.setDtIzm(dto.getDtIzm());
        bnkseek.setKsnp(dto.getKsnp());
        bnkseek.setDateIn(dto.getDateIn());
        bnkseek.setDateCh(dto.getDateCh());

        bnkseekRepository.save(bnkseek);
    }
}
