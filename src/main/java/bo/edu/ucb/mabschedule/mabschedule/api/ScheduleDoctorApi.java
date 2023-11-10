package bo.edu.ucb.mabschedule.mabschedule.api;

import bo.edu.ucb.mabschedule.mabschedule.bl.ScheduleDoctorBl;
import bo.edu.ucb.mabschedule.mabschedule.dto.PeriodDto;
import bo.edu.ucb.mabschedule.mabschedule.dto.ResponseDto;
import bo.edu.ucb.mabschedule.mabschedule.dto.ScheduleDoctorDto;
import bo.edu.ucb.mabschedule.mabschedule.dto.UnavailableScheduleDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/api/v1/scheduleDoctor")
public class ScheduleDoctorApi {

    private final Logger logger = LoggerFactory.getLogger(ScheduleDoctorApi.class);

    @Autowired
    private final ScheduleDoctorBl scheduleDoctorBl;

    public ScheduleDoctorApi(ScheduleDoctorBl scheduleDoctorBl) {
        this.scheduleDoctorBl = scheduleDoctorBl;
    }

    @GetMapping("/{doctorId}")
    public ResponseEntity<ResponseDto<ScheduleDoctorDto>> getScheduleDoctorByDoctorId(
            @PathVariable Integer doctorId
    ){
        logger.info("getScheduleDoctorByDoctorId");
        Date actualDate = new Date();
        ScheduleDoctorDto scheduleDoctor = scheduleDoctorBl.getScheduleDoctorByDoctorId(doctorId, actualDate);
        logger.info("scheduleDoctor: " + scheduleDoctor);
        int code = 200;
        String message = "OK";
        Boolean success = true;
        ResponseDto<ScheduleDoctorDto> response = new ResponseDto<>(success, message, code, scheduleDoctor);
        System.out.println("response: " + response);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseEntity<ResponseDto<ScheduleDoctorDto>> getScheduleDoctorByDoctorIdAndDate(
            @PathVariable Integer doctorId,
            @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date date
    ){
        logger.info("getScheduleDoctorByDoctorIdAndDate");
        ScheduleDoctorDto scheduleDoctor = scheduleDoctorBl.getScheduleDoctorByDoctorId(doctorId, date);
        logger.info("scheduleDoctor: " + scheduleDoctor);
        int code = 200;
        String message = "OK";
        Boolean success = true;
        ResponseDto<ScheduleDoctorDto> response = new ResponseDto<>(success, message, code, scheduleDoctor);
        System.out.println("response: " + response);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("unavailable-schedule/{doctorId}/{periodId}")
    public ResponseEntity<ResponseDto<ScheduleDoctorDto>> postUnavailableSchedule(
            @PathVariable Long doctorId,
            @PathVariable Long periodId,
            @RequestBody UnavailableScheduleDto unavailableScheduleDto
    ){
        logger.info("post unavailable schedule for doctor with id: " + doctorId);
        scheduleDoctorBl.postUnavailableSchedule(doctorId, periodId, unavailableScheduleDto);
        logger.info("doctor schedule updated");
        int code = 200;
        String message = "OK";
        Boolean success = true;
        ResponseDto<ScheduleDoctorDto> response = new ResponseDto<>(success, message, code, null);
        System.out.println("response: " + response);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }


}
