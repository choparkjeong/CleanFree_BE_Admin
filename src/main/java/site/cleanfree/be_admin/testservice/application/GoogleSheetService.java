package site.cleanfree.be_admin.testservice.application;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import site.cleanfree.be_admin.testservice.domain.CarryCabin;
import site.cleanfree.be_admin.testservice.domain.CarryCabinAccess;
import site.cleanfree.be_admin.testservice.domain.Consultant;
import site.cleanfree.be_admin.testservice.domain.ConsultantAccess;
import site.cleanfree.be_admin.testservice.domain.CookingStation;
import site.cleanfree.be_admin.testservice.domain.CookingStationAccess;
import site.cleanfree.be_admin.testservice.domain.Cozyquick;
import site.cleanfree.be_admin.testservice.domain.CozyquickAccess;
import site.cleanfree.be_admin.testservice.dto.GoogleSheetResponseDto;
import site.cleanfree.be_admin.testservice.infrastructure.CarryCabinAccessRepository;
import site.cleanfree.be_admin.testservice.infrastructure.CarryCabinRepository;
import site.cleanfree.be_admin.testservice.infrastructure.ConsultantAccessRepository;
import site.cleanfree.be_admin.testservice.infrastructure.ConsultantRepository;
import site.cleanfree.be_admin.testservice.infrastructure.CookingStationAccessRepository;
import site.cleanfree.be_admin.testservice.infrastructure.CookingStationRepository;
import site.cleanfree.be_admin.testservice.infrastructure.CozyquickAccessRepository;
import site.cleanfree.be_admin.testservice.infrastructure.CozyquickRepository;

@Service
@RequiredArgsConstructor
public class GoogleSheetService {

    private final CarryCabinRepository carryCabinRepository;
    private final CarryCabinAccessRepository carryCabinAccessRepository;
    private final ConsultantRepository consultantRepository;
    private final ConsultantAccessRepository consultantAccessRepository;
    private final CookingStationRepository cookingStationRepository;
    private final CookingStationAccessRepository cookingStationAccessRepository;
    private final CozyquickRepository cozyquickRepository;
    private final CozyquickAccessRepository cozyquickAccessRepository;

    public List<GoogleSheetResponseDto> getServiceCount() {
        List<CarryCabin> carryCabins = carryCabinRepository.findAll();
        List<CarryCabinAccess> carryCabinAccesses = carryCabinAccessRepository.findAll();

        List<Consultant> consultants = consultantRepository.findAll();
        List<ConsultantAccess> consultantAccesses = consultantAccessRepository.findAll();

        List<CookingStation> cookingStations = cookingStationRepository.findAll();
        List<CookingStationAccess> cookingStationAccesses = cookingStationAccessRepository.findAll();

        List<Cozyquick> cozyquicks = cozyquickRepository.findAll();
        List<CozyquickAccess> cozyquickAccesses = cozyquickAccessRepository.findAll();

        return List.of(
            GoogleSheetResponseDto.builder()
                .service("carry cabin")
                .registerCount(carryCabins.size())
                .accessCount(carryCabinAccesses.stream()
                    .mapToInt(CarryCabinAccess::getCount)
                    .sum())
                .build(),
            GoogleSheetResponseDto.builder()
                .service("consultant")
                .registerCount(consultants.size())
                .accessCount(consultantAccesses.stream()
                    .mapToInt(ConsultantAccess::getCount)
                    .sum())
                .build(),
            GoogleSheetResponseDto.builder()
                .service("cooking station")
                .registerCount(cookingStations.size())
                .accessCount(cookingStationAccesses.stream()
                    .mapToInt(CookingStationAccess::getCount)
                    .sum())
                .build(),
            GoogleSheetResponseDto.builder()
                .service("cozy quick")
                .registerCount(cozyquicks.size())
                .accessCount(cozyquickAccesses.stream()
                    .mapToInt(CozyquickAccess::getCount)
                    .sum())
                .build()
        );
    }
}
