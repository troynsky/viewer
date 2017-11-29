package ru.cbr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import ru.cbr.dto.*;
import ru.cbr.model.*;
import ru.cbr.repository.*;

import java.util.List;
import java.util.stream.Collectors;

@Controller
public class CommonController {

    @Autowired
    BNKSEEKRepository bnkseekRepository;

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

    @RequestMapping(value = "/common/pzns", method = RequestMethod.GET)
    @ResponseBody
    public List<PznDto> getPzns() {
        return ((List<PZN>) pznRepository.findAll())
                .stream()
                .map(item -> new PznDto(item.getId(), item.getName()))
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/common/reals", method = RequestMethod.GET)
    @ResponseBody
    public List<RealDto> getReals() {
        return ((List<REAL>) realRepository.findAll())
                .stream()
                .map(item -> new RealDto(item.getId(), item.getReal()))
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/common/uers", method = RequestMethod.GET)
    @ResponseBody
    public List<UerDto> getUers() {
        return ((List<UER>) uerRepository.findAll())
                .stream()
                .map(item -> new UerDto(item.getId(), item.getUerName()))
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/common/rgns", method = RequestMethod.GET)
    @ResponseBody
    public List<RgnDto> getRgns() {
        return ((List<REG>) regRepository.findAll())
                .stream()
                .map(item -> new RgnDto(item.getId(), item.getName()))
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/common/tnps", method = RequestMethod.GET)
    @ResponseBody
    public List<TnpDto> getTnps() {
        return ((List<TNP>) tnpRepository.findAll())
                .stream()
                .map(item -> new TnpDto(item.getId(), item.getFullName()))
                .collect(Collectors.toList());
    }
}
