package site.cleanfree.be_admin.testservice.presentation;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import site.cleanfree.be_admin.testservice.application.GoogleSheetService;
import site.cleanfree.be_admin.testservice.dto.GoogleSheetResponseDto;

@RestController
@RequestMapping("/api/v1/googlesheet")
@RequiredArgsConstructor
public class GoogleSheetController {

    private final GoogleSheetService googleSheetService;

    @GetMapping("/all")
    public ResponseEntity<List<GoogleSheetResponseDto>> getServiceCount() {
        return ResponseEntity.ok(googleSheetService.getServiceCount());
    }
}
