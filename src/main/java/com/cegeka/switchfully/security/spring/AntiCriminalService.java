package com.cegeka.switchfully.security.spring;

import com.cegeka.switchfully.security.external.criminalrecord.CriminalRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class AntiCriminalService {

    private final CriminalRecordService criminalRecordService;

    @Autowired
    public AntiCriminalService(CriminalRecordService criminalRecordService) {
        this.criminalRecordService = criminalRecordService;
    }

    public boolean isNotACriminal(String userName) {
        return !criminalRecordService.hasCriminalRecord(userName).isDidJailTime();
    }
}
