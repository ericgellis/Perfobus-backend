package com.mobithink.server.service.impl;

import com.mobithink.server.dao.VoiceMemoRepository;
import com.mobithink.server.entity.VoiceMemo;
import com.mobithink.server.service.VoiceMemoService;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by mplaton on 29/03/2017.
 */

@Component()
@Transactional
public class VoiceMemoServiceImpl implements VoiceMemoService {

    @Resource
    VoiceMemoRepository voiceMemoRepository;

    @Override
    public VoiceMemo savedVoiceMemo(VoiceMemo voiceMemo) {
        return voiceMemoRepository.save(voiceMemo);
    }

    @Override
    public List<VoiceMemo> findByEventId(Long voiceMemoId) {
        return voiceMemoRepository.findByEventId(voiceMemoId);
    }
}
