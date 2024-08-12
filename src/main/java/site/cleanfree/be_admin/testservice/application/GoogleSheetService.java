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
import site.cleanfree.be_admin.testservice.domain.CozyHouse;
import site.cleanfree.be_admin.testservice.domain.CozyHouseAccess;
import site.cleanfree.be_admin.testservice.domain.Cozyquick;
import site.cleanfree.be_admin.testservice.domain.CozyquickAccess;
import site.cleanfree.be_admin.testservice.domain.Visa;
import site.cleanfree.be_admin.testservice.domain.VisaAccess;
import site.cleanfree.be_admin.testservice.dto.GoogleSheetResponseDto;
import site.cleanfree.be_admin.testservice.infrastructure.CarryCabinAccessRepository;
import site.cleanfree.be_admin.testservice.infrastructure.CarryCabinRepository;
import site.cleanfree.be_admin.testservice.infrastructure.ConsultantAccessRepository;
import site.cleanfree.be_admin.testservice.infrastructure.ConsultantRepository;
import site.cleanfree.be_admin.testservice.infrastructure.CookingStationAccessRepository;
import site.cleanfree.be_admin.testservice.infrastructure.CookingStationRepository;
import site.cleanfree.be_admin.testservice.infrastructure.CozyHouseAccessRepository;
import site.cleanfree.be_admin.testservice.infrastructure.CozyHouseRepository;
import site.cleanfree.be_admin.testservice.infrastructure.CozyquickAccessRepository;
import site.cleanfree.be_admin.testservice.infrastructure.CozyquickRepository;
import site.cleanfree.be_admin.testservice.infrastructure.VisaAccessRepository;
import site.cleanfree.be_admin.testservice.infrastructure.VisaRepository;

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
    private final CozyHouseRepository cozyHouseRepository;
    private final CozyHouseAccessRepository cozyHouseAccessRepository;
    private final VisaRepository visaRepository;
    private final VisaAccessRepository visaAccessRepository;

    public List<GoogleSheetResponseDto> getServiceCount() {
        List<CarryCabin> carryCabins = carryCabinRepository.findAll();
        List<CarryCabinAccess> carryCabinAccesses = carryCabinAccessRepository.findAll();

        List<Consultant> consultants = consultantRepository.findAll();
        List<ConsultantAccess> consultantAccesses = consultantAccessRepository.findAll();

        List<CookingStation> cookingStations = cookingStationRepository.findAll();
        List<CookingStationAccess> cookingStationAccesses = cookingStationAccessRepository.findAll();

        List<Cozyquick> cozyquicks = cozyquickRepository.findAll();
        List<CozyquickAccess> cozyquickAccesses = cozyquickAccessRepository.findAll();

        List<CozyHouse> cozyHouses = cozyHouseRepository.findAll();
        List<CozyHouseAccess> cozyHouseAccesses = cozyHouseAccessRepository.findAll();

        List<Visa> visas = visaRepository.findAll();
        List<VisaAccess> visaAccesses = visaAccessRepository.findAll();

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
                .build(),
            GoogleSheetResponseDto.builder()
                .service("cozy house")
                .registerCount(cozyHouses.size())
                .accessCount(cozyHouseAccesses.stream()
                    .mapToInt(CozyHouseAccess::getCount)
                    .sum())
                .build(),
            GoogleSheetResponseDto.builder()
                .service("clear visa")
                .registerCount(visas.size())
                .accessCount(visaAccesses.stream()
                    .mapToInt(VisaAccess::getCount)
                    .sum())
                .build()
        );
    }
}
