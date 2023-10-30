package bo.edu.ucb.mabschedule.mabschedule.bl;

import bo.edu.ucb.mabschedule.mabschedule.dao.Period;
import bo.edu.ucb.mabschedule.mabschedule.dao.repository.PeriodRepository;
import bo.edu.ucb.mabschedule.mabschedule.dto.PeriodDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PeriodBl {

    private final PeriodRepository periodRepository;
    private final Logger logger = LoggerFactory.getLogger(PeriodBl.class);

    @Autowired
    public PeriodBl (PeriodRepository periodRepository){
        this.periodRepository = periodRepository;
    }

    public List<PeriodDto> getAllPeriods(){
        logger.info("Initializing getAllPeriods");
         List<Period> periods =  periodRepository.findAllOrderByMabWeekDayId();
         logger.info("periods: " + periods);
         return PeriodDto.fromEntityList(periods);
    }


}
