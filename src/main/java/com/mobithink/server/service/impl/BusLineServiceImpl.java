package com.mobithink.server.service.impl;

import com.mobithink.server.dao.BusLigneRepository;
import com.mobithink.server.entity.BusLine;
import com.mobithink.server.service.BusLineService;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by athiel on 02/02/2017.
 */

@Component()
@Transactional
public class BusLineServiceImpl implements BusLineService {

    @Resource
    BusLigneRepository busLigneRepository;

    @Override
    public BusLine createBusLine(BusLine busLine) {
        return busLigneRepository.save(busLine);
    }

    @Override
    public List<BusLine> findOneByCityId(Long id) {
        Iterable<BusLine> busLineIterable = busLigneRepository.findByCityId(id);
        List<BusLine> busLineList = new ArrayList<>();
        if(busLineIterable != null) {
            for (BusLine busLine : busLineIterable) {
                busLineList.add(busLine);
            }
            return busLineList;
        } else return null;
    }

    @Override
    public BusLine findOneByName(String name) {
        return busLigneRepository.findOneByName(name);
    }
}
