package ru.cbr.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.cbr.dto.BnkseekDto;
import ru.cbr.dto.BnkseekFilter;
import ru.cbr.dto.PagingResultDto;
import ru.cbr.repository.BNKSEEKRepository;
import ru.cbr.service.BnkseekService;

@Controller
public class ViewerController {

    @Autowired
    private BnkseekService bnkseekService;

    @Autowired
    BNKSEEKRepository bnkseekRepository;

    @RequestMapping(value = "/viewer/bnkseeks", method = RequestMethod.POST)
    @ResponseBody
    public PagingResultDto<BnkseekDto> getBnkseeks(@RequestBody BnkseekFilter filter) {
        return bnkseekService.getBnkseekByParam(filter);
    }

    @RequestMapping(value = "/bnkseek", method = RequestMethod.GET)
    @ResponseBody
    public BnkseekDto getBnkSeekDtoById(@RequestParam(name = "id", required = false) Long id) {
        return bnkseekService.getBnkseekById(id);
    }

    @RequestMapping(value = "/bnkseek", method = RequestMethod.POST)
    @ResponseBody
    public void save(@RequestBody BnkseekDto dto) {
        bnkseekService.saveBnkseek(dto);
    }

    @RequestMapping(value = "/remove/bnkseek", method = RequestMethod.GET)
    @ResponseBody
    public void removeBnkseek(@RequestParam Long id) {
        bnkseekRepository.delete(id);
    }

}
