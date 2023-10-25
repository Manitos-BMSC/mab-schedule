package bo.edu.ucb.mabschedule.mabschedule.api;

import bo.edu.ucb.mabschedule.mabschedule.bl.PeriodBl;
import bo.edu.ucb.mabschedule.mabschedule.dto.PeriodDto;
import bo.edu.ucb.mabschedule.mabschedule.dto.ResponseDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/period")
public class PeriodApi {

    private final Logger logger = LoggerFactory.getLogger(PeriodApi.class);
    private final PeriodBl periodBl;
    @Autowired
    public PeriodApi(PeriodBl periodBl) {
        this.periodBl = periodBl;
    }

    @GetMapping("/periods")
    public ResponseEntity<ResponseDto<List<PeriodDto>>> findAllPeriods(){
        logger.info("findAllPeriods");
        List<PeriodDto> periodDtoList = periodBl.getAllPeriods();
        logger.info("periodDtoList: " + periodDtoList);
        int code = 200;
        String message = "OK";
        Boolean success = true;
        ResponseDto<List<PeriodDto>> response = new ResponseDto<>(success, message, code, periodDtoList);
        System.out.println("response: " + response);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

}
