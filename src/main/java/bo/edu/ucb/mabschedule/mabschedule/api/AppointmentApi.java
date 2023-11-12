package bo.edu.ucb.mabschedule.mabschedule.api;

import bo.edu.ucb.mabschedule.mabschedule.bl.AppointmentBl;
import bo.edu.ucb.mabschedule.mabschedule.dto.MedicalAppointmentDto;
import bo.edu.ucb.mabschedule.mabschedule.dto.ResponseDto;
import bo.edu.ucb.mabschedule.mabschedule.dto.ScheduleDoctorDto;
import bo.edu.ucb.mabschedule.mabschedule.dto.ScheduleDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/api/v1/appointment")
public class AppointmentApi {

    private final Logger logger = LoggerFactory.getLogger(AppointmentApi.class);
    @Autowired
    private final AppointmentBl appointmentBl;

    public AppointmentApi(AppointmentBl appointmentBl) {
        this.appointmentBl = appointmentBl;
    }

    @PostMapping("/doctor/{doctorId}/period/{periodId}/medical-appointment/{medicalAppointmentId}")
    public ResponseEntity<ResponseDto<ScheduleDoctorDto>> postAppointmentForDoctor(
            @PathVariable Long doctorId,
            @PathVariable Long periodId,
            @PathVariable Long medicalAppointmentId,
            @RequestBody ScheduleDto scheduleDto
            ){
        logger.info("postAppointmentForDoctor");
        appointmentBl.postAppointmentForDoctor(doctorId, periodId, medicalAppointmentId, scheduleDto);
        int code = 200;
        String message = "OK";
        Boolean success = true;
        ResponseDto<ScheduleDoctorDto> response = new ResponseDto<>(success, message, code, null);
        System.out.println("response: " + response);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/patient/{pacientId}/hospital-doctor/{hospitalDoctorId}")
    public ResponseDto<MedicalAppointmentDto> postMedicalAppointment(
            @PathVariable Long pacientId,
            @PathVariable Long hospitalDoctorId,
            @RequestBody MedicalAppointmentDto medicalAppointmentDto
    ){
        logger.info("postMedicalAppointment");
        MedicalAppointmentDto medicalAppointment = appointmentBl.postMedicalAppointment(pacientId, hospitalDoctorId, medicalAppointmentDto);
        logger.info("medicalAppointment: " + medicalAppointment);
        int code = 200;
        String message = "OK";
        Boolean success = true;
        ResponseDto<MedicalAppointmentDto> response = new ResponseDto<>(success, message, code, medicalAppointment);
        System.out.println("response: " + response);
        return response;
    }

}
