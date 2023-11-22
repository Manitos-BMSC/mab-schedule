package bo.edu.ucb.mabschedule.mabschedule.service;


import bo.edu.ucb.mabschedule.mabschedule.dto.FileDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

@Service
@FeignClient("mab-file-uploader")
public interface FileUploaderService {


    @PostMapping(value = "/api/v1/files", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
    public FileDto uploadFile(@RequestPart("file") MultipartFile file,
                              @RequestParam("bucket") String bucket,
                              @RequestParam(value = "customFilename",required = false, defaultValue = "false") boolean customFilename,
                              @RequestHeader("Authorization") String token
    );


}
