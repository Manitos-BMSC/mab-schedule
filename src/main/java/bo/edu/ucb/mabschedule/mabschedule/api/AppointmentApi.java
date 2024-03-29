package bo.edu.ucb.mabschedule.mabschedule.api;

import bo.edu.ucb.mabschedule.mabschedule.bl.AppointmentBl;
import bo.edu.ucb.mabschedule.mabschedule.dao.MedicalAppointment;
import bo.edu.ucb.mabschedule.mabschedule.dto.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.Date;
import java.util.List;

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
    public ResponseDto<ScheduleDoctorDto> postAppointmentForDoctor(
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
        return response;
    }

    @PostMapping("/patient/{pacientId}/hospital-doctor/{hospitalDoctorId}")
    public ResponseDto<MedicalAppointmentDto> postMedicalAppointment(
            @PathVariable Long pacientId,
            @PathVariable Long hospitalDoctorId,
            @RequestBody AppointmentScheduleDto appointmentScheduleDto
    ){
        logger.info("postMedicalAppointment");
        MedicalAppointmentDto medicalAppointment = appointmentBl.postMedicalAppointment(pacientId, hospitalDoctorId, appointmentScheduleDto);
        logger.info("medicalAppointment: " + medicalAppointment);
        int code = 200;
        String message = "OK";
        Boolean success = true;
        ResponseDto<MedicalAppointmentDto> response = new ResponseDto<>(success, message, code, medicalAppointment);
        System.out.println("response: " + response);
        return response;
    }

    @PostMapping("/doctor/{doctorId}/medical-appointment/{medicalAppointmentId}")
    public ResponseDto<ScheduleDoctorDto> postAppointment(
            @PathVariable Long doctorId,
            @PathVariable Long medicalAppointmentId,
            @RequestBody SchedulePeriodsDto schedulePeriodsDto
    ){
        logger.info("postAppointment");
        appointmentBl.postAppointment(doctorId, medicalAppointmentId, schedulePeriodsDto);
        logger.info("appointment created");
        int code = 200;
        String message = "OK";
        Boolean success = true;
        ResponseDto<ScheduleDoctorDto> response = new ResponseDto<>(success, message, code, null);
        System.out.println("response: " + response);
        return response;
    }

    @PostMapping("/medical-appointment/{medicalAppointmentId}/file")
    public ResponseDto<String> postFileForMedicalAppointment (
            @PathVariable Long medicalAppointmentId,
            @RequestParam("files") List<MultipartFile> files
    ){
        logger.info("postFileForMedicalAppointment");
        for (MultipartFile file : files) {
            if (!file.isEmpty()) {
                appointmentBl.postFileForMedicalAppointment(medicalAppointmentId, file);
            }
        }
        logger.info("file created");
        int code = 200;
        String message = "OK";
        Boolean success = true;
        ResponseDto<String> response = new ResponseDto<>(success, message, code, null);
        System.out.println("response: " + response);
        return response;
    }

    @GetMapping("/doctor/{doctorId}")
    public ResponseDto<List<MedicalAppointmentPatientDto>> getAppointmentForDoctor(
            @PathVariable Long doctorId,
            @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date date
    ){
        logger.info("getAppointmentForDoctor");
        List<MedicalAppointmentPatientDto> medicalAppointmentsDto = appointmentBl.getAppointmentForDoctor(doctorId, date);
        logger.info("medicalAppointmentDto: " + medicalAppointmentsDto);
        int code = 200;
        String message = "OK";
        Boolean success = true;
        ResponseDto<List<MedicalAppointmentPatientDto>> response = new ResponseDto<>(success, message, code, medicalAppointmentsDto);
        System.out.println("response: " + response);
        return response;
    }

    @GetMapping("/patient/{patientId}")
    public ResponseDto<List<MedicalAppointmentPlaceTimeDto>> getAppointmentForPatient(
            @PathVariable Long patientId,
            @RequestParam @DateTimeFormat(pattern = "dd-MM-yyyy") Date date
    ){
        logger.info("getAppointmentForPatient");
        List<MedicalAppointmentPlaceTimeDto> medicalAppointmentsDto = appointmentBl.getAppointmentForPatient(patientId, date);
        logger.info("medicalAppointmentDto: " + medicalAppointmentsDto);
        int code = 200;
        String message = "OK";
        Boolean success = true;
        ResponseDto<List<MedicalAppointmentPlaceTimeDto>> response = new ResponseDto<>(success, message, code, medicalAppointmentsDto);
        System.out.println("response: " + response);
        return response;
    }
}

